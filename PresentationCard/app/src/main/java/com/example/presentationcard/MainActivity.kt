package com.example.presentationcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AllInbox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentationcard.ui.theme.PresentationCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PresentationCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Composable
fun Presentation(
    name: String,
    title: String,
    phoneNumber: String,
    email: String,
    twitterHandle: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter // Cambiar a TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.Top, // Alinear hacia la parte superior
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 32.dp) // Añadir padding superior
        ) {
            Spacer(modifier = Modifier.height(16.dp)) // Añadir un Spacer en la parte superior
            ProfileSection(name = name, title = title)
            Spacer(modifier = Modifier.height(32.dp)) // Aumentar el espaciado
            ContactSection(phoneNumber = phoneNumber, email = email, twitterHandle = twitterHandle)
        }
    }
}

@Composable
fun ProfileSection(name: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder),
            contentDescription = "Imagen de perfil",
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = name,fontSize = 32.sp, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, style = MaterialTheme.typography.titleMedium, fontSize = 28.sp)
    }
}

@Composable
fun ContactSection(phoneNumber: String, email: String, twitterHandle: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        ContactItem(icon = Icons.Filled.Phone, contactText = phoneNumber)
        Spacer(modifier = Modifier.height(16.dp))
        ContactItem(icon = Icons.Filled.Email, contactText = email)
        Spacer(modifier = Modifier.height(16.dp))
        ContactItem(icon = Icons.Filled.Contacts, contactText = twitterHandle)
    }
}

@Composable
fun ContactItem(icon: ImageVector, contactText: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = contactText, style = MaterialTheme.typography.bodyLarge, fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PresentationCardTheme {
        Presentation(
            name = "Nombre Completo",
            title = "Título",
            phoneNumber = "+928478573",
            email = "correo@ejemplo.com",
            twitterHandle = "@usuario"
        )
    }
}