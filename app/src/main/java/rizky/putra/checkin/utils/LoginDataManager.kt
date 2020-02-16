package rizky.putra.checkin.utils

import android.content.Context
import android.content.SharedPreferences

object LoginDataManager {
    private const val PREF_NAME = "key_pref_data"
    private const val KEY_API = "key_api"
    private const val KEY_CHECKIN = "key_checkin"

    fun setKey(context : Context,key : String?){
        val setting : SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = setting.edit()
        editor.putString(KEY_API,key)
        return editor.apply()
    }
    fun getKey(context : Context) : String?{
        val setting : SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        return setting.getString(KEY_API,"")

    }

    fun setLogin(context : Context,key : Boolean){
        val setting : SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = setting.edit()
        editor.putBoolean(KEY_CHECKIN, key)
        return editor.apply()
    }
    fun getLogin(context : Context) : Boolean?{
        val setting : SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
        return setting.getBoolean(KEY_CHECKIN,false)

    }
}
