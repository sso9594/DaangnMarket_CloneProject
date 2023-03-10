package com.example.carrot.ui.home.post.create

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrot.ui.component.*
import com.example.carrot.ui.component.modifier.drawColoredShadow
import com.example.carrot.ui.theme.Carrot
import com.example.carrot.ui.theme.Grey210
import com.example.carrot.ui.theme.Grey220
import com.example.carrot.ui.theme.Grey240
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class)
@Composable
fun PostCreateScreenTopAppBar(
    postCreateViewModel: PostCreateViewModel,
    onCancel: () -> Unit,
    toggleMainBottomBar: () -> Unit
){
    TopAppBar(
        modifier = Modifier
            .drawColoredShadow(offsetX = 2.dp),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CancelIconBtn(
                    color = Color.Black,
                    onCancel = onCancel,
                    toggleMainBottomBar = toggleMainBottomBar
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "??? ?????? ??????", fontWeight = FontWeight.Black, fontSize = 18.sp)
            }
        }
        ,
        actions = {
            val context = LocalContext.current
            TextButton(
                onClick = {
                    GlobalScope.launch {
                        postCreateViewModel.createSalePost(context)
                    }
                    onCancel()
                    toggleMainBottomBar()
                },
                enabled = with(postCreateViewModel){
                    title.value != "" && contents.value != "" && price.value != ""
                },
                colors = ButtonDefaults.textButtonColors(
                    disabledContentColor = Grey210,
                    contentColor = Carrot
                )
            ) {
                Text(
                    text = "??????"
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White
        )
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostCreateScreen(
    postCreateViewModel: PostCreateViewModel = PostCreateViewModel(),
    onCancel: () -> Unit,
    toggleMainBottomBar: () -> Unit
) {
    LaunchedEffect(Unit){
        toggleMainBottomBar()
    }
    Scaffold(
        topBar = {
            PostCreateScreenTopAppBar(
                postCreateViewModel = postCreateViewModel,
                onCancel = onCancel,
                toggleMainBottomBar = toggleMainBottomBar
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(top = 60.dp, bottom = 70.dp, start = 16.dp, end = 16.dp)
            ) {
                PostCreateScreenContent(postCreateViewModel)
            }
        }
    )
}

@Composable
fun PostCreateScreenContent(postCreateViewModel: PostCreateViewModel){
    Spacer(modifier = Modifier.height(20.dp))
    AddImage(postCreateViewModel)
    Spacer(modifier = Modifier.height(20.dp))
    Divider(
        modifier = Modifier
            .fillMaxWidth(),
        color = Grey240
    )
    AddPostTitle(
        postCreateViewModel.title.value,
        postCreateViewModel.setTitle
    )
    Divider(
        modifier = Modifier
            .fillMaxWidth(),
        color = Grey240
    )
    AddPostPrice(
        postCreateViewModel.price.value,
        postCreateViewModel.setPrice
    )
    Divider(
        modifier = Modifier
            .fillMaxWidth(),
        color = Grey240
    )
    AddPostContent(
        postCreateViewModel.contents.value,
        postCreateViewModel.setContents
    )
    Divider(
        modifier = Modifier
            .fillMaxWidth(),
        color = Grey240
    )
    Spacer(modifier = Modifier.height(20.dp))
    SelectTradeLocation()
}

@Composable
fun AddImage(
    postCreateViewModel: PostCreateViewModel
){
    val context = LocalContext.current

    val pickMedia = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()) { uri ->
            GlobalScope.launch {
                postCreateViewModel.uploadImage(uri!!, context)
                Log.i("PHOTOPICKER", "uri : $uri")
            }
        }

    Button(
        onClick = {
            pickMedia.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        },
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 14.dp),
        shape = MaterialTheme.shapes.extraSmall,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Unspecified
        ),
        border = BorderStroke(1.dp, Grey220),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.PhotoCamera,
                contentDescription = "Add post Image",
                tint = Color.Black
            )
            Text(text = "0/10", color = Grey210)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPostTitle(
    title: String,
    setTitle:(String) -> Unit
){
    OutlinedTextField(
        value = title,
        onValueChange = {
            setTitle(it)
        },
        placeholder = { Text(text = "??? ??????")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            unfocusedBorderColor = Color.White,
            disabledBorderColor = Color.White,
            focusedBorderColor = Color.White,
            errorBorderColor = Color.White,
            placeholderColor = Grey210
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPostPrice(
    price: String,
    setPrice: (String) -> Unit
){
    OutlinedTextField(
        value = price,
        onValueChange = {
            setPrice(it)
        },
        placeholder = { Text(text = "?????? (????????????)")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            unfocusedBorderColor = Color.White,
            disabledBorderColor = Color.White,
            focusedBorderColor = Color.White,
            errorBorderColor = Color.White,
            placeholderColor = Grey210
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Decimal
        ),
        modifier = Modifier
            .fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPostContent(
    contents: String,
    setContents: (String) -> Unit
){
    OutlinedTextField(
        value = contents,
        onValueChange = {
            setContents(it)
        },
        placeholder = { Text(text = "???????????? ?????? ????????? ????????? ??????????????????. (?????? ?????? ????????? ????????? ????????? ??? ?????????)")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = Color.White,
            unfocusedBorderColor = Color.White,
            disabledBorderColor = Color.White,
            focusedBorderColor = Color.White,
            errorBorderColor = Color.White,
            placeholderColor = Grey210
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}

@Composable
fun SelectTradeLocation(){
    Text("?????? ?????? ??????")
}