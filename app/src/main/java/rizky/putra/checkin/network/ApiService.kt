package rizky.putra.checkin.network

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import rizky.putra.checkin.model.*

interface ApiService {

    @Headers("Content-Type: application/json")
    @POST("auth/login/")
    fun sendLogin(@Body params: LoginParams): Observable<LoginResponse>

    @GET("staff-requests/26074/")
    fun getStaffInfo(): Observable<StaffInfoResponse>

    @POST("staff-requests/26074/clock-in/")
    fun sendClockIn(@Body params: ClockInParams): Observable<ClockInResponse>

    @POST("staff-requests/26074/clock-out/")
    fun sendClockOut(@Body params: ClockInParams): Observable<ClockOutResponse>
}