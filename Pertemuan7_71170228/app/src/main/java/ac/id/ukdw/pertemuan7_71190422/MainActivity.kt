package ac.id.ukdw.pertemuan7_71170228

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnClick {
    val listKontak = arrayListOf<Kontak>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listKontak.add(Kontak(Nama= "Joshia Agrisa Anhriely Luther", Nomor= "082239128211", R.mipmap.ic_launcher))
        listKontak.add(Kontak(Nama= "Jefrrison", Nomor= "08133221230", R.mipmap.ic_launcher))
        listKontak.add(Kontak(Nama= "Maxens", Nomor= "081122334455", R.mipmap.ic_launcher))
        listKontak.add(Kontak(Nama= "Tasia", Nomor= "08921332123", R.mipmap.ic_launcher))
        listKontak.add(Kontak(Nama= "Peter Parker", Nomor= "083322112344", R.mipmap.ic_launcher))

        val rv = findViewById<RecyclerView>(R.id.rvKontak)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = KontakAdapter(listKontak,this,this)
        rv.adapter = adapter


    }

    override fun onKontakClick(position: Int) {
//        Toast.makeText(this, "Kontak "+position +" clicked", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Nama",listKontak[position].Nama)
        intent.putExtra("Nomor",listKontak[position].Nomor)
//        intent.putExtra("gambar",listKontak[position].gambar)
        startActivity(intent)
    }
}