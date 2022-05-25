package com.gonzalab.marveldataverse.presentation.character_list

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.gonzalab.marveldataverse.R
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

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(characterListItems) { item ->
            item?.let {
                CharacterItem(
                    character = item,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // TODO: Click is inside item composable. 
                        })
            }
        }

        // Load State management.
        characterListItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    // You can add modifier to manage load state when first time response page is loading.
                    Logger.w("CharacterListScreen -> LoadState First response")
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillParentMaxSize()
                                .wrapContentSize(Alignment.Center)
                        )
                    }
                }
                loadState.append is LoadState.Loading -> {
                    // You can add modifier to manage load state when next response page is loading.
                    Logger.w("CharacterListScreen -> LoadState Next response")
                    // Circular progress indicator current page when loading next.
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.CenterHorizontally)
                        )
                    }
                }
                loadState.append is LoadState.Error -> {
                    // You can use modifier to show error message.
                    Logger.e("CharacterListScreen -> LoadState Error")
                    item {
                        Text(text = context.getString(R.string.generic_api_error))
                    }
                }
            }
        }
    }
}