package rizky.putra.checkin.model

import com.google.gson.annotations.SerializedName

data class ClockInResponse (

    @SerializedName("id") val id : Int,
    @SerializedName("clock_in_time") val clock_in_time : String,
    @SerializedName("clock_out_time") val clock_out_time : String,
    @SerializedName("clock_in_latitude") val clock_in_latitude : Double,
    @SerializedName("clock_in_longitude") val clock_in_longitude : Double,
    @SerializedName("clock_out_latitude") val clock_out_latitude : String,
    @SerializedName("clock_out_longitude") val clock_out_longitude : String,
    @SerializedName("schedule") val schedule : String,
    @SerializedName("code") val code : String,
    @SerializedName("detail") val detail : String
)