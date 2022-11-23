package com.example.juegodel21;

import java.util.List;

public class ganadores {
    private String status;
    private List<data> data;

    public ganadores(String status, List<com.example.juegodel21.data> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<com.example.juegodel21.data> getData() {
        return data;
    }

    public void setData(List<com.example.juegodel21.data> data) {
        this.data = data;
    }
}
