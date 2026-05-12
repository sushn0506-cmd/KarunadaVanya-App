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
fun TipsScreen(navController: NavController) {

    val tips = listOf(
        "Do not enter forest areas alone.",
        "Avoid going outside during wildlife alerts.",
        "Keep emergency contact numbers ready.",
        "Do not disturb wild animals.",
        "Report animal sightings immediately."
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5C6BC0)
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(160.dp)
                .height(55.dp)
        ) {

            Text(
                text = "Back",
                color = Color.White,
                fontSize = 18.sp
            )
        }

        Text(
            text = "Safety Tips",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn {

            items(tips) { tip ->

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE3F2FD)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {

                    Text(
                        text = tip,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}