package com.example.karunadavanya

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.database.*

@Composable
fun AdminScreen(navController: NavController) {

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
                        reportSnapshot.getValue(
                            ReportData::class.java
                        )

                    if (report != null) {

                        val updatedReport = report.copy(
                            id = reportSnapshot.key ?: ""
                        )

                        reportList.add(updatedReport)
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
            text = "Admin Dashboard",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {

            items(reportList) { report ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF3E0)
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = "Animal: ${report.animal}",
                            fontSize = 20.sp
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Location: ${report.location}"
                        )

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = "Time: ${report.time}"
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            onClick = {

                                reportsRef.child(report.id)
                                    .removeValue()
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red
                            )
                        ) {

                            Text(
                                text = "Delete Report",
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
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "Back",
                color = Color.White
            )
        }
    }
}