package com.novanest.sample_app.presentation.char_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp



@Composable
fun CharacterList(
    viewModel: DisneyCharacterListViewModel
){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = "Disney Characters", style = MaterialTheme.typography.h2)
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val listOfString = mutableListOf<String>("A","B","C")
            items(listOfString) {
                ClickableText(text = AnnotatedString(it) , style = MaterialTheme.typography.h3, modifier = Modifier.padding(16.dp),onClick = { offset ->
                println("Clicked on position: $offset")
                    viewModel.onEvent(GetDisneyCharactersEvent.FetchCharacters)
            })
            }
        }
    }
}