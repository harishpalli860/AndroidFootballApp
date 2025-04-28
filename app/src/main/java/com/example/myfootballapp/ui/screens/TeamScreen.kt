package com.example.myfootballapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myfootballapp.data.PlayerEntity
import com.example.myfootballapp.viewmodel.FootballViewModel

@Composable
fun TeamScreen(viewModel: FootballViewModel) {
    val teamName by viewModel.teamName.collectAsState()
    val players by viewModel.players.collectAsState(initial = emptyList())
    var newPlayerName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Team Name:")
        BasicTextField(value = teamName, onValueChange = { viewModel.updateTeamName(it) }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        Text("Players:")
        LazyColumn {
            items(players) { player ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Text(player.name)
                    IconButton(onClick = { viewModel.deletePlayer(player) }) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete Player")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            BasicTextField(value = newPlayerName, onValueChange = { newPlayerName = it }, modifier = Modifier.weight(1f))
            IconButton(onClick = {
                if (newPlayerName.isNotBlank()) {
                    viewModel.addPlayer(newPlayerName)
                    newPlayerName = ""
                }
            }) {
                Icon(Icons.Default.Add, contentDescription = "Add Player")
            }
        }
    }
}