package com.example.mangrove.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangrove.DBHandler
import com.example.mangrove.FarmerModel
import com.example.mangrove.R

var saveuser=""
var savepass=""
@Composable
fun LoginProject(context: Context)
{
    var username by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Scaffold() {

    }
    var dbHandler: DBHandler = DBHandler(context)
    Column() {


        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
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
        Spacer(modifier = Modifier.height(7.dp))
        Text(text = stringResource(id = R.string.Email),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, top = 80.dp)
        )
        EmailTextField(username = username, changed = { username = it })
        Text(text = stringResource(id = R.string.Password),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, bottom= 10.dp, end = 20.dp)
        )
        PasswordTextField(password = password, changed = { password = it })
        //LoginButton (){}

        Button(onClick = {

           val checkuserLog= dbHandler.checkUser(

                username,
                password

            )
            if(checkuserLog)
            {
                saveuser=username
                savepass=password
                Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                //readFarmersFromDatabase(context: Context)
               // ProfileScreen(profile)//

            }
            else
            {
                Toast.makeText(context, "Invalid Login", Toast.LENGTH_SHORT).show()
            }


        },colors = ButtonDefaults.buttonColors(
            backgroundColor =MaterialTheme.colors.secondaryVariant,
            contentColor = Color.White
        ),
            modifier = Modifier
                .padding(start = 60.dp, top = 50.dp)
        ){
            // on below line adding a text for our button.

            Text(text = stringResource(id = R.string.loginbutton),
                textAlign = TextAlign.Center, color = Color.Black
            )
        }


    }

}

@Composable
fun EmailTextField (username:String, changed: (String) -> Unit){
    TextField (
        value = username,
        onValueChange = changed,
        label = { Text(text = stringResource(id = R.string.enteremail)) },

        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(5.dp),

        )
}


@Composable
fun PasswordTextField(password: String, changed: (String) -> Unit ) {
    TextField(
        value = password,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterpass)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}

@Composable

fun readFarmersFromDatabase(context: Context, addingProdPage:()->Unit) {
    // on below line we are creating and initializing our array list
    lateinit var farmerList: List<FarmerModel>
    farmerList = ArrayList<FarmerModel>()

    val dbHandler: DBHandler = DBHandler(context);
    //username by remember { mutableStateOf("") }
    //    var password

    farmerList = dbHandler.readFarmers()!!

    // on below line we are creating a lazy column for displaying a list view.
    LazyColumn {

        //var saveuser=""
        //var savepass=""
        itemsIndexed(farmerList) { index, item ->
            if(farmerList[index].FarmerEmail==saveuser && farmerList[index].FarmerPassword==savepass)
            {
                Card(

                    modifier = Modifier.padding(8.dp),

                    elevation = 6.dp
                ) {

                    Column(
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
                                    Text(text = farmerList[index].FarmerName,
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
                                    Text(text = farmerList[index].FarmerPhone,
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
                                    Text(text = farmerList[index].FarmerLocation,
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
                                    Text(text = "---",
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
                    }
                    /* Column(
                         modifier = Modifier.padding(8.dp).fillMaxWidth(),
                         horizontalAlignment = Alignment.Start,
                         verticalArrangement = Arrangement.Center
                     )


                     {
                         Text(
                             text = farmerList[index].FarmerName,

                             modifier = Modifier.padding(4.dp),

                             color = Color.Black, textAlign = TextAlign.Center
                         )

                         Spacer(modifier = Modifier.width(5.dp))

                         Text(

                             text = "Location : " + farmerList[index].FarmerLocation,

                             modifier = Modifier.padding(4.dp),

                             color = Color.Black, textAlign = TextAlign.Center
                         )

                         Spacer(modifier = Modifier.width(5.dp))

                         Text(


                             text = "Phone Number : " + farmerList[index].FarmerPhone,


                             modifier = Modifier.padding(4.dp),
                             color = Color.Black, textAlign = TextAlign.Center
                         )

                         Spacer(modifier = Modifier.width(5.dp))

                         Text(

                             text = "Email : " + farmerList[index].FarmerEmail,

                             // for our text from all sides.
                             modifier = Modifier.padding(4.dp),

                             // on below line we are adding color for our text
                             color = Color.Black, textAlign = TextAlign.Center
                         )

                     }*/
                }
            }
        }
    }
}