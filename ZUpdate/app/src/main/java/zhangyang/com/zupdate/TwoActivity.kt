package zhangyang.com.zupdate

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import com.zhangyang.zupdate.R
import kotlinx.android.synthetic.main.activity_two.*

/**

* @Description:   第二个的界面
* @Author:         sun
* @CreateDate:     2019/4/6 19:49
* @UpdateUser:     yc
* @UpdateDate:     2019/4/6 19:49
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
class TwoActivity:Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        btnok.setOnClickListener({
            Toast.makeText(this@TwoActivity,"我是来自第二个界面",Toast.LENGTH_SHORT).show()
        })

        btn_gengxin.setOnClickListener({
            Toast.makeText(this@TwoActivity,"干嘛点我....",Toast.LENGTH_SHORT).show()
        })
    }
}