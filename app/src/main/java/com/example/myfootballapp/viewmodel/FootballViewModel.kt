package com.example.myfootballapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfootballapp.data.PlayerEntity
import com.example.myfootballapp.data.TeamEntity
import com.example.myfootballapp.repository.FootballRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FootballViewModel(private val repository: FootballRepository) : ViewModel() {
    private val _teamName = MutableStateFlow("")
    val teamName = _teamName.asStateFlow()
    val players = repository.getPlayers(1)

    init {
        viewModelScope.launch {
            repository.getTeam()?.let {
                _teamName.value = it.teamName
            }
        }
    }

    fun updateTeamName(name: String) {
        _teamName.value = name
        viewModelScope.launch {
            repository.saveTeam(TeamEntity(teamName = name))
        }
    }

    fun addPlayer(name: String) {
        viewModelScope.launch {
            repository.addPlayer(PlayerEntity(name = name, teamId = 1))
        }
    }

    fun deletePlayer(player: PlayerEntity) {
        viewModelScope.launch {
            repository.deletePlayer(player)
        }
    }
}