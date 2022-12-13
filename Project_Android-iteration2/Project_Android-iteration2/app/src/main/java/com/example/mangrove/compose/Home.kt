package com.example.mangrove.compose

import android.media.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.BoxScopeInstance.align
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangrove.R

@Composable
fun HomeScreen(ClickLogin:()->Unit,ClickRegister:()->Unit,category:()->Unit)
{
    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)

    ) {

        SimpleFilledTextFieldSample()
        Spacer(modifier = Modifier.height(7.dp))
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
        Spacer(modifier = Modifier.height(5.dp))
          Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
              SignUp(ClickRegister)
              Spacer(modifier = Modifier.weight(1f,true))
              SignIn(ClickLogin)
          }
        Spacer(modifier = Modifier.height(15.dp))
        Mycard1(category)
        Spacer(modifier = Modifier.height(15.dp))
        Mycard2()
        Spacer(modifier = Modifier.height(5.dp))
        Text("Top of Categories", fontSize = 25.sp,
            color = Color.Black,
        modifier = Modifier.padding(start = 16.dp))
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.strawberry),
            contentDescription = stringResource(id = R.string.fruit),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(16f / 9f)
                .padding(start = 16.dp, end = 16.dp),


        )
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = stringResource(id = R.string.fruit),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(90.dp),

                )
            Image(
                painter = painterResource(id = R.drawable.image2),
                contentDescription = stringResource(id = R.string.fruit),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 35.dp)
                    .size(90.dp),
            )
            Image(
                painter = painterResource(id = R.drawable.image3),
                contentDescription = stringResource(id = R.string.fruit),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .size(90.dp),
            )
        }
    }
}

@Composable
fun SimpleFilledTextFieldSample() {
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
@Composable
fun SignUp(Clicked1:()->Unit){
    Button(
        onClick = Clicked1,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryVariant),
        modifier = Modifier
            .size(height = 45.dp, width = 120.dp)
            .padding(start = 16.dp)
        ,elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    )
    {
        Text(text = "SIGNUP",color = Color.Black,fontWeight = FontWeight.Bold)
    }
}

//Add Farmer
@Composable
fun SignIn(Clicked:()->Unit){
    Button(onClick = Clicked,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryVariant),
        modifier = Modifier
            .size(height = 45.dp, width = 120.dp)
            .padding(end = 16.dp),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    )
    {
        Text(text = "SIGNIN",color = Color.Black, fontWeight = FontWeight.Bold)
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Mycard1(Cat:()->Unit)
{
        Card(
            modifier = Modifier
                //.background(color = Color.White)
                .size(width = 375.dp, height = 60.dp)
                .padding(start = 16.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color.Black),
            onClick = Cat
        ) {
            Row()
            {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_list_alt_24),
                    contentDescription ="Chevron",
                    //modifier = Modifier.size(55.dp)
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 3.dp, top = 7.dp)
                )

                Text(text = stringResource(id = R.string.profiletext),
                    //fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 9.dp, start = 37.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp)
                Spacer(modifier = Modifier.weight(0.01f,true))
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_chevron_right_24),
                    contentDescription ="Chevron",
                    modifier = Modifier.size(55.dp)
                )

            }
        }
}
@Composable
fun Mycard2()
{
    Card(
        modifier = Modifier
            //.background(color = Color.White)
            .size(width = 375.dp, height = 60.dp)
            .padding(start = 16.dp),
        elevation = 5.dp,
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, Color.Black)

    ) {
        Row() {
            Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon",
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 3.dp, top = 7.dp))
            //Spacer(modifier = Modifier.weight(0.01f,true))
            Text(text = stringResource(id = R.string.recent),
                //fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 9.dp, start = 37.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp)
            Spacer(modifier = Modifier.weight(0.01f,true))
            Icon(
                painter = painterResource(R.drawable.ic_baseline_chevron_right_24),
                contentDescription ="Chevron",
                modifier = Modifier.size(55.dp)
            )
        }

    }
}
