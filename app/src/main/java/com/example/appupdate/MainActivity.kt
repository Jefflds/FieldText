package com.example.appupdate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appupdate.ui.theme.AppUpdateTheme

private val Typography.h5: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppUpdateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingScreen()
                }
            }
        }
    }


    @Composable
    fun GreetingScreen() {
        var userInput by remember { mutableStateOf("") }
        var greetingText by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BasicTextField(
                value = userInput,
                onValueChange = { newValue ->
                    userInput = newValue
                },
                singleLine = true,
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier
                    .fillMaxWidth()

                    .padding(8.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Button(
                onClick = {
                    greetingText = "Hello, $userInput!"
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Say Hello")
            }

            Text(
                text = greetingText,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(16.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingScreenPreview() {
        AppUpdateTheme {
            GreetingScreen()
        }
    }
}