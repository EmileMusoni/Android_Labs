package com.example.mangrove.compose

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mangrove.DBHandler
import com.example.mangrove.R
import com.example.mangrove.ui.theme.Purple200
import com.example.mangrove.ui.theme.logo1


@Composable
fun RegisterProject( context: Context)
{
    var username by remember { mutableStateOf("") }
    var username1 by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var crop by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confpassword by rememberSaveable { mutableStateOf("") }
    Scaffold() {
    }

    var dbHandler: DBHandler = DBHandler(context)
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = stringResource(id = R.string.man),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
            Text(text = stringResource(id = R.string.grove),
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onSecondary,
                textAlign = TextAlign.Center,
                fontSize = 35.sp)
        }

        Spacer(modifier = Modifier.height(7.dp))
      /*  Text(text = stringResource(id = R.string.username),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, top = 30.dp)
        )*/
        NameTextField(name = username1, changed = {username1=it})

       /* Text(text = stringResource(id = R.string.phone),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )*/
        PhoneTextField(phone = phone, changed = {phone=it})

       /* Text(text = stringResource(id = R.string.location),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )*/
        LocationTextField(location = location, changed = {location=it})

/*Text(text = stringResource(id = R.string.crop),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )
        CropTextField(crop = crop, changed = {crop=it})*/




       /* Text(text = stringResource(id = R.string.Email),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp)
        )*/
        EmailTextField1(username = username, changed = { username = it })
       /* Text(text = stringResource(id = R.string.Password),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, bottom= 10.dp, end = 20.dp)
        )*/
        PasswordTextField1(password = password, changed = { password = it })
      /*  Text(text = stringResource(id = R.string.confpassword),
            color= Color.Gray,
            modifier = Modifier
                .padding(start = 60.dp, bottom= 10.dp, end = 20.dp)
        )*/
        ConfPassTextField(confpassword = confpassword,changed = { confpassword = it })

     /*  Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondaryVariant,
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(start = 60.dp)
        ) {
            Text(text = stringResource(id = R.string.registerbutton),
                textAlign = TextAlign.Center, color = Color.Black
            )
        }*/
        Button(onClick = {

            dbHandler.addNewFarmer(
                username1,
                phone,
                location,
                username,
                password,
                confpassword
            )


            Toast.makeText(context, "Farmer Added", Toast.LENGTH_SHORT).show()


        },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondaryVariant,
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(start = 60.dp)) {
            // on below line adding a text for our button.

            Text(text = stringResource(id = R.string.registerbutton),
                textAlign = TextAlign.Center, color = Color.Black)
        }


    }

}
@Composable
fun NameTextField(name: String, changed: (String) -> Unit ) {
    TextField(
        value = name,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.entername)) },
//        visualTransformation = PasswordVisualTransformation(),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}
@Composable
fun PhoneTextField(phone: String, changed: (String) -> Unit ) {
    TextField(
        value = phone,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterphone)) },
//        visualTransformation = PasswordVisualTransformation(),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}
@Composable
fun LocationTextField(location: String, changed: (String) -> Unit ) {
    TextField(
        value = location,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterlocation)) },
        //visualTransformation = PasswordVisualTransformation(),
//        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}
/*@Composable
fun CropTextField(crop: String, changed: (String) -> Unit ) {
    TextField(
        value = crop,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.entercrop)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}*/


@Composable
fun EmailTextField1 (username:String, changed: (String) -> Unit){
    TextField (
        value = username,
        onValueChange = changed,
        label = { Text(text = stringResource(id = R.string.enteremail)) },

        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
        shape = RoundedCornerShape(5.dp),

        )
}

//Save to DB

