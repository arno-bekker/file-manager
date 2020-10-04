package com.mycompany.util;

import com.mycompany.exception.InvalidDirectoryException;
import com.mycompany.model.FileModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class FileManagerUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FileManagerUtil.class);

    // Limit to 20M
    private static final int maxSize = Integer.MAX_VALUE / 100;

    public static List<FileModel> fileRead(String filePath, int page, int size) throws IOException {

        int i = 1;
        int start = 1;
        int end = size;

        // Find the start and end position if it is not the first page
        if (page > 1) {
            start = ((page - 1) * size) + 1;
            end = start + size - 1;
        }
        LOG.debug("start: " + start + " end : " + end);
        long startTime = System.currentTimeMillis();

        List<FileModel> list = new LinkedList<>();
        Path dir = FileSystems.getDefault().getPath(filePath);
        DirectoryStream<Path> stream = null;

        try {
            stream = Files.newDirectoryStream(dir);
        } catch (java.nio.file.NoSuchFileException e) {
            LOG.error("NoSuchFileException: {}", filePath, e);
            throw new InvalidDirectoryException("Path does not exist: " + filePath);
        } catch (java.nio.file.NotDirectoryException e) {
            LOG.error("NotDirectoryException: {}", filePath, e);
            throw new InvalidDirectoryException("Path not a directory: " + filePath);
        }

        for (Path path : stream) {
            // Skip these records, they are in the previous pages. Maybe not the best way to go about this.
            if (i < start) {
                i++;
                continue;
            }

            File file = path.toFile();
            LOG.trace("" + i + " : " + path.getFileName() + " " + file.length());

            FileModel fileModel = new FileModel(file.getAbsolutePath(), file.length(), file.canRead(), file.canWrite(), file.canExecute(), Files.getOwner(path).getName());
            list.add(fileModel);

            // This is the last record on the page
            if (i == end)
                break;

            // Stop if for some reason we go past the max size
            if (++i > maxSize)
                break;
        }

        stream.close();

        long stopTime = System.currentTimeMillis();
        LOG.debug("Elapsed: " + (stopTime - startTime) + " ms");


        return list;
    }
}
