package com.example.mylab2

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.media.Image

import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.painter.Painter

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylab2.ui.theme.MyLab2Theme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // Greeting()

            MyLab2Theme() {
                Greeting()
            }

        }
    }
}

@Composable

fun Greeting() {

    // val name = remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    // val textFieldName = remember { mutableStateOf("") }
    var textFieldName by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        NameTextField(name = textFieldName, changed = { textFieldName = it })

        SayHi{ name = textFieldName

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.White)
        ) {
            MessageText(newName = name)

        }

        /*Button(
            onClick = {
                //your onclick code

            },
            border = BorderStroke(1.dp, Red),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text(text = "Button with border", color = Color.DarkGray)
        }*/
        val imageRes = arrayOf(R.drawable.ddd2,R.drawable.d3,R.drawable.d4, R.drawable.d5,R.drawable.scottydog)
        val number = imageRes.random()
        val image: Painter = painterResource(id = number)

        Image(painter = image,contentDescription = null,  modifier = Modifier
            .padding(top = 40.dp, bottom = 40.dp)
            .size(190.dp)
            .clip(CircleShape))

    }
}

@Composable
fun SayHi(clicked: () -> Unit){
    Button(onClick= clicked) {
        Text(stringResource(id = R.string.buttonHello))

    }

}

@Composable
fun NameTextField(name: String, changed: (String) ->Unit){
    TextField(
        value = name,
        label = {Text(stringResource(id = R.string.enterName))},
        onValueChange = changed,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp)
    )
}

@Composable
fun MessageText(newName: String){
    if(newName.isNotEmpty()) {
        Text(
            stringResource(R.string.greeting) + " " + newName,
            color = Color.Black,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

    }
}
@Composable

fun ImageResourceDemo() {
    val imageRes = arrayOf(R.drawable.ddd2,R.drawable.d3,R.drawable.d4, R.drawable.d5,R.drawable.scottydog)
//val ran = (0..6).random()
    val number = imageRes.random()
    val image: Painter = painterResource(id = number)

    Image(painter = image,contentDescription = null,  modifier = Modifier
        .padding(top = 40.dp, bottom = 40.dp)
        .size(190.dp)
        .clip(CircleShape))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyLab2Theme(darkTheme = true) {
        Greeting()
    }
}



