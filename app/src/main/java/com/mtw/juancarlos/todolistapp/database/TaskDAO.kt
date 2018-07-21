package com.mtw.juancarlos.todolistapp.database

import android.arch.persistence.room.*

@Dao
interface TaskDAO {

    @Query("Select * from task order by priority")
    fun loadAllTask():List<TaskEntry>

    @Insert
    fun insertTask(taskEntry:TaskEntry)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateTask(task: TaskEntry)

    @Delete
    fun deleteTask(taskEntry: TaskEntry)

    @Query ("DELETE FROM task")
    fun deleteAll()


    @Query ("SELECT * FROM task WHERE id = :id")
    fun loadTaskById(id: Long):TaskEntry


}