package zhangyang.com.zupdate

import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast

import com.tx.apkupdate.PatchUtils
import com.zhangyang.zupdate.R
import kotlinx.android.synthetic.main.activity_main.*
import zhangyang.com.zupdate.util.UpdateUtils

/**
* @Description:   主界面
* @Author:         sun
* @CreateDate:     2019/4/6 14:22
* @UpdateUser:     yc
* @UpdateDate:     2019/4/6 14:22
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_gengxin.setOnClickListener({
            //处理 更新
            UpdateUtils.doUpdateProcess(UpdateUtils.OLD_PATH,UpdateUtils.PATCH_PATH,this)
        })

        btnok.setOnClickListener({
            startActivity(Intent(this@MainActivity,TwoActivity::class.java))
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        println("fixPatchProcess onRequestPermissionsResult .....")
        if(requestCode==UpdateUtils.STORAGE_REQUEST_CODE){
            println("fixPatchProcess onRequestPermissionsResult Result ...... ")
            if(grantResults!=null && grantResults.get(0)==PackageManager.PERMISSION_GRANTED){
                UpdateUtils.doUpdateProcess(UpdateUtils.OLD_PATH,UpdateUtils.PATCH_PATH,this)
            }else{
                println("fixPatchProcess onRequestPermissionsResult noResult ...... ")
            }
        }
    }
}
