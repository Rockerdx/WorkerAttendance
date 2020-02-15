package rizky.putra.checkin.network

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import rizky.putra.checkin.model.LoginResponse

interface ApiService {

    @POST("auth/login")
    fun sendLogin(@Body username: String, @Body password: String): Observable<LoginResponse>

    @GET("staff-requests/26074/")
    fun getStaffInfo()

    @POST("staff-requests/26074/clock-in/")
    fun sendClockIn(@Body latitude: String, @Body longitute: String): Observable<String>

    @POST("staff-requests/26074/clock-out/")
    fun sendClockOut(@Body latitude: String, @Body longitute: String): Observable<String>
}