package com.tx.apkupdate;

public class PatchUtils {

    public native static int fixPatch(String oldApkPath, String newApkPath, String patchPath);

    static {
        System.loadLibrary("txPatch");
    }
}
