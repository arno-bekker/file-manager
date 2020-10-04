package com.mycompany.controller;

import com.google.common.collect.ImmutableMap;
import com.mycompany.model.DirectoryListResponse;
import com.mycompany.model.FileModel;
import com.mycompany.util.FileManagerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/directory")
public class FileManagerController {

    private static final Logger LOG = LoggerFactory.getLogger(FileManagerController.class);

    @RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> listDirectoryContent(@RequestParam("path") String path,
                                              @RequestParam("size") int size,
                                              @RequestParam("page") int page) throws IOException {

        LOG.debug("listDirectoryContent - path: {}, size: {}, page: {}", path, size, page);

        if (page == 0){
            page = 1;
        }

        List<FileModel> list = FileManagerUtil.fileRead(path, page, size);
        LOG.trace("Size: {}", list.size());

        DirectoryListResponse response = new DirectoryListResponse(list.size(), size, page, list);

        return ResponseEntity.ok().body(response);
    }

}