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
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewMascotas: RecyclerView
    private lateinit var mascotaAdapter: MascotaAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

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

        // Configura el Toolbar
        val toolbar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        // Configura el RecyclerView
        recyclerViewMascotas = findViewById(R.id.recyclerViewMascotas)
        recyclerViewMascotas.layoutManager = LinearLayoutManager(this)
        mascotaAdapter = MascotaAdapter(listaMascotas)
        recyclerViewMascotas.adapter = mascotaAdapter

        // Configura el ViewPager y TabLayout
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        // Configura el adaptador del ViewPager
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        // Conecta el TabLayout con el ViewPager usando TabLayoutMediator
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Inicio"    // Primera pestaña
                1 -> "Perfil"    // Segunda pestaña
                else -> ""
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_favorites -> {
                val mascotasConHuesos = listaMascotas.filter { it.huesos > 0 }
                val mascotasFavoritas = ArrayList(mascotasConHuesos)
                val intent = Intent(this, FavoritosActivity::class.java).apply {
                    putParcelableArrayListExtra("MASCOTAS_FAVORITAS", mascotasFavoritas)
                }
                startActivity(intent)
                true
            }
            R.id.action_contacto -> {
                val intent = Intent(this, ContactoActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_acerca_de -> {
                val intent = Intent(this, AcercaDeActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_configurar_cuenta -> {
                startActivity(Intent(this, ConfigurarCuentaActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
