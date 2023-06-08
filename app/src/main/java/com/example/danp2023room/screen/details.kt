package com.example.danp2023room.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.danp2023room.MainViewModel

@Composable
fun details(viewModel: MainViewModel) {

    var listStudent = viewModel.getAllStudent().observeAsState().value
    var listCourse = viewModel.getAllCourse().observeAsState().value
    var listStudentNCourse = viewModel.getAllStudentNCourse().observeAsState().value

    LazyColumn() {
        if (listStudent != null && listCourse != null && listStudentNCourse != null) {
            listCourse.forEach {
                var aux = it
                item {
                    Row() {
                        Text(text = it.name + " : ")
                        listStudent.forEach {
                            var aux2 = it
                            listStudentNCourse.forEach {
                                if (it.courseId == aux.courseId && it.studentId == aux2.studentId) {
                                    Text(text = "-->"+aux2.nombre)
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}




