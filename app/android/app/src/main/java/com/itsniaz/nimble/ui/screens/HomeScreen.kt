package com.itsniaz.nimble.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itsniaz.nimble.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Preview
@Composable
fun HomeScreen() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = { DrawerContent(drawerState) },
        gesturesEnabled = true,
    ) {
        Scaffold(
            floatingActionButtonPosition = FabPosition.End,
            topBar = { TopBar(drawerState, scope) },
            bottomBar = { BottomBar() }
        ) { content ->
            Box(modifier = Modifier.padding(content))
        }
    }
}

enum class SelectedDrawer{
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
@Composable
private fun DrawerContent(drawerState: DrawerState) {

    var selectedDrawer by remember { mutableStateOf(SelectedDrawer.MyNotes) }
    val scope = rememberCoroutineScope()

    ModalDrawerSheet {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(
                modifier = Modifier.padding(16.dp),
                painter = painterResource(id = R.drawable.nimble_logo),
                contentDescription = "Nimble Logo"
            )
            Spacer(modifier = Modifier.height(16.dp))
            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_lightbulb_24), "Account Icon")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = stringResource(id = R.string.label_my_notes))
                }
            }, selected = selectedDrawer == SelectedDrawer.MyNotes, onClick = {
                selectedDrawer = SelectedDrawer.MyNotes
                scope.launch {
                    drawerState.close()
                }
            })
            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_lightbulb_24), "Account Icon")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Reminders")
                }
            }, selected = selectedDrawer == SelectedDrawer.Reminders, onClick = {
                selectedDrawer = SelectedDrawer.Reminders
                scope.launch {
                    drawerState.close()
                }

            })
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider()
            Row(modifier = Modifier.padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Text("Labels", fontSize = 12.sp)
                Spacer(modifier = Modifier.weight(1f))
                Box (modifier = Modifier
                    .clip((RoundedCornerShape(8.dp)))
                    .clickable {
                    }){
                    Text(text = "Edit",
                        fontSize = 12.sp,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
                }
            }

            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_label_outlined_24), "Account Icon")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Personal")
                }
            }, selected = selectedDrawer == SelectedDrawer.Personal, onClick = {
                scope.launch {
                    drawerState.close()
                }
                selectedDrawer = SelectedDrawer.Personal })

            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_label_outlined_24), "")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Work")
                }
            }, selected = false, onClick = {
                selectedDrawer = SelectedDrawer.Work
                scope.launch {
                    drawerState.close()
                }
            })


            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Outlined.Add, "")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Create new label")
                }
            }, selected = selectedDrawer == SelectedDrawer.CreateNewLabel, onClick = {
                scope.launch {
                    drawerState.close()
                }
                selectedDrawer = SelectedDrawer.CreateNewLabel })

            HorizontalDivider()
            Box(modifier = Modifier.height(24.dp))

            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_outline_archive_24), "")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Archive")
                }
            }, selected = selectedDrawer == SelectedDrawer.Archive, onClick = {
                scope.launch {
                    drawerState.close()
                }
                selectedDrawer = SelectedDrawer.Archive })


            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.ic_outlied_trash_24), contentDescription = "Trash")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Trash")
                }
            }, selected = selectedDrawer == SelectedDrawer.Trash, onClick = { selectedDrawer = SelectedDrawer.Trash })

            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.outline_settings_24), contentDescription = "Trash")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Settings")
                }
            }, selected = selectedDrawer == SelectedDrawer.Settings, onClick = {
                scope.launch {
                    drawerState.close()
                }
                selectedDrawer = SelectedDrawer.Settings })


            NavigationDrawerItem(label = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.outline_help_outline_24), contentDescription = "Trash")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Help And Feedback")
                }
            }, selected = selectedDrawer == SelectedDrawer.HelpAndFeedback, onClick = {
                scope.launch {
                    drawerState.close()
                }
                selectedDrawer = SelectedDrawer.HelpAndFeedback

            })



        }
    }
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


@Composable
private fun BottomBar() {
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

