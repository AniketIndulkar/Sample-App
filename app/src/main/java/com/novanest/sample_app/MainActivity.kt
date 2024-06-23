package com.novanest.sample_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.novanest.sample_app.navigation.Routes
import com.novanest.sample_app.presentation.char_list.CharacterList
import com.novanest.sample_app.presentation.char_list.DisneyCharacterListViewModel
import com.novanest.sample_app.presentation.ui.theme.SampleappTheme
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Route

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleappTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val padding = it
                    NavHost(navController = navController, startDestination = Routes.HOME){
                        composable(Routes.HOME){
                            val viewModel by viewModels<DisneyCharacterListViewModel>()
                            CharacterList(viewModel)
                        }
                        composable(Routes.CHARACTER_DETAILS){

                        }
                    }
                }

            }
        }
    }
}
