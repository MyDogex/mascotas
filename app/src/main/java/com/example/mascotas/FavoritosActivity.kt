package com.example.mascotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotas.adapters.MascotaAdapter
import com.example.mascotas.models.Mascota


class FavoritosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        // Habilitar la flecha de "Atrás"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Obtener la lista de mascotas favoritas desde el Intent
        val mascotasFavoritas = intent.getParcelableArrayListExtra<Mascota>("MASCOTAS_FAVORITAS")

        // Configurar el RecyclerView con las mascotas favoritas
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewFavoritos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MascotaAdapter(mascotasFavoritas ?: listOf()) // Asegurarse de que no sea null
    }

    // Manejar el botón de "Atrás"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}