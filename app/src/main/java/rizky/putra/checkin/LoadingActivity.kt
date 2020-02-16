package rizky.putra.checkin

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import kotlinx.android.synthetic.main.activity_loading.*

class LoadingActivity : AppCompatActivity() {

    val KEY_STATUS = "status"

    lateinit var waitTimer: CountDownTimer
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_loading)
        waitTimer = object: CountDownTimer(5000,10){
        override fun onTick(millisUntilFinished: Long) {
            progressBar.scaleY = 3.0f
            progressBar.progressDrawable.setColorFilter(Color.parseColor("#C4C4C4"), android.graphics.PorterDuff.Mode.SRC_IN)
            progressBar.max = 5000
            progressBar.progress = (5000-millisUntilFinished).toInt()
        }

        override fun onFinish() {
            setResult(Activity.RESULT_OK)
            this@LoadingActivity.finish()
        }
        }.start()

        txt_cancel.setOnClickListener {
            waitTimer.cancel()
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }


}
