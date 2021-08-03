package com.example.xcritical.dataBase

import com.example.xcritical.dataBase.DAO.ProjectDbDao
import com.example.xcritical.dataBase.entities.ProjectDb
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProjectDbRepository @Inject constructor(private val projectDbDao: ProjectDbDao) {

    fun getAllProjects() = projectDbDao.getAll()

    fun getProject(id: Long) = projectDbDao.getProject(id)

    fun insertProject(projectDb: ProjectDb) : Long = projectDbDao.insertProject(projectDb)

    fun updateProject(projectDb: ProjectDb) = projectDbDao.updateProject(projectDb)

    fun deleteProject(id: Long) = projectDbDao.deleteProject(id)
}