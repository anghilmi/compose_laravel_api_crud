package com.example.apicompose_put

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.apicompose_put.ui.theme.Apicompose_putTheme
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Apicompose_putTheme {
                // A surface container using the 'background' color from the theme
                // in the below line, we are specifying background color for our application
                Surface(
                    // in the below line, we are specifying modifier and color for our app
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    //in the below line, we are specifying theme as scaffold.
                    Scaffold(

                        // in scaffold we are specifying top bar.
                        topBar = {

                            // inside top bar we are specifying background color.
                            val greenColor = Color(0xFF0F9D58)
                            TopAppBar(backgroundColor = greenColor,

                                // along with that we are specifying title for our top bar.
                                title = {

                                    // in the top bar we are specifying tile as a text
                                    Text(

                                        // in the below line, we are specifying text to display in top app bar.
                                        text = "Retrofit CRUD Request in Android",

                                        // in the below line, we are specifying modifier to fill max width.
                                        modifier = Modifier.fillMaxWidth(),

                                        // in the below line, we are specifying text alignment.
                                        textAlign = TextAlign.Center,

                                        // in the below line, we are specifying color for our text.
                                        color = Color.White
                                    )
                                })
                        }) {
                        // in the below line, we are calling pop window dialog method to display ui.
                        crudData()
                    }
                }
            }
        }
    }
}

