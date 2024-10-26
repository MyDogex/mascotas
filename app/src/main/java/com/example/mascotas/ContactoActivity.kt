package com.example.mascotas

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class ContactoActivity : AppCompatActivity() {

    private lateinit var etNombre: TextInputEditText
    private lateinit var etCorreo: TextInputEditText
    private lateinit var etMensaje: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacto)

        etNombre = findViewById(R.id.etNombre)
        etCorreo = findViewById(R.id.etCorreo)
        etMensaje = findViewById(R.id.etMensaje)

        findViewById<Button>(R.id.btnEnviarComentario).setOnClickListener {
            enviarComentario()
        }
    }

    private fun enviarComentario() {
        val nombre = etNombre.text.toString()
        val correo = etCorreo.text.toString()
        val mensaje = etMensaje.text.toString()

        // Aquí configura JavaMail para enviar el correo electrónico
        // Agrega la lógica para enviar el correo usando JavaMail
        Toast.makeText(this, "Comentario enviado", Toast.LENGTH_SHORT).show()
    }
}
