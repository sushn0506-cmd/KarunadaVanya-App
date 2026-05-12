package com.example.karunadavanya

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            10f
        )
    }

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {

        Marker(
            state = MarkerState(
                position = wildlifeLocation
            ),
            title = "Wildlife Sighting",
            snippet = "Reported Area"
        )
    }
}