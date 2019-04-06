package com.tx.apkupdate;

import java.io.Serializable;

public class UpdateFile implements Serializable {

    private boolean isPatch;
    private String downloadUrl;
    private long size;

    public UpdateFile(boolean isPatch, String downloadUrl, long size) {
        this.isPatch = isPatch;
        this.downloadUrl = downloadUrl;
        this.size = size;
    }

    public boolean isPatch() {
        return isPatch;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public long getSize() {
        return size;
    }
}
