package com.example.mascotas.models
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mascota(
    val nombre: String,
    var huesos: Int,
    val imagenResId: Int
) : Parcelable