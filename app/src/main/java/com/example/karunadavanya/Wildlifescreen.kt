package com.example.karunadavanya

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Animal(
    val name: String,
    val description: String,
    val imageRes: Int
)

@Composable
fun WildlifeScreen(navController: NavController) {

    val animals = listOf(

        Animal(
            "Tiger",
            "National animal known for strength and beauty.",
            R.drawable.tiger
        ),

        Animal(
            "Elephant",
            "Highly intelligent animal found in forests.",
            R.drawable.elephant
        ),

        Animal(
            "Leopard",
            "Fast and powerful wild cat.",
            R.drawable.leopard
        ),

        Animal(
            "Hornbill",
            "Famous forest bird species.",
            R.drawable.hornbill
        ),

        Animal(
            "Sandalwood Tree",
            "Valuable and protected tree species.",
            R.drawable.sandalwood
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {

        item {

            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Back")
            }

            Text(
                text = "Wildlife Information",
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(animals) { animal ->

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFDFF5E1)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Image(
                        painter = painterResource(id = animal.imageRes),
                        contentDescription = animal.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = animal.name,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = animal.description)
                }
            }
        }
    }
}