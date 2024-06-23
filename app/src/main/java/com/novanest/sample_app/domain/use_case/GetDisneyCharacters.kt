package com.novanest.sample_app.domain.use_case

import com.novanest.sample_app.domain.model.DisneyCharacter
import com.novanest.sample_app.domain.repository.DisneyCharacterRepository
import javax.inject.Inject

class GetDisneyCharacters @Inject constructor(private val repository : DisneyCharacterRepository){
    suspend operator fun invoke(): Result<List<DisneyCharacter>> {
        return repository.getCharacters()
    }
}