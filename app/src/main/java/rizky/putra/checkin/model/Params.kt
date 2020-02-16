package rizky.putra.checkin.model

data class LoginParams(
    internal var username:String = "",
    internal val password:String = ""
)
data class ClockInParams(
    internal var latitude:String = "",
    internal val longitude:String = ""
)
