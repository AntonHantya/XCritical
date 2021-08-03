package com.example.xcritical.dataBase.DAO

import androidx.room.*
import com.example.xcritical.dataBase.entities.ProjectDb

@Dao
interface ProjectDbDao {
    @Query("SELECT * FROM projectdb")
    fun getAll(): List<ProjectDb>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProject(project : ProjectDb): Long

    @Query("SELECT * FROM projectdb WHERE id = :projectId")
    fun getProject(projectId: Long): ProjectDb

    @Update
    fun updateProject(projectDb: ProjectDb)

    @Query("DELETE FROM projectdb WHERE id = :projectId")
    fun deleteProject(projectId: Long)
}