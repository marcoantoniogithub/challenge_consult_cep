package com.example.challenge_consult_cep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge_consult_cep.ui.theme.Challenge_consult_cepTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Challenge_consult_cepTheme {
                MyApp(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun MyApp(modifier: Modifier = Modifier) {
        Surface(
            modifier = modifier,
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TitleHome("BUSQUE CEP AQUI", Modifier.padding(20.dp))
                InputBoxCEP()
                ListCEP(
                    /*listOf(
                        ListCEP(label = "ESTADO", value = "1"),
                        ListCEP(label = "ESTADO", value = "2"),
                        ListCEP(label = "ESTADO", value = "3"),
                        ListCEP(label = "ESTADO", value = "4"),
                        ListCEP(label = "ESTADO", value = "5"),
                        ListCEP(label = "ESTADO", value = "6"),
                        ListCEP(label = "ESTADO", value = "7"),
                        ListCEP(label = "ESTADO", value = "8"),
                        ListCEP(label = "ESTADO", value = "9"),
                        ListCEP(label = "ESTADO", value = "10"),
                        ListCEP(label = "ESTADO", value = "11"),
                        ListCEP(label = "ESTADO", value = "12"),
                        ListCEP(label = "ESTADO", value = "13"),
                        ListCEP(label = "ESTADO", value = "14"),
                        ListCEP(label = "ESTADO", value = "15"),
                        ListCEP(label = "ESTADO", value = "16"),
                        ListCEP(label = "ESTADO", value = "17"),
                        ListCEP(label = "ESTADO", value = "18"),
                        ListCEP(label = "ESTADO", value = "19"),
                        ListCEP(label = "ESTADO", value = "20"),
                    )*/
                    emptyList()
                )
            }
        }
    }

    @Composable
    fun TitleHome(name: String, modifier: Modifier = Modifier) {
        Text(
            text = name,
            modifier = modifier,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
    }

    @ExperimentalMaterial3Api
    @Composable
    fun InputBoxCEP() {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.padding(30.dp),
            label = { Text(text = "CEP")}
        )
    }

    @Composable
    fun ListCEP(messages: List<ListCEP>) {
        LazyColumn(
            modifier = Modifier.padding(10.dp)
        ) {
            item {
                messages.forEach { message ->
                    itemListCEP(
                        message,
                        Modifier
                            .background(Color.Gray)
                            .padding(10.dp)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }

    @Composable
    fun itemListCEP(messages: ListCEP, modifier: Modifier = Modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = messages.label, modifier = Modifier
                    .padding(horizontal = 5.dp)
            )
            Text(text = messages.value)
        }
    }
}
data class ListCEP(
    val label: String,
    val value: String
)
