package rizky.putra.checkin.presenter

import android.content.Context
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rizky.putra.checkin.model.LoginResponse
import rizky.putra.checkin.network.DataSource


class MainPresenter(view: MainPresenter.View) {

    private val composite = CompositeDisposable()

    internal var view: View

    interface View {
        fun onLoginSuccess(response: LoginResponse)

        fun onLoginFailed(throwable: Throwable)
    }

    init {
        this.view = view
    }

    fun sendLogin(context: Context, username: String, password: String) {
        DataSource.getService().sendLogin(username,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoginResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    composite.add(d)
                }

                override fun onNext(t: LoginResponse) {

                }

                override fun onError(e: Throwable) {

                }


            })
    }
}
