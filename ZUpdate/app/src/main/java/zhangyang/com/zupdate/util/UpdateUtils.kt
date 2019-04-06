package zhangyang.com.zupdate.util

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Environment
import android.os.SystemClock
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.tx.apkupdate.PatchUtils
import java.io.File
import java.util.jar.Manifest

/**

* @Description:   更新的工具类
* @Author:         sun
* @CreateDate:     2019/4/6 17:12
* @UpdateUser:     yc
* @UpdateDate:     2019/4/6 17:12
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
object UpdateUtils {

    /**
     * 存储的权限。
     */
    private val PERMISSIONS_STORAGE = arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                                                    android.Manifest.permission.READ_EXTERNAL_STORAGE)

    val STORAGE_REQUEST_CODE=100;
    val APK_UPDATE="UPDATE_PATCH"
    val PATCH_PATH=Environment.getExternalStorageDirectory().absolutePath+ File.separator+APK_UPDATE+File.separator+"new.patch"
    val OLD_PATH=Environment.getExternalStorageDirectory().absolutePath+ File.separator+APK_UPDATE+File.separator+"old.apk"

    /**
     * 处理更新的逻辑
     */
    fun  doUpdateProcess(oldApkPath:String,patchPath:String,activity:Activity){

          if (ContextCompat.checkSelfPermission(activity,android.Manifest.permission.READ_EXTERNAL_STORAGE)
                                                                                        !=PackageManager.PERMISSION_GRANTED){

                   //检测 该权限 没有被允许
                   ActivityCompat.requestPermissions(activity,PERMISSIONS_STORAGE,STORAGE_REQUEST_CODE)
          }else{
                //权限 ok 处理逻辑
              fixPatchProcess(File(oldApkPath),File(patchPath))
          }
    }


    /**
     * 处理 patch 的逻辑
     */
    private  fun fixPatchProcess(oldApkFile: File, patchFile: File) {
         //新的apk的位置
         var newFilePath=Environment.getExternalStorageDirectory().absolutePath+File.separator+APK_UPDATE+File.separator+"newPatch.apk"
        if(!File(newFilePath).parentFile.exists()){
            //创建目录
            File(newFilePath).parentFile.mkdir()
        }

        //处理patch
        val ret = PatchUtils.fixPatch(oldApkFile.getAbsolutePath(), newFilePath, patchFile.absolutePath)
        if (ret == 0) {
            val file = File(newFilePath)   //新版本apk文件
            if (file.exists()) {    //新版本apk文件合成成功
               println("fixPatchProcess successs ")
            }else{
                println("fixPatchProcess failer 111")
            }
        }else{
            println("fixPatchProcess failer 2222")
        }
    }
}