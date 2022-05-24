package com.gonzalab.marveldataverse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.EventNote
import androidx.compose.material.icons.rounded.MenuBook
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gonzalab.marveldataverse.presentation.character_list.NavGraphs
import com.gonzalab.marveldataverse.ui.theme.MarvelDataVerseTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelDataVerseTheme {
                // A surface container using the 'background' color from the theme
                var isRoot by remember {
                    mutableStateOf(true)
                }
                var selectedItem by remember {
                    mutableStateOf(0)
                }
                val items =
                    listOf(
                        getString(R.string.characters),
                        getString(R.string.comics),
                        getString(R.string.events)
                    )

                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(text = getString(R.string.app_name)) },
                            navigationIcon = {
                                if (!isRoot) {
                                    IconButton(onClick = { /* doSomething() */ }) {
                                        Icon(
                                            imageVector = Icons.Rounded.ArrowBack,
                                            contentDescription = "Back",
                                        )
                                    }
                                }
                            },
                            actions = {}
                        )
                    },
                    bottomBar = {
                        NavigationBar {
                            items.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    icon = {
                                        when (index) {
                                            0 -> Icon(
                                                Icons.Rounded.Person,
                                                contentDescription = null
                                            )
                                            1 -> Icon(
                                                Icons.Rounded.MenuBook,
                                                contentDescription = null
                                            )
                                            2 -> Icon(
                                                Icons.Rounded.EventNote,
                                                contentDescription = null
                                            )
                                        }

                                    },
                                    selected = selectedItem == index,
                                    onClick = { selectedItem = index },
                                    label = {
                                        Text(text = item)
                                    }
                                )
                            }
                        }
                    }
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it)
                    )
                    {
                        DestinationsNavHost(navGraph = NavGraphs.root)
                    }
                }
            }
        }
    }
}