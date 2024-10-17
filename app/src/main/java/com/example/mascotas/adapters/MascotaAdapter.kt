package com.example.mascotas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotas.models.Mascota
import com.example.mascotas.R  // Importar recursos como imágenes y layouts

class MascotaAdapter(private val mascotas: List<Mascota>) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    class MascotaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgMascota: ImageView = view.findViewById(R.id.imgMascota)
        val txtNombre: TextView = view.findViewById(R.id.tvNombreMascota)
        val txtRating: TextView = view.findViewById(R.id.tvHuesosMascota)
        val btnHueso: ImageView = view.findViewById(R.id.imgBone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mascota, parent, false)
        return MascotaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.txtNombre.text = mascota.nombre
        holder.txtRating.text = "${mascota.huesos} huesos"
        holder.imgMascota.setImageResource(mascota.imagenResId)

        if (mascota.huesos > 0) {
            holder.btnHueso.setImageResource(R.drawable.ic_hueso_amarillo)
        } else {
            holder.btnHueso.setImageResource(R.drawable.ic_hueso_blanco)
        }

        // Acción para aumentar el rating cuando se hace clic en el hueso
        holder.btnHueso.setOnClickListener {
            mascota.huesos++
            notifyItemChanged(position)  // Notificar al Adapter que cambió un item
        }
    }
    

    override fun getItemCount(): Int {
        return mascotas.size
    }
}