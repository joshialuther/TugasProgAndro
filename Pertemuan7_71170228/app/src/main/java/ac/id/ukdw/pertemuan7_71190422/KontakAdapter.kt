package ac.id.ukdw.pertemuan7_71170228

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class KontakAdapter(val listkontak: ArrayList<Kontak>,private val OnClick: OnClick, val context: Context): RecyclerView.Adapter<KontakAdapter.KontakHolder> (){
    class KontakHolder(val view: View): RecyclerView.ViewHolder(view){
        fun bind(kontak: Kontak, context: Context ){
            view.findViewById<ImageView>(R.id.imgAva).setImageResource(kontak.Gambar)
            view.findViewById<TextView>(R.id.txtNama).setText(kontak.Nama)
            view.findViewById<TextView>(R.id.txtNomer).setText(kontak.Nomor)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakHolder  {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_kontak, parent, false)
        return KontakHolder(v)
    }

    override fun onBindViewHolder(holder: KontakHolder, position: Int) {
        holder.bind(listkontak[position],context)
        holder.itemView.setOnClickListener {
            OnClick.onKontakClick(position)
        }
    }

    override fun getItemCount(): Int {
        return listkontak.size
    }


}