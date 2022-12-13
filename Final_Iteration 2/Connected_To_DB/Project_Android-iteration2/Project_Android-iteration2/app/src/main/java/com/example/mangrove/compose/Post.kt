package com.example.mangrove.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.RowScopeInstance.weight
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
fun PostScreen()
{
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)
    ) {
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
        Spacer(modifier = Modifier.height(10.dp))
        newMycard()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard1()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard2()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard3()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard4()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard5()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard6()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard7()
        Spacer(modifier = Modifier.height(10.dp))
        newMycard8()
    }
}
@Composable
fun newMycard()
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
        Row()
        {
            Text(text = stringResource(id = R.string.cat1),
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
fun newMycard1()
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
        Row()
        {
            Text(text = stringResource(id = R.string.cat2),
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
fun newMycard2()
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
        Row()
        {
            Text(text = stringResource(id = R.string.cat3),
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
fun newMycard3()
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
        Row()
        {
            Text(text = stringResource(id = R.string.cat4),
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
fun newMycard4()
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
        Row()
        {

            Text(text = stringResource(id = R.string.cat5),
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
fun newMycard5()
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
        Row()
        {

            Text(text = stringResource(id = R.string.cat6),
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
fun newMycard6()
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
        Row()
        {


            Text(text = stringResource(id = R.string.cat7),
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
fun newMycard7()
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
        Row()
        {


            Text(text = stringResource(id = R.string.cat8),
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
fun newMycard8()
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
        Row()
        {


            Text(text = stringResource(id = R.string.cat9),
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