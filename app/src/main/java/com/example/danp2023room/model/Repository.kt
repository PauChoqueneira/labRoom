package com.example.danp2023room.model

import androidx.lifecycle.LiveData
import com.example.danp2023room.entities.CourseEntity
import com.example.danp2023room.entities.StudentEntity
import com.example.danp2023room.entities.StudentNCourse
import com.example.danp2023room.entities.StudentWithCourses

class Repository(private val appDatabase: AppDatabase) {

    suspend fun insertarStudentNCourse(studentNCourse: StudentNCourse){
        return appDatabase.courseDao().insertStudentNCourse(studentNCourse)
    }

    suspend fun insertStudents(studentsEntity: List<StudentEntity>) {
        appDatabase.studentDao().insert(studentsEntity)
    }
    suspend fun insertStudent(studentsEntity: StudentEntity ) {
        appDatabase.studentDao().insert(studentsEntity)
    }

    suspend fun insertCourses(coursesEntity: LiveData<List<CourseEntity>>) {
        appDatabase.courseDao().insert(coursesEntity)
    }

    suspend fun insertCourse(coursesEntity: CourseEntity) {
        appDatabase.courseDao().insert(coursesEntity)
    }
}