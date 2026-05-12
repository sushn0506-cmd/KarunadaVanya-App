package com.example.karunadavanya

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.google.android.gms.location.LocationServices
import com.google.firebase.database.FirebaseDatabase
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("MissingPermission")

@Composable
fun ReportScreen(navController: NavController) {

    var animal by remember { mutableStateOf("") }
    var locationText by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val context = LocalContext.current

    val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)

    val locationPermissionLauncher =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->

            if (isGranted) {

                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location: Location? ->

                        if (location != null) {

                            locationText =
                                "Lat: ${location.latitude}, Lng: ${location.longitude}"
                        }
                    }
            }
        }

    val database = FirebaseDatabase.getInstance()
    val reportsRef = database.getReference("WildlifeReports")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Report Wildlife Sighting",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = animal,
            onValueChange = {
                animal = it
            },
            label = {
                Text("Animal Name")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = locationText,
            onValueChange = {
                locationText = it
            },
            label = {
                Text("Location")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {

                when {

                    ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED -> {

                        fusedLocationClient.lastLocation
                            .addOnSuccessListener { location: Location? ->

                                if (location != null) {

                                    locationText =
                                        "Lat: ${location.latitude}, Lng: ${location.longitude}"
                                }
                            }
                    }

                    else -> {

                        locationPermissionLauncher.launch(
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1976D2)
            )
        ) {

            Text(
                text = "Get Current Location",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val reportId = reportsRef.push().key

                val currentTime =
                    SimpleDateFormat(
                        "dd/MM/yyyy hh:mm a",
                        Locale.getDefault()
                    ).format(Date())

                val reportData = mapOf(
                    "id" to reportId,
                    "animal" to animal,
                    "location" to locationText,
                    "time" to currentTime
                )

                if (reportId != null) {

                    reportsRef.child(reportId)
                        .setValue(reportData)
                        .addOnSuccessListener {

                            message = "Report Submitted Successfully!"

                            animal = ""
                            locationText = ""
                        }
                        .addOnFailureListener {

                            message = "Failed to Submit Report"
                        }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF388E3C)
            )
        ) {

            Text(
                text = "Submit Report",
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = message,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5C6BC0)
            ),
            modifier = Modifier
                .padding(bottom = 20.dp)
        ) {

            Text(
                text = "Back",
                color = Color.White
            )
        }
    }
}