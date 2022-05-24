package com.gonzalab.marveldataverse.presentation.character_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.gonzalab.marveldataverse.domain.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    // Flow with characters list.
    var charactersList = repository.getCharactersList().cachedIn(viewModelScope)
}