package com.example.myfootballapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamEntity(
    @PrimaryKey val id: Int = 1,
    val teamName: String
)