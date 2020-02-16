package rizky.putra.checkin.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


fun formatDate(input : String):String{
    var format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
    Log.d("tes","substring " + input.substring(0,input.length-3))
    val newDate = format.parse(input.substring(0,input.length-3))
    format = SimpleDateFormat("hh:mm a", Locale.getDefault())

    return format.format(newDate)
}