@Composable
fun crudData() {
    val ctx = LocalContext.current

    val idProduk = remember {
        mutableStateOf(TextFieldValue())
    }
    val namaProduk = remember {
        mutableStateOf(TextFieldValue())
    }
    val deskripsiProduk = remember {
        mutableStateOf(TextFieldValue())
    }
    val hargaProduk = remember {
        mutableStateOf(TextFieldValue())
    }
    val urlProduk = remember {
        mutableStateOf(TextFieldValue())
    }
    val response = remember {
        mutableStateOf("")
    }

    // in the below line, we are creating a column.
    Column(
        // in the below line, we are adding a modifier to it
        // and setting max size, max height and max width
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),

        // in the below line, we are adding vertical
        // arrangement and horizontal alignment.
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        //in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a text field for our email.
        TextField(
            // in the below line, we are specifying value for our email text field.
            value = idProduk.value,

            // in the below line, we are adding on value change for text field.
            onValueChange = { idProduk.value = it },

            // in the below line, we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter id prod") },

            // in the below line, we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // in the below line, we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // in the below line, we ar adding single line to it.
            singleLine = true,

            )

        //in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a text field for our email.
        TextField(
            // in the below line, we are specifying value for our email text field.
            value = namaProduk.value,

            // in the below line, we are adding on value change for text field.
            onValueChange = { namaProduk.value = it },

            // in the below line, we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter nama prod") },

            // in the below line, we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // in the below line, we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // in the below line, we ar adding single line to it.
            singleLine = true,

            )

        // in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a text field for our email.
        TextField(
            // in the below line, we are specifying value for our email text field.
            value = deskripsiProduk.value,

            // in the below line, we are adding on value change for text field.
            onValueChange = { deskripsiProduk.value = it },

            // in the below line, we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter deskripsi prod") },

            // in the below line, we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // in the below line, we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // in the below line, we are adding single line to it.
            singleLine = true,
        )
        //in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a text field for our email.
        TextField(
            // in the below line, we are specifying value for our email text field.
            value = hargaProduk.value,

            // in the below line, we are adding on value change for text field.
            onValueChange = { hargaProduk.value = it },

            // in the below line, we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter harga prod") },

            // in the below line, we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // in the below line, we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // in the below line, we ar adding single line to it.
            singleLine = true,

            )

        //in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a text field for our email.
        TextField(
            // in the below line, we are specifying value for our email text field.
            value = urlProduk.value,

            // in the below line, we are adding on value change for text field.
            onValueChange = { urlProduk.value = it },

            // in the below line, we are adding place holder as text as "Enter your email"
            placeholder = { Text(text = "Enter url prod") },

            // in the below line, we are adding modifier to it
            // and adding padding to it and filling max width
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            // in the below line, we are adding text style
            // specifying color and font size to it.
            textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
            // in the below line, we ar adding single line to it.
            singleLine = true,

            )

        // in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a button
        Button(
            onClick = {

                // in the below line, we are calling make payment method to update data.
                updateDataUsingRetrofit(
                    ctx, idProduk, namaProduk, deskripsiProduk, hargaProduk, urlProduk, response
                )
            },
            // in the below line, we are adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // in the below line, we are adding text for our button
            Text(text = "Update Data", modifier = Modifier.padding(8.dp))
        }

        // in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a button
        Button(
            onClick = {

                // in the below line, we are calling make payment method to update data.
                postDataUsingRetrofit(
                    ctx, idProduk, namaProduk, deskripsiProduk, hargaProduk, urlProduk, response
                )
            },
            // in the below line, we are adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // in the below line, we are adding text for our button
            Text(text = "Post Data", modifier = Modifier.padding(8.dp))
        }

        // in the below line, we are adding spacer
        Spacer(modifier = Modifier.height(5.dp))

        // in the below line, we are creating a button
        Button(
            onClick = {

                // in the below line, we are calling make payment method to update data.
                deleteDataUsingRetrofit(
                    ctx, idProduk, response
                )
            },
            // in the below line, we are adding modifier to our button.
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // in the below line, we are adding text for our button
            Text(text = "Delete Data", modifier = Modifier.padding(8.dp))
        }

        // in the below line, we are adding a spacer.
        Spacer(modifier = Modifier.height(10.dp))

        // in the below line, we are creating a text for displaying a response.
        Text(
            text = response.value,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold, modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

private fun updateDataUsingRetrofit(
    ctx: Context,
    idProduk: MutableState<TextFieldValue>,
    namaProduk: MutableState<TextFieldValue>,
    deskripsiProduk: MutableState<TextFieldValue>,
    hargaProduk: MutableState<TextFieldValue>,
    urlProduk: MutableState<TextFieldValue>,
    result: MutableState<String>
) {

    var url = "http://your_ip:8000/api/"

    // in the below line, we are creating a retrofit
    // builder and passing our base url
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()

    // the below line is creating an instance for our retrofit api class.
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

    // passing data from our text fields to our model class.
    val dataModel = DataModel(idProduk.value.text, namaProduk.value.text, deskripsiProduk.value.text, hargaProduk.value.text, urlProduk.value.text)

    // calling a method to create an update and passing our model class.
    val call: Call<DataModel?>? = retrofitAPI.updateData(idProduk.value.text, dataModel)

    // in the below line, we are executing our method.
    call!!.enqueue(object : Callback<DataModel?> {
        override fun onResponse(call: Call<DataModel?>?, response: Response<DataModel?>) {
            // this method is called when we get response from our api.
            Toast.makeText(ctx, "Data updated to API", Toast.LENGTH_SHORT).show()

            // we are getting a response from our body and
            // passing it to our model class.
            val model: DataModel? = response.body()

            // in the below line, we are getting our data from model class
            // and adding it to our string.
            val resp =
                "Response Code : " + response.code() + "\n" + "Nama prod : " + model!!.nama_produk + "\n" + "Desk prod : " + model!!.deskripsi_produk

            // in the below line, we are setting our string to our response.
            result.value = resp
        }

        override fun onFailure(call: Call<DataModel?>?, t: Throwable) {

            // we get error response from API.
            result.value = "Error found is : " + t.message
        }
    })

}

private fun postDataUsingRetrofit(
    ctx: Context,
    idProduk: MutableState<TextFieldValue>,
    namaProduk: MutableState<TextFieldValue>,
    deskripsiProduk: MutableState<TextFieldValue>,
    hargaProduk: MutableState<TextFieldValue>,
    urlProduk: MutableState<TextFieldValue>,
    result: MutableState<String>
) {

    var url = "http://your_ip:8000/api/"

    // in the below line, we are creating a retrofit
    // builder and passing our base url
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()

    // the below line is creating an instance for our retrofit api class.
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

    // passing data from our text fields to our model class.
    val dataModel = DataModel(idProduk.value.text, namaProduk.value.text, deskripsiProduk.value.text, hargaProduk.value.text, urlProduk.value.text)

    // calling a method to create an update and passing our model class.
    val call: Call<DataModel?>? = retrofitAPI.postData(dataModel)

    // in the below line, we are executing our method.
    call!!.enqueue(object : Callback<DataModel?> {
        override fun onResponse(call: Call<DataModel?>?, response: Response<DataModel?>) {
            // this method is called when we get response from our api.
            Toast.makeText(ctx, "Data posted to API", Toast.LENGTH_SHORT).show()

            // we are getting a response from our body and
            // passing it to our model class.
            val model: DataModel? = response.body()

            // in the below line, we are getting our data from model class
            // and adding it to our string.
            val resp =
                "Response Code : " + response.code() + "\n" + "Nama prod : " + model!!.nama_produk + "\n" + "Desk prod : " + model!!.deskripsi_produk

            // in the below line, we are setting our string to our response.
            result.value = resp
        }

        override fun onFailure(call: Call<DataModel?>?, t: Throwable) {

            // we get error response from API.
            result.value = "Error found is : " + t.message
        }
    })

}

private fun deleteDataUsingRetrofit(
    ctx: Context,
    idProduk: MutableState<TextFieldValue>,

    result: MutableState<String>
) {

    var url = "http://your_ip:8000/api/"

    // in the below line, we are creating a retrofit
    // builder and passing our base url
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        // as we are sending data in json format so
        // we have to add Gson converter factory
        .addConverterFactory(GsonConverterFactory.create())
        // at last we are building our retrofit builder.
        .build()

    // the below line is creating an instance for our retrofit api class.
    val retrofitAPI = retrofit.create(RetrofitAPI::class.java)

    // passing data from our text fields to our model class.
    //val dataModel = DataModel(idProduk.value.text)

    // calling a method to create an update and passing our model class.
    val call: Call<DataModel?>? = retrofitAPI.deleteData(idProduk.value.text)

    // in the below line, we are executing our method.
    call!!.enqueue(object : Callback<DataModel?> {
        override fun onResponse(call: Call<DataModel?>?, response: Response<DataModel?>) {
            // this method is called when we get response from our api.
            Toast.makeText(ctx, "Data deleted to API", Toast.LENGTH_SHORT).show()

            // we are getting a response from our body and
            // passing it to our model class.
            val model: DataModel? = response.body()

            // in the below line, we are getting our data from model class
            // and adding it to our string.
            val resp =
                "Response Code : " + response.code() + "\n"

            // in the below line, we are setting our string to our response.
            result.value = resp
        }

        override fun onFailure(call: Call<DataModel?>?, t: Throwable) {

            // we get error response from API.
            result.value = "Error found is : " + t.message
        }
    })

}