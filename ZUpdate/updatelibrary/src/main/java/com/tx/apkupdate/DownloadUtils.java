package com.tx.apkupdate;

import android.support.annotation.WorkerThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 下载更新的工具。
 */
public class DownloadUtils {

    private static DownloadUtils sInstance;

    /**
     * 记录上次的百分比，避免过度绘制，只有当进度变化时才会重新回调onDownloadProgress。
     */
    private float mLastPercent;

    private DownloadUtils() {
    }

    private static DownloadUtils getInstance() {
        if (sInstance == null) {
            synchronized (DownloadUtils.class) {
                if (sInstance == null) {
                    sInstance = new DownloadUtils();
                }
            }
        }
        return sInstance;
    }

    /**
     * 下载文件
     *
     * @param downloadUrl 文件的下载链接
     * @param dstFileDir  下载到的目录
     * @param dstFileName 下载保存的文件名
     * @param listener    下载监听器
     */
    @WorkerThread
    public static void download(String downloadUrl, String dstFileDir, String dstFileName,
                                OnDownloadListener listener) {
        getInstance()._download(downloadUrl, dstFileDir, dstFileName, listener);
    }

    private void _download(String downloadUrl, String dstFileDir, String dstFileName,
                           OnDownloadListener listener) {
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.addRequestProperty("Accept-Encoding", "identity");
            conn.setConnectTimeout(3000);   //下载的连接超时为3秒
            conn.setReadTimeout(10000);     //读取数据超时为10秒
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                long total = conn.getContentLength();
                is = conn.getInputStream();
                byte[] buf = new byte[2048];
                int len;
                File dir = new File(dstFileDir);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File file = new File(dir, dstFileName);
                fos = new FileOutputStream(file);
                long sum = 0;
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                    sum += len;
                    float progress = sum * 1.0f / total * 100;
                    if (progress - mLastPercent >= 0.1f) {  //避免过度绘制，当绘制一帧画面超过16ms时，会丢帧，即达不到标准的60FPS
                        listener.onDownloadProgress(progress);
                        mLastPercent = progress;
                    }
                }
                fos.flush();
                mLastPercent = 0;
                listener.onDownloadSuccess(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            listener.onDownloadFailure(e);
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

