package com.mycompany.model;

public class FileModel {

    private String absolutePath;
    private Long fileSize;
    private final Boolean canRead;
    private final Boolean canWrite;
    private final Boolean canExecute;
    private String owner;

    public FileModel(String absolutePath, Long fileSize, Boolean canRead, Boolean canWrite, Boolean canExecute, String owner) {
        this.absolutePath = absolutePath;
        this.fileSize = fileSize;
        this.canRead = canRead;
        this.canWrite = canWrite;
        this.canExecute = canExecute;
        this.owner = owner;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getReadWriteExecute() {
        return (this.canRead ? "r" : "-") +
                (this.canWrite ? "w" : "-") +
                (this.canExecute ? "x" : "-");
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "absolutePath='" + absolutePath + '\'' +
                ", fileSize=" + fileSize +
                ", canRead=" + canRead +
                ", canWrite=" + canWrite +
                ", canExecute=" + canExecute +
                ", owner='" + owner + '\'' +
                '}';
    }

}
