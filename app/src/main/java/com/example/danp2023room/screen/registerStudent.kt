package com.example.danp2023room.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.danp2023room.MainViewModel
import com.example.danp2023room.entities.StudentEntity
import com.example.danp2023room.entities.StudentNCourse

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun registerStudent (viewModel: MainViewModel) {
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var dni by remember { mutableStateOf("") }
    var cursoID by remember { mutableStateOf("") }

    var cursoLista = viewModel.getAllCourse().value

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth(), verticalArrangement = Arrangement.Center
    ) {
        item {
            Text(
                text = "Registro de usuario",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 24.sp,
            )
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
            TextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
            TextField(
                value = dni,
                onValueChange = { dni = it },
                label = { Text("DNI") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
            TextField(
                value = cursoID,
                onValueChange = { cursoID = it },
                label = { Text("Codigo del curso") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        viewModel.insertStudent(
                            StudentEntity(
                                dni.toInt(),
                                nombre,
                                apellido,
                                dni
                            )
                        )
                        viewModel.insertStudentNCourse(
                            StudentNCourse(
                                dni.toInt(),
                                cursoID.toInt()
                            )
                        )
                    },
                    modifier = Modifier.clip(RoundedCornerShape(4.dp)).padding(10.dp)
                ) {
                    Text(text = "Matricular")
                }
                if (cursoLista != null) {
                    Column() {
                        cursoLista.forEach {
                            Text(text = "Curso Id : " + it.courseId + ", Asignatura : " + it.name + "\n-----------------------------------------------------")
                        }
                    }
                }
            }
        }
    }
}
