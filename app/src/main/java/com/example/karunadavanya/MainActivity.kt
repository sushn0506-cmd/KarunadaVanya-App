package com.example.karunadavanya

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.karunadavanya.ui.theme.KarunadaVanyaTheme
import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        if (
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {

            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                101
            )
        }
        setContent {

            KarunadaVanyaTheme {

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {

                    composable("splash") {
                        SplashScreen(navController)
                    }

                    composable("login") {
                        LoginScreen(navController)
                    }
                    composable("signup") {
                        SignupScreen(navController)
                    }
                    composable("dashboard") {
                        DashboardScreen(navController)
                    }

                    composable("wildlife") {
                        WildlifeScreen(navController)
                    }

                    composable("alerts") {
                        AlertScreen(navController)
                    }

                    composable("tips") {
                        TipsScreen(navController)
                    }

                    composable("report") {
                        ReportScreen(navController)
                    }
                    composable("reports") {
                        ReportsScreen(navController)
                    }
                    composable("ai") {
                        AIAssistantScreen(navController)
                    }
                    composable("map") {
                        MapScreen(navController)
                    }
                    composable("about") {
                        AboutScreen(navController)
                    }
                    composable("admin") {
                        AdminScreen(navController)
                    }
                }
            }
        }
    }
}