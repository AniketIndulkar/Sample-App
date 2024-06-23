package com.novanest.sample_app.presentation.char_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.novanest.sample_app.domain.use_case.GetDisneyCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisneyCharacterListViewModel @Inject constructor(private val getDisneyCharacters : GetDisneyCharacters) :ViewModel() {

    private var state by mutableStateOf(CharacterListState())

    fun onEvent(event : GetDisneyCharactersEvent){
        when(event){
            is GetDisneyCharactersEvent.FetchCharacters -> {
                viewModelScope.launch {
                    state= state.copy(isLoading = true)
                    getDisneyCharacters().onSuccess {
                        print(it)
                        state = state.copy(isLoading = false, disneyCharacterList = it)
                    }
                }
            }
            else ->{

            }
        }
    }

}