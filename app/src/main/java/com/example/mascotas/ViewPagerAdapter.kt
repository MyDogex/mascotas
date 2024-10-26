package com.example.mascotas

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import fragments.FragmentPerfilMascota


class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2 // Número de pestañas

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentMascotas()  // Primera pestaña
            1 -> FragmentPerfilMascota()  // Segunda pestaña
            else -> FragmentMascotas()
        }
    }
}
