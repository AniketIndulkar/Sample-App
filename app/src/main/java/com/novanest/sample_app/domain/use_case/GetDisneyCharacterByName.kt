package com.novanest.sample_app.domain.use_case

import com.novanest.sample_app.domain.model.DisneyCharacter
import com.novanest.sample_app.domain.repository.DisneyCharacterRepository

class GetDisneyCharacterByName(private val repository : DisneyCharacterRepository) {

    suspend operator fun invoke(characterName : String) :Result<DisneyCharacter>{
       return repository.getCharacterByName(characterName)
    }
}