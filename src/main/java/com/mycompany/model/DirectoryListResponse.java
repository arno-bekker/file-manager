package com.mycompany.model;

import java.util.List;

public class DirectoryListResponse {

    Integer totalReturned;
    Integer size;
    Integer page;
    List<FileModel> list;

    public DirectoryListResponse(Integer totalReturned, Integer size, Integer page, List<FileModel> list) {
        this.list = list;
        this.totalReturned = totalReturned;
        this.size = size;
        this.page = page;
    }

    public Integer getTotalReturned() {
        return totalReturned;
    }

    public void setTotalReturned(Integer totalReturned) {
        this.totalReturned = totalReturned;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<FileModel> getList() {
        return list;
    }

    public void setList(List<FileModel> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DirectoryListResponse{" +
                "totalReturned=" + totalReturned +
                ", size=" + size +
                ", page=" + page +
                ", list=" + list +
                '}';
    }
}
