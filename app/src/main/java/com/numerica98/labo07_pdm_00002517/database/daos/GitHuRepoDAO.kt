package com.numerica98.labo07_pdm_00002517.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.numerica98.labo07_pdm_00002517.database.entities.GitHubRepo

@Dao
interface GitHuRepoDAO {

    @Query("SELECT * FROM repos") //para sacar algo de la tabla repos.
    fun getAllRepos():LiveData<List<GitHubRepo>>

    @Query("DELETE FROM repos")
    fun nukeTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)//HACIENDO UN INSERT Y UN UPDATE EN LA MISMA LINEA
    suspend fun insertRepo(repo: GitHubRepo)//Detener el proceso de entrada hasta que termine. Para poder utilizarlo en corrutinas
}