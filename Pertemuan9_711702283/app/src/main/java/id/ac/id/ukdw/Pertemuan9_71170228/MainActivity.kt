package id.ac.id.ukdw.Pertemuan9_71170228

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import java.util.*
import id.ac.id.ukdw.Pertemuan9_71170228.LoginPref
import kotlin.collections.HashMap

class MainActivity: AppCompatActivity() {
    private lateinit var tvUsername: TextView
    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var btnLanguage: Button
    private lateinit var btnSizeDown: Button
    private lateinit var btnSizeUp: Button
    private lateinit var tvContent: TextView
    private var ourFontSize = 14f

    lateinit var session: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        session = LoginPref(this)

        tvUsername = findViewById(R.id.tvUsername)
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        btnLanguage = findViewById(R.id.btnLanguage)
        btnSizeUp = findViewById(R.id.btnSizeUp)
        btnSizeDown = findViewById(R.id.btnSizeDown)
        tvContent = findViewById(R.id.tvContent)


        session.loginCheck()

        var user: HashMap<String, String> = session.getUserDetails()

        var  username = user.get(LoginPref.KEY_USERNAME)
        var email = user.get(LoginPref.KEY_EMAIL)

        tvUsername.setText(username)
        tvEmail.setText(email)

        btnLogout.setOnClickListener{
            session.Logout()
        }

        btnLanguage.setOnClickListener{
            showChageLang()
        }

        btnSizeUp.setOnClickListener{
            ourFontSize+=4f
            tvContent.setTextSize(TypedValue.COMPLEX_UNIT_SP,ourFontSize)
        }
        btnSizeDown.setOnClickListener{
            ourFontSize-=4f
            tvContent.setTextSize(TypedValue.COMPLEX_UNIT_SP,ourFontSize)
        }

    }
    private fun showChageLang(){
        val listItems = arrayOf("English","Japan","Indonesia")
        val mBuilder = AlertDialog.Builder(this@MainActivity)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItems, -1) { dialog, which ->
            if (which == 0) {
                setLocate("en")
                recreate()
            } else if (which == 1) {
                setLocate("jp")
                recreate()
            } else if (which == 2) {
                setLocate("id")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()

    }
    private fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }

}