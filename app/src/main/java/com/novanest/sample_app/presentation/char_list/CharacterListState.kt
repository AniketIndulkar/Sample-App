package com.novanest.sample_app.presentation.char_list

import com.novanest.sample_app.domain.model.DisneyCharacter

data class CharacterListState(
    val isLoading : Boolean = false,
    val disneyCharacterList : List<DisneyCharacter> = emptyList()
)
