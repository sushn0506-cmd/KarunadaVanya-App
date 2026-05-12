package com.example.karunadavanya

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AboutScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Back")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "🌿 About Karunada-Vanya",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E7D32)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                "Karunada-Vanya is a wildlife awareness and safety application designed to educate users about forest animals, provide alerts, safety tips, and support reporting of wildlife sightings.\n\nThe app aims to promote environmental awareness and reduce human-wildlife conflicts.",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Developed using Kotlin & Jetpack Compose",
            color = Color.Gray
        )
    }
}