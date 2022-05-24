package com.gonzalab.marveldataverse.presentation.character_list

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.gonzalab.marveldataverse.domain.model.Character
import com.orhanobut.logger.Logger
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun CharacterListScreen(
    navigator: DestinationsNavigator,
    viewModel: CharacterListViewModel = hiltViewModel(),
    context: Context = LocalContext.current
) {
    val characterListItems: LazyPagingItems<Character> =
        viewModel.charactersList.collectAsLazyPagingItems()

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(characterListItems) { item ->
            item?.let {
                CharacterItem(
                    character = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            Toast
                                .makeText(context, "Tap", Toast.LENGTH_SHORT)
                                .show()
                        })
            }
        }
    }
    // Load State management.
    characterListItems.apply {
        when {
            loadState.refresh is LoadState.Loading -> {
                //You can add modifier to manage load state when first time response page is loading
                Logger.w("CharacterListScreen -> LoadState First response")
            }
            loadState.append is LoadState.Loading -> {
                //You can add modifier to manage load state when next response page is loading
                Logger.w("CharacterListScreen -> LoadState Next response")
            }
            loadState.append is LoadState.Error -> {
                //You can use modifier to show error message
                Logger.e("CharacterListScreen -> LoadState Error")
            }
        }
    }
}