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

            }
            else
            {
                Toast.makeText(context, "Invalid Login", Toast.LENGTH_SHORT).show()
            }


        }){
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
fun LoginButton(clicked: () -> Unit){
    Button(onClick = clicked,
        colors = ButtonDefaults.buttonColors(
            backgroundColor =MaterialTheme.colors.secondaryVariant,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(start = 60.dp, top = 50.dp)

    ) {
        Text(text = stringResource(id = R.string.loginbutton),
            textAlign = TextAlign.Center, color = Color.Black
        )
    }
}

@Composable
fun readFarmersFromDatabase(context: Context) {
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
                    modifier = Modifier.padding(8.dp).fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
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

                }
            }
        }
    }
    }
}