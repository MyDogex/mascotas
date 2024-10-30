package com.example.mascotas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotas.R

class HuesoAdapter(private val listaHuesos: List<Int>) : RecyclerView.Adapter<HuesoAdapter.HuesoViewHolder>() {

    class HuesoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMascota: ImageView = itemView.findViewById(R.id.imgMascota)
        val txtNumeroHuesos: TextView = itemView.findViewById(R.id.txtNumeroHuesos)
        val imgHueso: ImageView = itemView.findViewById(R.id.imgHueso)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HuesoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mascota2, parent, false)
        return HuesoViewHolder(view)
    }

    override fun onBindViewHolder(holder: HuesoViewHolder, position: Int) {
        val numeroHuesos = listaHuesos[position]
        holder.txtNumeroHuesos.text = numeroHuesos.toString()
        holder.imgMascota.setImageResource(R.drawable.img_ronny) // Cambia por la imagen deseada
        holder.imgHueso.setImageResource(R.drawable.ic_hueso_blanco) // Cambia por el icono de hueso
    }

    override fun getItemCount(): Int {
        return listaHuesos.size
    }
}
