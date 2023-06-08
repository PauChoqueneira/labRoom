package com.example.danp2023room

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.danp2023room.screen.Home
import com.example.danp2023room.screen.registerCourse
import com.example.danp2023room.screen.registerStudent
import com.example.danp2023room.screen.details
import com.example.danp2023room.ui.theme.DANP2023RoomTheme
import androidx.navigation.compose.NavHost

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            DANP2023RoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "Home"){
                        composable("Home"){
                            Home(navController = navController)
                        }

                        composable("registerCourse") {
                            registerCourse(viewModel)
                        }

                        composable("registerStudent") {
                            registerStudent(viewModel)
                        }

                        composable("details") {
                            details(viewModel)
                        }
                    }
                }
            }
        }
    }
}



