package com.itsniaz.nimble.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.itsniaz.nimble.R
import com.itsniaz.nimble.ui.components.BottomBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun MyNotes(drawerState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(
        floatingActionButtonPosition = FabPosition.End,
        topBar = { TopBar(drawerState, scope) },
        bottomBar = { BottomBar() }
    ) { content ->
        Box(modifier = Modifier.padding(content))
    }
}

enum class SelectedDrawer {
    MyNotes,
    Reminders,
    Personal,
    Work,
    CreateNewLabel,
    Archive,
    Trash,
    Settings,
    HelpAndFeedback
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(drawerState: DrawerState, scope: CoroutineScope) {
    SearchBar(
        query = "",
        placeholder = { Text(text = "Search your notes here") },
        leadingIcon = {
            IconButton(onClick = {
                scope.launch {
                    if (drawerState.isOpen) {
                        drawerState.close()
                    } else {
                        drawerState.open()
                    }
                }
            }) {
                Icon(Icons.Outlined.Menu, "Menu Icon")
            }
        },
        trailingIcon = { TopBarTrailingIcons() },
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {}
}

@Composable
private fun TopBarTrailingIcons() {
    Row(Modifier.padding(16.dp)) {
        Icon(Icons.Outlined.MailOutline, contentDescription = "Mail Icon")
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painter = painterResource(R.drawable.avatar),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,            // crop the image if it's not a square
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(1.5.dp, Color.Gray, CircleShape)   // add a border (optional)
        )
    }
}