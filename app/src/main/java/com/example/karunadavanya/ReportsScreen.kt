package com.example.karunadavanya

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.database.*

@Composable
fun ReportsScreen(navController: NavController) {

    val reportList = remember {
        mutableStateListOf<ReportData>()
    }

    val database = FirebaseDatabase.getInstance()
    val reportsRef = database.getReference("WildlifeReports")

    LaunchedEffect(Unit) {

        reportsRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                reportList.clear()

                for (reportSnapshot in snapshot.children) {

                    val report =
                        reportSnapshot.getValue(ReportData::class.java)

                    if (report != null) {

                        reportList.add(report)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Wildlife Reports",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(reportList) { report ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFE8F5E9)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Animal: ${report.animal}",
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Location: ${report.location}",
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Reported At: ${report.time}",
                            fontSize = 16.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5C6BC0)
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {

            Text(
                text = "Back",
                color = Color.White
            )
        }
    }
}