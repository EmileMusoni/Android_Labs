package com.example.mangrove.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
//import androidx.compose.foundation.layout.BoxScopeInstance.align
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangrove.R

@Composable
fun ProfileScreen(addingProdPage:()->Unit)
{
    readFarmersFromDatabase(LocalContext.current)
   /* Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)
    ) {

        Spacer(modifier = Modifier.height(20.dp))
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
        Spacer(modifier = Modifier.height(20.dp))
        Card(elevation = 10.dp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(20.dp)
                .size(width = 160.dp, height = 160.dp),
            shape = RoundedCornerShape(80.dp)

        ) {
            Icon(
                painter = painterResource(R.drawable.ic_baseline_person_24),
                contentDescription ="Chevron",
                modifier =Modifier.padding(10.dp))
        }
        Spacer(modifier = Modifier.height(5.dp))
        Card(elevation = 10.dp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(width = 350.dp, height = 370.dp),
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
                    Text(text = "Isabwe Egide",
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
                    Text(text = "+250788565674",
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
                    Text(text = "Karongi",
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
                    Text(text = "Potato",
                        //fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 19.dp, start = 20.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp)
                }
                AlertDialogSample()
                AddProductButton(addingProdPage)
            }
        }
    }*/
   // AlertDialogSample()
    AddProductButton(addingProdPage)
}
@Composable
fun AddProductButton(myfunction:()->Unit) {
    Button(onClick = myfunction,
        modifier = Modifier.padding(start = 16.dp)
            .size(width = 320.dp, height = 40.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryVariant)
    ) {
        Text(text = "Add your Product",
            color = Color.Black, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun AlertDialogSample() {
    MaterialTheme {
        Column  {
            val openDialog = remember { mutableStateOf(false)  }

            Button(onClick = {
                openDialog.value = true
            },
            modifier = Modifier.padding(16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryVariant)) {
                Text("EDIT",color = Color.Black, fontWeight = FontWeight.Bold)
            }

            if (openDialog.value) {

                AlertDialog(
                    onDismissRequest = {
                        // Dismiss the dialog when the user clicks outside the dialog or on the back
                        // button. If you want to disable that functionality, simply use an empty
                        // onCloseRequest.
                        openDialog.value = false
                    },
                    title = {
                        Text(text = "Edit your Profile",color = Color.Black, fontWeight = FontWeight.Bold)
                    },
                    text = {
                        Column() {
                            SimpleFilledTextFieldSample2()
                            //Spacer(modifier = Modifier.height(5.dp))
                            SimpleFilledTextFieldSample3()
                           // Spacer(modifier = Modifier.height(5.dp))
                            SimpleFilledTextFieldSample4()
                            //Spacer(modifier = Modifier.height(5.dp))
                            SimpleFilledTextFieldSample5()
                        }
                    },
                    confirmButton = {
                        Button(

                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("Save",color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    },
                    dismissButton = {
                        Button(
                            onClick = {
                                openDialog.value = false
                            }) {
                            Text("Close",color = Color.Black, fontWeight = FontWeight.Bold)
                        }
                    }
                )
            }
        }

    }
}

@Composable
fun SimpleFilledTextFieldSample2() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        //leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon", modifier = Modifier.size(35.dp)) },
        onValueChange = { text = it },
        label = { Text("Name",color = Color.Black) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 10.dp, end = 14.dp),
        colors=TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = Color.Black,
            textColor = Color.Black,
        ),
        shape = RoundedCornerShape(10.dp)
        //color=Color.White
        //modifier = Modifier.align(Alignment.TopCenter)
    )
}
@Composable
fun SimpleFilledTextFieldSample3() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        //leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon", modifier = Modifier.size(35.dp)) },
        onValueChange = { text = it },
        label = { Text("Tel Number",color = Color.Black) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 10.dp, end = 14.dp),
        colors=TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = Color.Black,
            textColor = Color.Black,
        ),
        shape = RoundedCornerShape(10.dp)
        //color=Color.White
        //modifier = Modifier.align(Alignment.TopCenter)
    )
}
@Composable
fun SimpleFilledTextFieldSample4() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        //leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon", modifier = Modifier.size(35.dp)) },
        onValueChange = { text = it },
        label = { Text("Location",color = Color.Black) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 10.dp, end = 14.dp),
        colors=TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = Color.Black,
            textColor = Color.Black,
        ),
        shape = RoundedCornerShape(10.dp)
        //color=Color.White
        //modifier = Modifier.align(Alignment.TopCenter)
    )
}
@Composable
fun SimpleFilledTextFieldSample5() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text,
        //leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "searchIcon", modifier = Modifier.size(35.dp)) },
        onValueChange = { text = it },
        label = { Text("Product",color = Color.Black) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, top = 10.dp, end = 14.dp),
        colors=TextFieldDefaults.textFieldColors(
            backgroundColor = Color.White,
            leadingIconColor = Color.Black,
            textColor = Color.Black,
        ),
        shape = RoundedCornerShape(10.dp)
        //color=Color.White
        //modifier = Modifier.align(Alignment.TopCenter)
    )
}