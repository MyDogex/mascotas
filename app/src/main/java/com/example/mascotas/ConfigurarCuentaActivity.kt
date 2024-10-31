package com.example.mascotas

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ConfigurarCuentaActivity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var btnGuardarCuenta: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar_cuenta)

        etUsuario = findViewById(R.id.etUsuario)
        btnGuardarCuenta = findViewById(R.id.btnGuardarCuenta)

        // Inicializa SharedPreferences
        sharedPreferences = getSharedPreferences("PetagramPrefs", Context.MODE_PRIVATE)

        // Cargar el usuario guardado (si existe)
        etUsuario.setText(sharedPreferences.getString("usuario", ""))

        btnGuardarCuenta.setOnClickListener {
            val usuario = etUsuario.text.toString()
            if (usuario.isNotEmpty()) {
                // Guarda el usuario en SharedPreferences
                sharedPreferences.edit().putString("usuario", usuario).apply()
            }
        }
    }


}
