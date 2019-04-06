package com.tx.apkupdate;

import java.io.File;

public interface OnDownloadListener {

    /**
     * 下载成功
     *
     * @param file 下载的文件
     */
    void onDownloadSuccess(File file);

    /**
     * 下载中的进度
     *
     * @param progress 进度百分比，0.0~100.0
     */
    void onDownloadProgress(float progress);

    /**
     * 下载失败
     */
    void onDownloadFailure(Exception e);
}
