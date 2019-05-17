package com.numerica98.labo07_pdm_00002517.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.numerica98.labo07_pdm_00002517.database.daos.GitHuRepoDAO
import com.numerica98.labo07_pdm_00002517.database.entities.GitHubRepo

@Database(entities = [GitHubRepo::class], version = 1, exportSchema = false)//si tengo mas entidades separo por "," ripio::class. SI CAMBIO ALGO EN ENTIDADES TENGO QUE CAMBIAR LA VERSION
 public abstract class RoomDB : RoomDatabase(){

    abstract fun repoDAO():GitHuRepoDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDB? = null

        //TODO EL PROCESO DE DEVOLVERME LA BASE DE DATOS
        fun getInstance(AppContext: Context): RoomDB{
            val temp = INSTANCE

            if (temp != null){
                return  temp
            }

            synchronized(this){ //TODO CREA LA BASE DE DATOS EN UN SOLO HILO
                val instance = Room.databaseBuilder(AppContext, RoomDB::class.java, "RepoDB")
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}