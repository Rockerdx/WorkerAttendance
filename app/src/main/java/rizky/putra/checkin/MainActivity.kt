package rizky.putra.checkin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import rizky.putra.checkin.model.ClockInResponse
import rizky.putra.checkin.model.ClockOutResponse
import rizky.putra.checkin.model.LoginResponse
import rizky.putra.checkin.model.StaffInfoResponse
import rizky.putra.checkin.presenter.MainPresenter
import rizky.putra.checkin.utils.LoginDataManager
import rizky.putra.checkin.utils.formatDate

class MainActivity : AppCompatActivity(),MainPresenter.View {


    val CODE_CHECKIN = 20
    val CODE_CHECKOUT = 20
    var isLogin = false
    private val presenter: MainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        isLogin = LoginDataManager.getLogin(this)!!
        if(isLogin){
            btn_clock.text = "Check Out"
            txt_clock_out.text = "-"
        }else{
            btn_clock.text = "Check In"
            txt_clock_out.text = "-"
            txt_clock_in.text = "-"
        }

        presenter.sendLogin(this@MainActivity,"+6281313272005","alexander")
        btn_clock.setOnClickListener {
            if(isLogin) {
                Log.d("tes","checkin out")
                startActivityForResult(
                    Intent(this@MainActivity, LoadingActivity::class.java),
                    CODE_CHECKOUT
                )
            }
            else{
                Log.d("tes","checkin in")
                startActivityForResult(
                    Intent(this@MainActivity, LoadingActivity::class.java),
                    CODE_CHECKIN
                )
            }
        }
    }

    override fun onLoginSuccess(response: LoginResponse) {
        presenter.getStaffInfo(this@MainActivity)
    }

    override fun onLoginFailed(throwable: Throwable) {
    }
    override fun onClockInSuccess(response: ClockInResponse) {
        txt_clock_in.text = formatDate(response.clock_in_time)
        btn_clock.text = "Check Out"
        isLogin = true
        LoginDataManager.setLogin(this,true)
    }

    override fun onClockInFailed(throwable: Throwable) {
        presenter.doClickOut(this@MainActivity,"-6.2446691","106.8779625")
    }

    override fun onClockOutSuccess(response: ClockOutResponse) {
        txt_clock_out.text = formatDate(response.timesheet.clock_out_time)
        btn_clock.text = "Check In"
        isLogin = false
        LoginDataManager.setLogin(this,false)
    }

    override fun onClockOutFailed(throwable: Throwable) {

    }

    override fun onGetInfoSuccess(response: StaffInfoResponse) {
        txt_job_name.text = response.position.name
        txt_job_wage.text = response.wage_amount.toString()
        txt_job_rate.text = response.wage_type
        txt_job_location.text = response.location.address.street_1
        txt_job_place.text = response.client.name
        txt_manager_name.text = response.manager?.name
        txt_contact_number.text = response.manager?.phone

    }

    override fun onGetInfoFailed(throwable: Throwable) {
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CODE_CHECKIN) {
            if(resultCode == Activity.RESULT_OK){
                presenter.doClickIn(this@MainActivity,"-6.2446691","106.8779625")
                Log.d("tes","do checkin in")
            }
        }else if(requestCode == CODE_CHECKOUT){
            if(resultCode == Activity.RESULT_OK){
                presenter.doClickOut(this@MainActivity,"-6.2446691","106.8779625")
                Log.d("tes","do checkin out")
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}