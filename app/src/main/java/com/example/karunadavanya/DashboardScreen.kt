package com.example.karunadavanya
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DashboardScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF1F8E9),
                        Color.White
                    )
                )
            )
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(80.dp))

            Text(
                text = "🌿 Dashboard",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Explore Wildlife Awareness Features",
                fontSize = 16.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    navController.navigate("wildlife")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5C6BC0)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "🐘 Wildlife Info",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("alerts")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD32F2F)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "🚨 Alerts",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("tips")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1976D2)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "💡 Safety Tips",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("report")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF388E3C)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "📍 Report Sighting",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("reports")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF00897B)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "📋 View Reports",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("ai")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2E7D32)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "🤖 AI Assistant",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("map")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEF6C00)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "🗺️ Wildlife Map",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("admin")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8E24AA)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {

                Text(
                    text = "👨‍💼 Admin Dashboard",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("about")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF6A1B9A)
                ),
                modifier = Modifier
                    .width(230.dp)
                    .height(55.dp)
            ) {
                Text(
                    text = "ℹ️ About App",
                    color = Color.White,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                Button(
                    onClick = {
                        navController.popBackStack("login", inclusive = false)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.DarkGray
                    )
                ) {

                    Text(
                        text = "🚪 Logout",
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Built for Wildlife Awareness 🌿",
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}