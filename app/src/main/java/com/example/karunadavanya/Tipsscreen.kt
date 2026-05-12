package com.example.karunadavanya

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Tipsscreen(navController: NavController) {

    val safetyTips = listOf(
        "Do not enter forest areas alone.",
        "Avoid going outside during wildlife alerts.",
        "Keep emergency contact numbers ready.",
        "Do not disturb wild animals.",
        "Report animal sightings immediately."
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Safety Tips",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(safetyTips) { tip ->

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE3F2FD)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {

                    Text(
                        text = tip,
                        modifier = Modifier.padding(20.dp),
                        fontSize = 18.sp
                    )
                }
            }
        }

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5C6BC0)
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 10.dp)
        ) {

            Text(
                text = "Back",
                color = Color.White
            )
        }
    }
}