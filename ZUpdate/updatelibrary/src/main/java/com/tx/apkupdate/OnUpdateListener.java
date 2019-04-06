package com.tx.apkupdate;

import android.content.Context;

public interface OnUpdateListener {

    void onUpdate(Context context, UpdateFile file, String versionName,
                  boolean forceUpdate, String content);

    void onCancelUpdate();
}
