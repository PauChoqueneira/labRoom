package com.example.danp2023room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.danp2023room.entities.CourseEntity
import com.example.danp2023room.entities.StudentEntity
import com.example.danp2023room.entities.StudentNCourse
import com.example.danp2023room.model.AppDatabase
import com.example.danp2023room.model.Repository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val allCourseData : LiveData<List<CourseEntity>>
    private val allStudentData : LiveData<List<StudentEntity>>
    private val allStudentNCourse : LiveData<List<StudentNCourse>>
    private val repository : Repository

    init {
        repository = Repository(AppDatabase.getInstance(application))
        val courseDao = AppDatabase.getInstance(application).courseDao()
        val studentDao = AppDatabase.getInstance(application).studentDao()
        allCourseData = courseDao.getAllCourses()
        allStudentData = studentDao.getAllStudents()
        allStudentNCourse = courseDao.getAllStudentNCourse()
    }

    fun getAllStudentNCourse(): LiveData<List<StudentNCourse>>{
        return allStudentNCourse
    }

    fun getAllCourse(): LiveData<List<CourseEntity>> {
        return allCourseData
    }
    fun insertCourse(course: CourseEntity){
        viewModelScope.launch {
            repository.insertCourse(course)
        }
    }

    fun insertStudentNCourse(studentNCourse: StudentNCourse){
        viewModelScope.launch {
            repository.insertarStudentNCourse(studentNCourse)
        }
    }

    fun getAllStudent() : LiveData<List<StudentEntity>> {
        return allStudentData
    }
    fun insertStudent(studentEntity: StudentEntity){
        viewModelScope.launch {
            repository.insertStudent(studentEntity)
        }
    }


}

