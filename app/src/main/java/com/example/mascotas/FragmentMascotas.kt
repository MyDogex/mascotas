package com.example.mascotas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotas.adapters.MascotaAdapter
import com.example.mascotas.models.Mascota

class FragmentMascotas : Fragment() {

    private lateinit var recyclerViewMascotas: RecyclerView
    private lateinit var mascotaAdapter: MascotaAdapter

    private val listaMascotas = listOf(
        Mascota("Catty", 5, R.drawable.img_catty),
        Mascota("Ronny", 3, R.drawable.img_ronny),
        Mascota("Buddy", 0, R.drawable.img_buddy),
        Mascota("Duke", 1, R.drawable.img_duke),
        Mascota("Max", 0, R.drawable.img_max)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_mascotas, container, false)

        // Configura el RecyclerView
        recyclerViewMascotas = view.findViewById(R.id.recyclerViewMascotas)
        recyclerViewMascotas.layoutManager = LinearLayoutManager(requireContext())
        mascotaAdapter = MascotaAdapter(listaMascotas)
        recyclerViewMascotas.adapter = mascotaAdapter

        return view
    }
}
