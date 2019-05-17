package com.numerica98.labo07_pdm_00002517.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "repos")//como se llamara nuestra tabla en la BD
data class GitHubRepo(

    @ColumnInfo(name = "s_name")
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}