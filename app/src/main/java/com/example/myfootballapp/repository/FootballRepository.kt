package com.example.myfootballapp.repository

import com.example.myfootballapp.data.PlayerDao
import com.example.myfootballapp.data.PlayerEntity
import com.example.myfootballapp.data.TeamEntity

class FootballRepository(private val dao: PlayerDao) {
    fun getPlayers(teamId: Int) = dao.getPlayers(teamId)
    suspend fun addPlayer(player: PlayerEntity) = dao.insertPlayer(player)
    suspend fun deletePlayer(player: PlayerEntity) = dao.deletePlayer(player)
    suspend fun saveTeam(team: TeamEntity) = dao.insertTeam(team)
    suspend fun getTeam() = dao.getTeam()
}