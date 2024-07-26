@file:Suppress("NAME_SHADOWING")

package net.ezra.ui.students

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.ezra.R
import net.ezra.navigation.ROUTE_ABOUT_US
import net.ezra.navigation.ROUTE_ADD_PRODUCT
import net.ezra.navigation.ROUTE_DASHBOARD
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_SEARCH

/*
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

import coil.request.ImageRequest
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import net.ezra.R
import net.ezra.navigation.ROUTE_ADD_STUDENTS
import net.ezra.navigation.ROUTE_HOME
import java.util.UUID



var progressDialog: ProgressDialog? = null
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddStudents(navController: NavHostController) {
    val context = LocalContext.current


    Scaffold(

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.add_stud))
                },
                navigationIcon = {
                    IconButton(onClick = {


                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_ADD_STUDENTS) { inclusive = true }
                        }


                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon", tint = Color.White)
                    }
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff0FB06A),
                    titleContentColor = Color.White,

                    )
            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff9AEDC9)),
                verticalArrangement = Arrangement.Center,
            ) {
                LazyColumn {
                    item {
                        Column(







                            horizontalAlignment = Alignment.CenterHorizontally
                        ){

                            Card (


                            ){

                            }

                            Spacer(modifier = Modifier.height(10.dp))


                            var photoUri: Uri? by remember { mutableStateOf(null) }
                            val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                                photoUri = uri
                            }

                            var studentName by rememberSaveable {
                                mutableStateOf("")
                            }

                            var studentClass by rememberSaveable {
                                mutableStateOf("")
                            }

                            var studentEmail by rememberSaveable {
                                mutableStateOf("")
                            }

                            var location by rememberSaveable {
                                mutableStateOf("")
                            }

                            var phone by rememberSaveable {
                                mutableStateOf("")
                            }



                            OutlinedTextField(
                                value = studentName,
                                onValueChange = { studentName = it },
                                label = { Text(text = "Name") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = phone,
                                onValueChange = { phone = it },
                                label = { Text(text = "Phone") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = location,
                                onValueChange = { location = it },
                                label = { Text(text = "Location") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = studentEmail,
                                onValueChange = { studentEmail = it },
                                label = { Text(text = "Email") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )

                            OutlinedTextField(
                                value = studentClass,
                                onValueChange = { studentClass= it },
                                label = { Text(text = "Class") },
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                            )





                            if (photoUri != null) {
                                //Use Coil to display the selected image
                                val painter = rememberAsyncImagePainter(
                                    ImageRequest
                                        .Builder(LocalContext.current)
                                        .data(data = photoUri)
                                        .build()
                                )

                                Image(
                                    painter = painter,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(5.dp)
                                        .width(150.dp)
                                        .height(150.dp)
                                        .border(1.dp, Color.Gray),
                                    contentScale = ContentScale.Crop,

                                    )
                            } else {

                                OutlinedButton(
                                    onClick = {
                                        launcher.launch(
                                            PickVisualMediaRequest(
                                                //Here we request only photos. Change this to .ImageAndVideo if you want videos too.
                                                //Or use .VideoOnly if you only want videos.
                                                mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                            )
                                        )
                                    }
                                ) {
                                    Text(text = stringResource(id = R.string.select_image))
                                }
                            }


                            OutlinedButton(onClick = {

                                if (photoUri != null) {

                                    progressDialog = ProgressDialog(context)
                                    progressDialog?.setMessage("Uploading data...")
                                    progressDialog?.setCancelable(false)
                                    progressDialog?.show()

                                    photoUri?.let {

                                        uploadImageToFirebaseStorage(
                                            it,
                                            studentName,
                                            studentClass,
                                            studentEmail,
                                            location,
                                            phone,
                                            context

                                        )

                                        studentName = ""
                                        studentClass = ""
                                        studentEmail = ""
                                        location = ""
                                        phone = ""
                                        photoUri = null

                                    }
                                } else if (studentClass == ""){

                                    Toast.makeText(context, "Please enter class", Toast.LENGTH_SHORT).show()
                                }
                                else if (studentEmail == ""){
                                    Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
                                }
                                else if(studentName == ""){
                                    Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show()
                                }

                                else {
                                    Toast.makeText(context, "Please select an image", Toast.LENGTH_SHORT).show()
                                }



                            }) {

                                Text(text = stringResource(id = R.string.save_data))


                            }











                        }
                    }
                }
            }

        })



}



fun uploadImageToFirebaseStorage(
    imageUri: Uri,
    studentName: String,
    studentClass: String,
    studentEmail: String,
    location: String,
    phone: String,
    context: Context

) {
    val storageRef = FirebaseStorage.getInstance().reference
    val imageRef = storageRef.child("images/${UUID.randomUUID()}")

    val uploadTask = imageRef.putFile(imageUri)
    uploadTask.continueWithTask { task ->
        if (!task.isSuccessful) {
            task.exception?.let {
                throw it
            }
        }
        imageRef.downloadUrl
    }.addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val downloadUri = task.result
            saveToFirestore(
                downloadUri.toString(),
                studentName,
                studentClass,
                studentEmail,
                location,
                phone,
                context,


            )

        } else {

            progressDialog?.dismiss()

            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to upload image: ${task.exception?.message}")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked


                }
                .show()


        }
    }
}


fun saveToFirestore(
    imageUrl: String,
    studentName: String,
    studentClass: String,
    studentEmail: String,
    location: String,
    phone: String,
    context: Context,



) {


    val db = Firebase.firestore
    val imageInfo = hashMapOf(
        "imageUrl" to imageUrl,
        "studentName" to studentName,
        "studentClass" to studentClass,
        "studentEmail" to studentEmail,
        "location" to location,
        "phone" to phone



    )


    db.collection("Students")
        .add(imageInfo)
        .addOnSuccessListener { documentReference ->

            progressDialog?.dismiss()

            // Show success dialog
            val dialogBuilder = AlertDialog.Builder(context)
            dialogBuilder.setTitle("Success")
                .setMessage("Data saved successfully!")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked
                }
                .setIcon(R.drawable.logo)
                .setCancelable(false)

            val alertDialog = dialogBuilder.create()
            alertDialog.show()

            // Customize the dialog style (optional)
            val alertDialogStyle = alertDialog.window?.attributes
            alertDialog.window?.attributes = alertDialogStyle
        }
        .addOnFailureListener {

            progressDialog?.dismiss()


            AlertDialog.Builder(context)
                .setTitle("Error")
                .setMessage("Failed to save data")
                .setPositiveButton("OK") { _, _ ->
                    // Optional: Add actions when OK is clicked



                }
                .show()


        }
}






@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    AddStudents(rememberNavController())
}
*/
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun AddStudents(navController: NavHostController){
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    androidx.compose.material3.Text(text = "ARTICLES")
                },
                navigationIcon = {
                    androidx.compose.material3.IconButton(onClick = {
                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_SEARCH) { inclusive = true }
                        }
                    }) {
                        androidx.compose.material3.Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            "backIcon",
                            tint = Color.White
                        )
                    }

                },
                actions = {
                    androidx.compose.material3.IconButton(onClick = {
                        navController.navigate(ROUTE_ADD_PRODUCT) {
                            popUpTo(ROUTE_DASHBOARD) { inclusive = true }
                        }

                    }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff0505562),
                    titleContentColor = Color.White,

                    )

            )
        },

        content = @Composable {
LazyColumn {
    item {
        Column {
            Card(
                modifier = Modifier

                ,
                onClick = {
                    navController.navigate(ROUTE_ABOUT_US)
                },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.parkie2), // Jesus is my anchor
                    contentDescription = "acquaint",
                    modifier = Modifier
                )
                  }
            Text(style = androidx.compose.material.MaterialTheme.typography.h6,
                text = "Do you have your hiking boots?..Don't miss out on an interactive opportunity to keep fit and to take in the beauty of nature.")


            Spacer(modifier = Modifier.height(40.dp))
            Card(
                modifier = Modifier

                ,
                onClick = {
                   // navController.navigate(ROUTE_ABOUT_US)
                },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.parkie3), // Jesus is my anchor
                    contentDescription = "acquaint",
                    modifier = Modifier
                )
                   }
            Text(style = androidx.compose.material.MaterialTheme.typography.h6,
                text = "Network as you get to broaden your knowledge.Have networth and wisdom ")

            Spacer(modifier = Modifier.height(40.dp))
            Card(
                modifier = Modifier

                ,
                onClick = {
                    //navController.navigate(ROUTE_ABOUT_US)
                },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.parklands), // Jesus is my anchor
                    contentDescription = "acquaint",
                    modifier = Modifier
                )
            }
            Text(style = androidx.compose.material.MaterialTheme.typography.h6,
                text = "DO you have the spirit of koinonia??....If you are wondering what that is the don't miss out on this Sunday services ")

            Spacer(modifier = Modifier.height(40.dp))
            Card(
                modifier = Modifier

                ,
                onClick = {
                    //navController.navigate(ROUTE_ABOUT_US)
                },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.parkie4), // Jesus is my anchor
                    contentDescription = "acquaint",
                    modifier = Modifier
                )
                    }
            Text(style = androidx.compose.material.MaterialTheme.typography.h6,
                text = "Come one come all to the campus community sports day...Let loose from all the academic pressure and have fun")
            Spacer(modifier = Modifier.height(40.dp))
            Card(
                modifier = Modifier

                ,
                onClick = {
                    // navController.navigate(ROUTE_ABOUT_US)
                },

                ) {
                Image(
                    painter = painterResource(id = R.drawable.parkie1), // Jesus is my anchor
                    contentDescription = "acquaint",
                    modifier = Modifier
                )
                 }
            Text(style = androidx.compose.material.MaterialTheme.typography.h6,
                text = "Join Parklands Baptist for bible study every friday ")

        }
    }
}


            },
        )

}




