package com.example.afsal.roomtutorialcoroutine.daos

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.afsal.roomtutorialcoroutine.models.Task


@Dao
interface TaskDao {

    @Insert
    fun addNewTask(task: Task)

    @Query("SELECT * FROM task order by id DESC")
    fun getAllTask(): List<Task>
}