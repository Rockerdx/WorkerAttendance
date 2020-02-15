package rizky.putra.checkin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import rizky.putra.checkin.model.LoginResponse
import rizky.putra.checkin.presenter.MainPresenter

class MainActivity : AppCompatActivity(),MainPresenter.View {
    override fun onLoginSuccess(response: LoginResponse) {

    }

    override fun onLoginFailed(throwable: Throwable) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}