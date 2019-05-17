package com.numerica98.labo07_pdm_00002517.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.numerica98.labo07_pdm_00002517.database.RoomDB
import com.numerica98.labo07_pdm_00002517.database.entities.GitHubRepo
import com.numerica98.labo07_pdm_00002517.database.repositories.GitHubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GitHubRepoViewModel(app: Application): AndroidViewModel(app) {

    private val repository: GitHubRepoRepository

    init {
        val repoDAO = RoomDB.getInstance(app).repoDAO()//TODO OBTENEMOS EL DAO LINKEADO CON NUESTRA BASE DE DATOS

        repository = GitHubRepoRepository(repoDAO)
    }

    fun getRepoList():LiveData<List<GitHubRepo>> = repository.getAll()

    fun insert(repo: GitHubRepo) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(repo)
    }
}