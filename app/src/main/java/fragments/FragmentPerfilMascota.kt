package fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mascotas.R
import com.example.mascotas.adapters.HuesoAdapter

class FragmentPerfilMascota : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_perfil_mascota, container, false)

        val recyclerViewHuesos = view.findViewById<RecyclerView>(R.id.recyclerViewHuesos)
        recyclerViewHuesos.layoutManager = GridLayoutManager(context, 3)

        // Lista de huesos (números simulados para cada imagen de hueso)
        val listaHuesos = listOf(5, 0, 3, 10, 2, 3, 4, 6, 1)

        // Configura el adaptador con la lista de huesos
        recyclerViewHuesos.adapter = HuesoAdapter(listaHuesos)

        return view
    }
}
