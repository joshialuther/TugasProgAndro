package id.ac.id.ukdw.Pertemuan9_71170228

import android.content.Context
import android.content.Intent
import id.ac.id.ukdw.Pertemuan9_71170228.LoginActivity
import android.content.SharedPreferences

class LoginPref {
    lateinit var pref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    lateinit var con: Context
    var PRIVATEMODE: Int = 0

    constructor(con: Context){
        this.con = con
        pref = con.getSharedPreferences(PREF_NAME,PRIVATEMODE)
        editor = pref.edit()

    }

    companion object{
        val PREF_NAME = "login_pref"
        val IS_LOGIN = "isLoggedIn"
        val KEY_USERNAME = "username"
        val KEY_EMAIL = "email"
    }

    fun createLogginSession(username:String, email: String){
        editor.putBoolean(IS_LOGIN,true)
        editor.putString(KEY_EMAIL,email)
        editor.putString(KEY_USERNAME, username)
        editor.commit()
    }

    fun loginCheck(){
        if(!this.isLoggedIn()){
            var i : Intent = Intent(con, LoginActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            con.startActivity(i)
        }
    }

    fun getUserDetails():HashMap<String, String>{
        var user: Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(KEY_USERNAME,pref.getString(KEY_USERNAME, null)!!)
        (user as HashMap).put(KEY_EMAIL,pref.getString(KEY_EMAIL, null)!!)
        return user
    }

    fun Logout(){
        editor.clear()
        editor.commit()
        var i : Intent = Intent(con, LoginActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        con.startActivity(i)
    }

    fun isLoggedIn():Boolean{
        return pref.getBoolean(IS_LOGIN, false)

    }
}