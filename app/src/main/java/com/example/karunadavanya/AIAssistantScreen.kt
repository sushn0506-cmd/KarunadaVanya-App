package com.example.karunadavanya

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AIAssistantScreen(navController: NavController) {

    var userMessage by remember {
        mutableStateOf("")
    }

    val messages = remember {
        mutableStateListOf<ChatMessage>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "🌿 AI Wildlife Assistant",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(messages) { message ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement =
                        if (message.isUser)
                            Arrangement.End
                        else
                            Arrangement.Start
                ) {

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor =
                                if (message.isUser)
                                    Color(0xFFBBDEFB)
                                else
                                    Color(0xFFC8E6C9)
                        ),
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.padding(8.dp)
                    ) {

                        Text(
                            text = message.text,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }

        OutlinedTextField(
            value = userMessage,
            onValueChange = {
                userMessage = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Ask about wildlife safety...")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {

                if (userMessage.isNotEmpty()) {

                    messages.add(
                        ChatMessage(userMessage, true)
                    )

                    val aiReply =
                        getAIResponse(userMessage)

                    messages.add(
                        ChatMessage(aiReply, false)
                    )

                    userMessage = ""
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2E7D32)
            )
        ) {

            Text(
                text = "Send",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5C6BC0)
            )
        ) {

            Text(
                text = "Back",
                color = Color.White
            )
        }
    }
}

fun getAIResponse(question: String): String {

    val q = question.lowercase()

    return when {

        "tiger" in q ->
            "Tigers are powerful wild animals. Stay calm and avoid approaching them."

        "elephant" in q ->
            "If an elephant appears nearby, maintain safe distance and avoid loud noises."

        "leopard" in q ->
            "Leopards are usually shy animals. Stay indoors and alert forest officials."

        "snake" in q ->
            "Avoid touching snakes and contact wildlife rescue teams immediately."

        "forest" in q ->
            "Always stay alert in forest areas and avoid travelling alone at night."

        else ->
            "Please stay safe and contact forest authorities during wildlife emergencies."
    }
}