package com.tx.apkupdate;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class UpdateInfo {

    /**
     * 强制更新，只显示一个下载更新的按钮。
     */
    public static final int FLAG_FORCE_UPDATE = 0;

    /**
     * 选择更新，显示以后再说和下载更新的按钮。
     */
    public static final int FLAG_CHOOSE_UPDATE = 1;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({FLAG_FORCE_UPDATE, FLAG_CHOOSE_UPDATE})
    public @interface UpdateFlag {
    }

    /**
     * 版本名，如"v1.0.0"。
     */
    private String versionname;

    /**
     * 全量包的下载地址。
     */
    private String apk_download;

    /**
     * 更新的标志位，0代表强制更新，1代表选择更新。
     */
    private int update;

    /**
     * 更新日志。
     */
    private String content;

    /**
     * 版本号，如1、2、3...
     */
    private int versioncode;

    /**
     * 补丁下载地址。
     */
    private String patch_download;

    private String app_url;

    private List<CustomerInfo> contacts;

    public List<CustomerInfo> getContacts() {
        return contacts;
    }

    public void setContacts(List<CustomerInfo> contacts) {
        this.contacts = contacts;
    }

    public String getApp_url() {
        return app_url;
    }

    public void setApp_url(String app_url) {
        this.app_url = app_url;
    }

    public String getVersionName() {
        return versionname;
    }

    public String getApkFileDownloadURL() {
        return apk_download;
    }

    public @UpdateFlag
    int getUpdateFlag() {
        return update;
    }

    public String getContent() {
        return content;
    }

    public int getVersionCode() {
        return versioncode;
    }

    public String getPatchFileDownloadURL() {
        return patch_download;
    }

    /**
     * 检测json内容的有效性。
     *
     * @return true代表有效，可以使用这些信息更新， false反之
     */
    /**
     * 检测json内容的有效性。
     *
     * @return true代表有效，可以使用这些信息更新， false反之
     */
    public boolean valid() {
        return com.lwh.jackknife.util.TextUtils.checkNotEmpty(versionname, apk_download, content, patch_download) &&
                (update == 0 || update == 1) && versioncode >= 1;
    }
    private String OnlineService="";//在线客服地址
    private String QQServer="";//在线客服qq
    private String QQAgent="";//在线代理qq
    private String Email="";//在线邮箱
    private String Wechat="";//在线微信号

    public String getOnlineService() {
        return OnlineService;
    }

    public void setOnlineService(String onlineService) {
        OnlineService = onlineService;
    }

    public String getQQServer() {
        return QQServer;
    }

    public void setQQServer(String QQServer) {
        this.QQServer = QQServer;
    }

    public String getQQAgent() {
        return QQAgent;
    }

    public void setQQAgent(String QQAgent) {
        this.QQAgent = QQAgent;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getWechat() {
        return Wechat;
    }

    public void setWechat(String wechat) {
        Wechat = wechat;
    }
}
