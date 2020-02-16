package rizky.putra.checkin.model

import com.google.gson.annotations.SerializedName


data class ClockOutResponse (

    @SerializedName("timesheet") val timesheet : Timesheet,
    @SerializedName("require_feedback") val require_feedback : Boolean
)

data class Timesheet (

    @SerializedName("id") val id : Int,
    @SerializedName("clock_in_time") val clock_in_time : String,
    @SerializedName("clock_out_time") val clock_out_time : String,
    @SerializedName("clock_in_latitude") val clock_in_latitude : Double,
    @SerializedName("clock_in_longitude") val clock_in_longitude : Double,
    @SerializedName("clock_out_latitude") val clock_out_latitude : Double,
    @SerializedName("clock_out_longitude") val clock_out_longitude : Double,
    @SerializedName("schedule") val schedule : String
)