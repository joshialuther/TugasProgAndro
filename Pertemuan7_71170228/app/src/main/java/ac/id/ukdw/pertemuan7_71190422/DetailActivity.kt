package ac.id.ukdw.pertemuan7_71170228

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama = intent.getStringExtra("Nama")
        val nomer = intent.getStringExtra("Nomor")
        val gambar = intent.getIntExtra("Gambar",0)
        val txtNama: TextView = findViewById(R.id.txtnama)
        val txtNomer: TextView = findViewById(R.id.txtnomer)
        val img: ImageView = findViewById(R.id.imgKontak)
        txtNama.text =  nama
        txtNomer.text = nomer
        img.setImageResource(gambar)
    }

}