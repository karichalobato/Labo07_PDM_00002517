package com.numerica98.labo07_pdm_00002517.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.numerica98.labo07_pdm_00002517.database.daos.GitHuRepoDAO
import com.numerica98.labo07_pdm_00002517.database.entities.GitHubRepo

class GitHubRepoRepository(private  val repoDAO: GitHuRepoDAO) {

    //TODO OBTENER TODO
    fun getAll():LiveData<List<GitHubRepo>> = repoDAO.getAllRepos()

    //TODO BORRAR
    fun nuke() = repoDAO.nukeTable()

    //TODO INSERT
    @WorkerThread
    suspend fun insert(repo: GitHubRepo) = repoDAO.insertRepo(repo)
}