package com.example.mangrove.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
//import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mangrove.DBHandler
import com.example.mangrove.FarmerModel
import com.example.mangrove.Model.ViewModelProduct
import com.example.mangrove.Model.product
import com.example.mangrove.R
import com.example.mangrove.ui.theme.MangroveTheme
import java.util.*

@Composable
fun ProductScreen() {
    val viewModel: ViewModelProduct = viewModel()
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        backgroundColor = MaterialTheme.colors.secondary,
        topBar = {
            TopAppBar(
                title = {
                    Text("Add your product", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Share, null)
                    }
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Settings, null)
                    }
                },
                backgroundColor = MaterialTheme.colors.onPrimary)
                 },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {showDialog = true},
                modifier = Modifier.padding(bottom = 50.dp),
                backgroundColor = MaterialTheme.colors.secondaryVariant
            )
            {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        },
        content = {
            if (showDialog){
                addProductDialog(context, dismissDialog = {showDialog = false}, {viewModel.add(it)})
            }
            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 8.dp
                )
            )
            {
                items(viewModel.productList, key={product -> product.id}) { product1 ->
                    ProductItem(item = product1, context, {viewModel.delete(it)})
                }
            }
        }
    )
}

@Composable
fun addProductDialog(context: Context, dismissDialog:() -> Unit, addProduct: (product) -> Unit){

    var ProductPhoneField by remember {
        mutableStateOf("")
    }
    var ProductTextField by remember {
        mutableStateOf("")
    }
    var KgTextField by remember {
        mutableStateOf("")
    }
    var NumberOfSacks by remember {
        mutableStateOf("")
    }
    var dbHandler: DBHandler = DBHandler(context)
    AlertDialog(

        onDismissRequest = { dismissDialog},
        title={ Text(text = stringResource(id = R.string.addproduct), style = MaterialTheme.typography.h6) },
        text = {
            Column(modifier = Modifier.padding(top=20.dp)) {
                TextField(label = { Text(text= "Phone Number") }, value = ProductPhoneField, onValueChange = { ProductPhoneField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = { Text(text= "ProductName") }, value = ProductTextField, onValueChange = {ProductTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = { Text(text= "Kilograms per Sack") }, value = KgTextField, onValueChange = {KgTextField=it})
                Spacer(modifier = Modifier.height(10.dp))
                TextField(label = { Text(text= "Number Of Sack") }, value = NumberOfSacks, onValueChange = {NumberOfSacks=it})
            }
        },


    confirmButton = {
        Button(onClick = {

            dbHandler.addNewpRODYCT(
                ProductPhoneField,
                ProductTextField,
                KgTextField,
                NumberOfSacks

            )


            Toast.makeText(context, "Product Added", Toast.LENGTH_SHORT).show()


        }) {
            // on below line adding a text for our button.

            Text(text = "Add New Product", color = Color.White)
        }
        /*Button(onClick = {
             if(ProductTextField.isNotEmpty() && KgTextField.isNotEmpty()) {
                 val newID = UUID.randomUUID().toString();
                 addProduct(product(newID, ProductTextField,KgTextField,NumberOfSacks))
                 Toast.makeText(
                     context,
                     context.resources.getString(R.string.addedproduct),
                     Toast.LENGTH_SHORT
                 ).show()
             }
             dismissDialog()
         })
         {
             Text(text = stringResource(id = R.string.add))
         }*/
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}

@Composable
fun deleteProductDialog(context: Context, dismissDialog:() -> Unit, item:product, deleteBook: (product) -> Unit){
    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={ Text(text = stringResource(id = R.string.delete), style = MaterialTheme.typography.h6) },
        confirmButton = {
            Button(onClick = {
                deleteBook(item)
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.deleteproduct),
                    Toast.LENGTH_SHORT
                ).show()
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.yes))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.no))
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductItem(item: product, context: Context, deleteProduct: (product) -> Unit) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    Card(
        elevation = 6.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colors.onPrimary,
        border = BorderStroke(2.dp, color = MaterialTheme.colors.secondary),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(
                            context,
                            context.resources.getString(R.string.readmsg) + " " + item.prod,
                            Toast.LENGTH_SHORT
                        )
                        .show()
                },
                onLongClick = { showDeleteDialog = true }
            )
    ) {
        Row()
        {

            Column(modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .padding(start = 10.dp)) {
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_production_quantity_limits_24),
                        contentDescription ="Chevron",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(width = 30.dp, 30.dp))
                    Text(text = item.prod, style = MaterialTheme.typography.h6, color = Color.Black,modifier = Modifier.padding(start = 10.dp))
                }
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_line_weight_24),
                        contentDescription ="Chevron",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(width = 30.dp, 30.dp))

                    Text(text = item.kgPerSack+" "+"Kg", style = MaterialTheme.typography.h6, color = Color.Black,modifier = Modifier.padding(start = 10.dp))

                }
                Row() {
                    Icon(
                        painter = painterResource(R.drawable.ic_baseline_shopping_bag_24),
                        contentDescription ="Chevron",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(width = 30.dp, 30.dp))
                    Text(text = item.sacks+" "+"Bags", style = MaterialTheme.typography.h6, color = Color.Black, modifier = Modifier.padding(start = 10.dp))

                }
                //Spacer(modifier = Modifier.width(150.dp))
            }
            //Spacer(modifier = Modifier.width(10.dp))
        }
    }
    if (showDeleteDialog){
        deleteProductDialog(context, dismissDialog = {showDeleteDialog = false}, item, deleteProduct)
    }
}


//Feach Product from database
/*
@Composable
fun readProductsFromDatabase(context: Context) {
    // on below line we are creating and initializing our array list
    lateinit var productList: List<ProductModel>
    productList = ArrayList<ProductModel>()

    val dbHandler: DBHandler = DBHandler(context);
    //username by remember { mutableStateOf("") }
    //    var password

    productList = dbHandler.readFarmers()!!

    // on below line we are creating a lazy column for displaying a list view.
    LazyColumn {

        //var saveuser=""
        //var savepass=""
        itemsIndexed(productList) { index, item ->
            if(productList[index].FarmerEmail==saveuser && productList[index].FarmerPassword==savepass)
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
}*/
//End Feach Product from database

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MangroveTheme {
        ProductScreen()
    }
}