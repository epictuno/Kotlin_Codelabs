package com.example.clicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clicker.ui.theme.ClickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CenteredContent()
                }
            }
        }
    }
}
data class Estado(val imagen: Int, val texto: String)
@Composable
fun CenteredContent() {
    val estados = listOf(
        Estado(R.drawable.lemon_tree, "Presione para coger un limón del limonero"),
        Estado(R.drawable.lemon_squeeze, "Presione para extraer el jugo"),
        Estado(R.drawable.lemon_drink, "Presione para beber limonada"),
        Estado(R.drawable.lemon_restart, "Presione para reiniciar")
    )
    var estadoActual by remember { mutableStateOf(0) }
    fun nextEstado() {
        estadoActual = (estadoActual + 1) % estados.size
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = estados[estadoActual].imagen),
                contentDescription = estados[estadoActual].texto,
                modifier = Modifier
                    .size(200.dp)
                    .clickable { nextEstado() }
            )
            Text(
                text = estados[estadoActual].texto
            )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClickerTheme {
        CenteredContent()
    }
}