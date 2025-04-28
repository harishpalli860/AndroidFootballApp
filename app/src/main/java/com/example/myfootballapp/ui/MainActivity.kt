package com.example.myfootballapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.room.Room
import com.example.myfootballapp.data.AppDatabase
import com.example.myfootballapp.repository.FootballRepository
import com.example.myfootballapp.ui.screens.TeamScreen
import com.example.myfootballapp.viewmodel.FootballViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "football-db").build()
        val repository = FootballRepository(db.playerDao())
        val viewModel = FootballViewModel(repository)
        setContent {
            MaterialTheme {
                Surface {
                    TeamScreen(viewModel)
                }
            }
        }
    }
}