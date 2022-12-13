package com.example.mangrove.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangrove.Model.ProductPosted
import com.example.mangrove.Model.SampleFarmers
import com.example.mangrove.R

@Composable
fun mainFun()
{
    Column() {
        SearchProductTextFieldSample()
        DisplayProduct(SampleFarmers.FarmersSample)
    }
}

@Composable
fun DisplayProduct(messages: List<ProductPosted>) {
    LazyColumn {
        messages.map { item { viewproduct(it) } }
    }
}
@Composable
fun viewproduct(variable:ProductPosted)
{
    var isExpanded by remember { mutableStateOf(false) }
//
//        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
//            Text(text = variable.name,
//                color = Color.Black,
//                style = MaterialTheme.typography.subtitle2
//            )
//            Spacer(modifier = Modifier.height(10.dp))
//            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp,color = MaterialTheme.colors.surface,
//            ) {
//                Text(text = variable.productType
//                    +"\n"+variable.kiloPersack
//                    +"\n"+variable.location
//                    +"\n"+variable.numbsack
//                    +"\n"+variable.number,
//                    maxLines = if (isExpanded) Int.MAX_VALUE else 2,
//                    style = TextStyle(
//                        //color = Color.Red,
//                        fontSize = 10.sp,
//                        fontFamily = FontFamily.Monospace,
//                        fontWeight = FontWeight.Normal,
//                        fontStyle = FontStyle.Italic,
//                    )
//                )
//            }
//    }
    //SearchProductTextFieldSample()
    Card(elevation = 10.dp,
        modifier = Modifier
            .padding(start = 25.dp, top = 20.dp)
            .clickable { isExpanded = !isExpanded }
            .size(width = 350.dp, height = 250.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column() {
            Row() {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_person_24),
                    contentDescription ="Chevron",
                    modifier = Modifier
                        .padding(top = 14.dp, start = 10.dp)
                        .size(width = 40.dp, 40.dp))
                Text(text = variable.name,
                    //fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 19.dp, start = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp)
            }


            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_production_quantity_limits_24),
                    contentDescription ="Chevron",
                    modifier = Modifier
                        .padding(top = 14.dp, start = 10.dp)
                        .size(width = 40.dp, 40.dp))
                Text(text = variable.productType,
                    //fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 19.dp, start = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_add_location_24),
                    contentDescription ="Chevron",
                    modifier = Modifier
                        .padding(top = 14.dp, start = 10.dp)
                        .size(width = 40.dp, 40.dp))
                Text(text = variable.location,
                    //fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 19.dp, start = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Row() {
                Icon(
                    painter = painterResource(R.drawable.ic_baseline_phone_24),
                    contentDescription ="Chevron",
                    modifier = Modifier
                        .padding(top = 14.dp, start = 10.dp)
                        .size(width = 40.dp, 40.dp))
                Text(text = variable.number,
                    //fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 19.dp, start = 20.dp),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp)
            }

        }
    }
}
@Composable
fun SearchProductTextFieldSample() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon", modifier = Modifier.size(35.dp)) },
        onValueChange = { text = it },
        label = { Text("Search",color = Color.Black) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 14.dp, top = 6.dp, end = 14.dp),
        colors= TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = Color.Black,
            textColor = Color.Black,
        ),
        shape = RoundedCornerShape(20.dp)
        //color=Color.White
        //modifier = Modifier.align(Alignment.TopCenter)
    )
}