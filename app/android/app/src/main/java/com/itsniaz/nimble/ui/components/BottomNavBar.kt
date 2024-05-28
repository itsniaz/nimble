package com.itsniaz.nimble.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.itsniaz.nimble.R

@Composable
fun BottomBar() {
    BottomAppBar(
        actions = {
            BottomBarActions()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = BottomAppBarDefaults.containerColor,
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(Icons.Outlined.Add, "Create New Note")
            }
        }
    )
}

@Composable
private fun BottomBarActions() {
    IconButton(onClick = { /* do something */ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_checkbox),
            contentDescription = "Create Checklist"
        )
    }
    IconButton(onClick = { /* do something */ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_outline_brush_24),
            contentDescription = "Create Canvas"
        )
    }
    IconButton(onClick = { /* do something */ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_mic_none_24),
            contentDescription = "Create Voice Memo"
        )
    }
    IconButton(onClick = { /* do something */ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_outline_image_24),
            contentDescription = "Add Image"
        )
    }
}

