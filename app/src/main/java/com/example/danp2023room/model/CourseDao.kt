package com.example.danp2023room.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.danp2023room.entities.CourseEntity
import com.example.danp2023room.entities.CourseWithStudent
import com.example.danp2023room.entities.StudentNCourse

@Dao
interface CourseDao {

    @Query("select * from course")
    fun getAllCourses(): LiveData<List<CourseEntity>>

    @Query("select * from course where courseId = :courseId")
    suspend fun getCourse(courseId: Int): CourseEntity?

    @Query("select * from StudentNCourse")
    fun getAllStudentNCourse() : LiveData<List<StudentNCourse>>

    @Transaction
    @Query("select * from course where courseId = :courseId")
    suspend fun getCourseWithStudent(courseId : Int): LiveData<List<CourseWithStudent>>

    @Insert
    suspend fun insert(courseEntity: CourseEntity)

    @Insert
    suspend fun insert(coursesEntity: LiveData<List<CourseEntity>>)

    @Delete
    suspend fun delete(courseEntity: CourseEntity)

    @Update
    suspend fun updateCourse(course: CourseEntity)

    @Insert
    suspend fun insertStudentNCourse(studentNCourse: StudentNCourse)


}