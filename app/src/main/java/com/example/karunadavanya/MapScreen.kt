package com.example.karunadavanya

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun MapScreen(navController: NavController) {

    val wildlifeLocation = LatLng(
        12.9716,
        77.5946
    )

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(
            wildlifeLocation,
            12f
        )
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = MapUiSettings(
                zoomControlsEnabled = true,
                zoomGesturesEnabled = true,
                scrollGesturesEnabled = true,
                tiltGesturesEnabled = true,
                rotationGesturesEnabled = true
            )
        ) {

            Marker(
                state = MarkerState(
                    position = wildlifeLocation
                ),
                title = "Wildlife Sighting",
                snippet = "Reported Area"
            )
        }

        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = androidx.compose.ui.graphics.Color(0xFF5C6BC0)
            ),
            modifier = Modifier
                .padding(16.dp)
        ) {

            Text(
                text = "Back",
                color = androidx.compose.ui.graphics.Color.White
            )
        }
    }
}