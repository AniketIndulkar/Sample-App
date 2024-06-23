package com.novanest.sample_app.presentation.char_list

import com.novanest.sample_app.domain.use_case.GetDisneyCharacters

sealed class GetDisneyCharactersEvent {
    data object FetchCharacters : GetDisneyCharactersEvent()
}