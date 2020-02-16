package rizky.putra.checkin.presenter

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import rizky.putra.checkin.model.*
import rizky.putra.checkin.network.DataSource
import rizky.putra.checkin.utils.LoginDataManager


class MainPresenter(internal var view: View) {

    private val composite = CompositeDisposable()

    interface View {
        fun onLoginSuccess(response: LoginResponse)

        fun onLoginFailed(throwable: Throwable)

        fun onGetInfoSuccess(response: StaffInfoResponse)

        fun onGetInfoFailed(throwable: Throwable)

        fun onClockInSuccess(response: ClockInResponse)

        fun onClockInFailed(throwable: Throwable)

        fun onClockOutSuccess(response: ClockOutResponse)

        fun onClockOutFailed(throwable: Throwable)
    }

    fun sendLogin(context: Context, username: String, password: String) {
        DataSource.getService(context).sendLogin(LoginParams(username,password))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<LoginResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    composite.add(d)
                }

                override fun onNext(t: LoginResponse) {
                    Log.d(TAG,"login success, key : "  + t.key)
                    LoginDataManager.setKey(context,t.key)
                    view.onLoginSuccess(t)
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG,"login failed")
                    view.onLoginFailed(e)
                }


            })
    }

    fun getStaffInfo(context: Context) {
        DataSource.getService(context).getStaffInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<StaffInfoResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    composite.add(d)
                }

                override fun onNext(t: StaffInfoResponse) {
                    Log.d(TAG,"fetch success")
                    view.onGetInfoSuccess(t)
                }

                override fun onError(e: Throwable) {
                    view.onGetInfoFailed(e)
                }


            })
    }
    fun doClickIn(context: Context,lat: String, lng:String) {
        DataSource.getService(context).sendClockIn(ClockInParams(lat,lng))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ClockInResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    composite.add(d)
                }

                override fun onNext(t: ClockInResponse) {
                    Log.d(TAG,"fetch success")
                    view.onClockInSuccess(t)
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG,"error " + e.message)
                    view.onClockInFailed(e)
                }


            })
    }


    fun doClickOut(context: Context,lat: String, lng:String) {
        DataSource.getService(context).sendClockOut(ClockInParams(lat,lng))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ClockOutResponse> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                    composite.add(d)
                }

                override fun onNext(t: ClockOutResponse) {
                    Log.d(TAG,"fetch success")
                    view.onClockOutSuccess(t)
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG,"error " + e.message)

                    view.onClockOutFailed(e)
                }


            })
    }
}
