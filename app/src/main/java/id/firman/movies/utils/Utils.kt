package id.firman.movies.utils

import android.content.Context

object Utils {

    private const val PREFERENCES_FILE = "settings"

    fun readSharedSetting(ctx: Context, settingName: String, defaultValue: String): String? {
        val sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
        return sharedPref.getString(settingName, defaultValue)
    }

    fun saveSharedSetting(ctx: Context, settingName: String, settingValue: String) {
        val sharedPref = ctx.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(settingName, settingValue)
        editor.apply()
    }

}
