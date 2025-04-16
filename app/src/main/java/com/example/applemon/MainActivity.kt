package com.example.applemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applemon.ui.theme.AppLemonTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLemonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppLemon(
                    )
                }
            }
        }
    }
}



@Composable
fun AppLemon() {
    var currentStep by remember { mutableStateOf(1) }
    var stepState by remember { mutableStateOf(0) }
    var contador by remember { mutableStateOf(0) }

    //Usamos el contador en 0 para que el ciclo vuelva iniciar
    when(currentStep){

        2 ->{ stepState = Random.nextInt(1,5)
        contador = 0
        }

    }
    var imageResource = when (currentStep) {
        1 -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.Tap_the_lemon_tree))
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(R.drawable.lemon_tree),
                contentDescription = stringResource(R.string.Lemon),
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { currentStep = 2 })
        }

        2 -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.Keep_tapping))
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(R.drawable.lemon_squeeze),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        contador++
                        if (contador >= stepState){
                        currentStep = 3
                    }
                    })

        }

        3 -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.Tap_the_lemonade_to_drink))
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(R.drawable.lemon_drink),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { currentStep = 4 })

        }

        else -> Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.Tap_the_empty))
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(R.drawable.lemon_restart),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .clickable { currentStep = 1 })


        }
    }
}

