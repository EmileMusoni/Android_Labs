package com.example.mangrove.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangrove.R

@Composable
fun SearchScreen()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)
    ) {
        SimpleFilledTextFieldSample1()
//        Image(painter = painterResource(id = R.drawable.ic_baseline_search_24), contentDescription = "",modifier = Modifier.align(
//            Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.align(Alignment.CenterHorizontally),
        ) {
            Text(text = stringResource(id = R.string.man),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
            Text(text = stringResource(id = R.string.grove),
                fontWeight = FontWeight.Bold,
                color =MaterialTheme.colors.onSecondary,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
        }
   }
}

@Composable
fun SimpleFilledTextFieldSample1() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon", modifier = Modifier.size(35.dp)) },
        onValueChange = { text = it },
        label = { Text("Search",color = Color.Black) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 14.dp, top = 6.dp, end = 14.dp),
        colors=TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = Color.Black,
            textColor = Color.Black,
        ),
        shape = RoundedCornerShape(20.dp)
        //color=Color.White
        //modifier = Modifier.align(Alignment.TopCenter)
    )
}