@Composable
fun addDataToDatabase(
    context: Context
) {
    val activity = context as Activity

    // on below line we are creating a column,
    val FarmerName = remember {
        mutableStateOf(TextFieldValue())
    }
    val FarmerPhone = remember {
        mutableStateOf(TextFieldValue())
    }
    val FarmerLocation = remember {
        mutableStateOf(TextFieldValue())
    }
    val FarmerEmail = remember {
        mutableStateOf(TextFieldValue())
    }
    val FarmerPassword = remember {
        mutableStateOf(TextFieldValue())
    }
    val ConfirmPassword = remember {
        mutableStateOf(TextFieldValue())
    }
    Column(
        // on below line we are adding a modifier to it,
        modifier = Modifier.fillMaxSize()
            // on below line we are adding a padding.
            .padding(all = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        var dbHandler: DBHandler = DBHandler(context)
        // on below line we are adding a text for heading.
        Text(
            // on below line we are specifying text
            text = "Farmer Registration Form",
            // on below line we are specifying text color, font size and font weight
            color = Purple200, fontSize = 20.sp, fontWeight = FontWeight.Bold
            // on below line adding a spacer.
        )
        Spacer(modifier = Modifier.height(20.dp))
        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = FarmerName.value,
            // on below line we are adding on value change for text field.
            onValueChange = { FarmerName.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your name") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp),
            shape = RoundedCornerShape(15.dp),

            // on below line we are adding text style
            // specifying color and font size to it.

            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))
        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = FarmerPhone.value,
            // on below line we are adding on value change for text field.
            onValueChange = { FarmerPhone.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter Phone Number") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp),
            shape = RoundedCornerShape(15.dp),

            // on below line we are adding text style
            // specifying color and font size to it.

            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = FarmerLocation.value,
            // on below line we are adding on value change for text field.
            onValueChange = { FarmerLocation.value = it },
            // on below line we are adding place holder as text
            placeholder = { Text(text = "Enter Location") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp),
            shape = RoundedCornerShape(15.dp),

            // on below line we are adding text style
            // specifying color and font size to it.

            // on below line we are adding single line to it.
            singleLine = true,
        )
        // on below line we are adding spacer
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = FarmerEmail.value,
            // on below line we are adding on value change for text field.
            onValueChange = { FarmerEmail.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter your Email") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp),
            shape = RoundedCornerShape(15.dp),

            // on below line we are adding text style
            // specifying color and font size to it.

            // on below line we are adding single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = FarmerPassword.value,
            // on below line we are adding on value change for text field.
            onValueChange = { FarmerPassword.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter Password") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp),
            shape = RoundedCornerShape(15.dp),

            // on below line we are adding text style
            // specifying color and font size to it.

            // on below line we are adding single line to it.
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text field.
        TextField(
            // on below line we are specifying value for our email text field.
            value = ConfirmPassword.value,
            // on below line we are adding on value change for text field.
            onValueChange = { ConfirmPassword.value = it },
            // on below line we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter Email Confirmation") },
            // on below line we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp),
            shape = RoundedCornerShape(15.dp),

            // on below line we are adding text style
            // specifying color and font size to it.

            // on below line we are adding single line to it.
            singleLine = true,


            )

        // on below line we are adding spacer
      Spacer(modifier = Modifier.height(15.dp))
// on below line creating a button to check battery charging status
        Button(onClick = {

            dbHandler.addNewFarmer(
                FarmerName.value.text,
                FarmerPhone.value.text,
                FarmerLocation.value.text,
                FarmerEmail.value.text,
                FarmerPassword.value.text,
                ConfirmPassword.value.text
            )
            // val tes = dbHandler.checkUser(FarmerEmail.value.text, FarmerPassword.value.text)
            // dbHandler.addNewFarmer(FarmerName.value.text,FarmerPhone.value.text,FarmerLocation.value.text,FarmerEmail.value.text,FarmerPassword.value.text,ConfirmPassword.value.text);
            //if (tes.equals(1))
            // {

            //   Toast.makeText(context, "Login", Toast.LENGTH_SHORT).show()
            //}
            //  else
            // {
            Toast.makeText(context, "Farmer Added", Toast.LENGTH_SHORT).show()

            // }
        }) {
            // on below line adding a text for our button.

            Text(text = "Add New Farmer", color = Color.White)
        }
    }
}

// End Register
//End save 2 DB

@Composable
fun PasswordTextField1(password: String, changed: (String) -> Unit ) {
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
fun ConfPassTextField(confpassword: String, changed: (String) -> Unit ) {
    TextField(
        value =confpassword,
        onValueChange = changed,
        label = { Text (text = stringResource(id = R.string.enterConfpass)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .padding(start = 60.dp, bottom = 10.dp, end = 20.dp),
    )
}

@Composable
fun RegisterButton(clicked: () -> Unit){
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.secondaryVariant,
            contentColor = Color.White
        ),
        modifier = Modifier
            .padding(start = 60.dp, top = 50.dp)

    ) {
        Text(text = stringResource(id = R.string.registerbutton),
            textAlign = TextAlign.Center, color = Color.Black
        )
    }
}