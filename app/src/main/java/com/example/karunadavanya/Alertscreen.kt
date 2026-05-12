package com.example.karunadavanya

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

data class Alert(
    val title: String,
    val message: String
)

@Composable
fun AlertScreen(navController: NavController) {

    val context = LocalContext.current

    val alerts = listOf(
        Alert(
            "Elephant Movement",
            "Elephants spotted near village border."
        ),
        Alert(
            "Leopard Alert",
            "Avoid forest routes during night time."
        ),
        Alert(
            "Forest Warning",
            "Stay alert in wildlife-sensitive areas."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Wildlife Alerts",
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(alerts) { alert ->

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFE0E0)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = alert.title,
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = alert.message
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {

                                showWildlifeNotification(
                                    context,
                                    alert.title,
                                    alert.message
                                )
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFD32F2F)
                            )
                        ) {

                            Text(
                                text = "Send Alert",
                                color = Color.White
                            )
                        }
                    }
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
                .width(180.dp)
                .height(55.dp)
        ) {

            Text(
                text = "Back",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}