package com.example.danp2023room.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.danp2023room.entities.StudentEntity
import com.example.danp2023room.entities.StudentWithCourses

@Dao
interface StudentDao {
    @Query("select * from Student")
    fun getAllStudents(): LiveData<List<StudentEntity>>

    @Transaction
    @Query("select * from student where studentId = :StudentId")
    fun getStudentWithCourse(StudentId : Int): LiveData<List<StudentWithCourses>>

    @Query("SELECT * from Student WHERE StudentId = :studentId")
    suspend fun getStudent(studentId: Int): StudentEntity?

    @Insert
    suspend fun insert(studentEntity: StudentEntity)

    @Insert
    suspend fun insert(studentsEntity: List<StudentEntity>)

    @Delete
    suspend fun delete(studentEntity: StudentEntity)

    @Update
    suspend fun updateStudent(student: StudentEntity)
}