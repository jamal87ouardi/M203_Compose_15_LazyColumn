package com.example.m203_composable_15_lazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.m203_composable_15_lazycolumn.ui.theme.M203_Composable_15_LazyColumnTheme

data class PC(val id: Int, val nom: String, val prix: Double)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M203_Composable_15_LazyColumnTheme {
                PCListScreen()
            }
        }
    }
}

@Composable
fun PCListScreen() {
    // Remplir une liste avec 10 objets de type PC
    val pcList = mutableListOf(
        PC(1, "Dell Inspiron", 599.99),
        PC(2, "HP Pavilion", 699.99),
        PC(3, "MacBook Pro", 1299.99),
        PC(4, "Lenovo ThinkPad", 799.99),
        PC(5, "Asus ROG", 1499.99),
        PC(6, "Acer Predator", 1199.99),
        PC(7, "MSI Stealth", 1399.99),
        PC(8, "Surface Laptop", 999.99),
        PC(9, "Alienware Aurora", 1799.99),
        PC(10, "Samsung Galaxy Book", 1099.99)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        // Titre
        Text(
            text = "Liste de PC",

            modifier = Modifier.padding(16.dp)
        )

        // Afficher uniquement les noms des PC
        LazyColumn(
            modifier = Modifier.height(200.dp)

        ) {
            items(pcList) { pc ->
                Text(
                    text = pc.nom, // Afficher uniquement le nom
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}