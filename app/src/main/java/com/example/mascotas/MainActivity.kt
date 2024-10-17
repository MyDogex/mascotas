package com.example.mascotas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotas.adapters.MascotaAdapter
import com.example.mascotas.models.Mascota
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewMascotas: RecyclerView
    private lateinit var mascotaAdapter: MascotaAdapter

    val listaMascotas = listOf(
        Mascota("Catty", 5, R.drawable.img_catty),
        Mascota("Ronny", 3, R.drawable.img_ronny),
        Mascota("Buddy", 0, R.drawable.img_buddy),
        Mascota("Duke", 1, R.drawable.img_duke),
        Mascota("Max", 0, R.drawable.img_max)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.topAppBar))
        recyclerViewMascotas = findViewById(R.id.recyclerViewMascotas)
        recyclerViewMascotas.layoutManager = LinearLayoutManager(this)

        // Configura el Toolbar
        val toolbar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        mascotaAdapter = MascotaAdapter(listaMascotas)
        recyclerViewMascotas.adapter = mascotaAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorites -> {
                // Filtrar las mascotas con huesos > 0
                val mascotasConHuesos = listaMascotas.filter { it.huesos > 0 }
                // Convertir la lista filtrada a un ArrayList para pasarla al Intent
                val mascotasFavoritas = ArrayList(mascotasConHuesos)
                // Crear Intent y pasar la lista de mascotas filtrada
                val intent = Intent(this, FavoritosActivity::class.java).apply {
                    putParcelableArrayListExtra("MASCOTAS_FAVORITAS", mascotasFavoritas)
                }
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
