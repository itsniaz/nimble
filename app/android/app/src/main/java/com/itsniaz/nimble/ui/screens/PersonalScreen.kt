package com.itsniaz.nimble.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itsniaz.nimble.R
import com.itsniaz.nimble.ui.components.BottomBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalScreen(drawer : DrawerState){

    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Row (verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = { scope.launch { drawer.open() } }) {
                        Icon(Icons.Outlined.Menu, contentDescription = "Menu")
                    }
                    Box(modifier = Modifier.width(8.dp))
                    Text(text = "Personal")
                } },
                actions = {
                    IconButton(onClick = { /* Do something */ }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* Do something */ }) {
                        Icon(Icons.Default.List, contentDescription = "List")
                    }
                }
            )
        },
        bottomBar = { BottomBar() },
    ) { content ->
        Box ( modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center){
            Column(
                modifier = Modifier.padding(content),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(modifier = Modifier
                    .padding(16.dp)
                    .size(128.dp), painter = painterResource(id = R.drawable.ic_label_outlined_24), contentDescription = "")
                Text(text = "No notes with label yet")
            }
        }
    }

}