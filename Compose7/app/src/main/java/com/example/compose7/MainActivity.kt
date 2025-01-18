package com.example.compose7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.compose7.ui.theme.Compose7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose7Theme {
                Login()
            }
        }
    }
}

@Composable
fun Login() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        var usuario by remember { mutableStateOf("") }
        var clave by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("Sin resultado") }

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = clave,
            onValueChange = { clave = it },
                   label = { Text("Clave") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                var cadena = ""
                if (clave.length < 10)
                    cadena += "La clave debe tener al menos 10 caracteres.\n"
                if (usuario.isEmpty())
                    cadena += "No puede dejar el usuario vacío."
                resultado = if (cadena.isEmpty()) "Datos válidos" else cadena
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text("Confirmar")
        }

        Text(
            text = resultado,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}
