package com.example.danp2023room.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun Home(navController: NavHostController) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Button(onClick = { navController.navigate("registerCourse") }) {
            Text(text = "Registrar Curso")
        }

        Button(onClick = { navController.navigate("registerStudent") }) {
            Text(text = "Registrar Estudiante")
        }

        Button(onClick = { navController.navigate("detailsList") }) {
            Text(text = "Listar cursos con matriculados")
        }
    }
}