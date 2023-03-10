package com.example.carrot.ui.sign.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrot.AuthenticateViewModel
import com.example.carrot.ui.component.*
import com.example.carrot.ui.theme.*
import kotlinx.coroutines.*


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LogInScreen(
    navigateToHome: () -> Unit,
    navigateToFirstEntranceScreen: () -> Unit,
    authenticateViewModel: AuthenticateViewModel,
    loginScreenViewModel: LoginScreenViewModel = LoginScreenViewModel(),
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    BackIconBtn(
                        color = Black80,
                        onBack = onBack
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                )
            )
        },
        content = {
            LogInContent(
                authenticate = authenticateViewModel.authenticate,
                loginScreenViewModel = loginScreenViewModel
            )
            if (authenticateViewModel.authenticated.value){
                navigateToHome()
            }
            if (loginScreenViewModel.firstOrNot.value){
                navigateToFirstEntranceScreen()
            }
        }
    )

}

@Composable
fun LogInContent(
    authenticate: () -> Unit,
    loginScreenViewModel: LoginScreenViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 60.dp, horizontal = 16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GuidTexture()
        Spacer(modifier = Modifier.height(12.dp))
        AuthInfo(loginScreenViewModel = loginScreenViewModel)
        Spacer(modifier = Modifier.height(12.dp))
        LoginBtn(
            authenticate = authenticate,
            loginScreenViewModel = loginScreenViewModel
        )
    }
}

@Composable
fun GuidTexture(){
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "???????????????!",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Text(
            text = "???????????? ?????????????????????.",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "???????????? ???????????? ???????????? ??????????????? ???????????? ?????????.",
            fontSize = 12.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthInfo(
    loginScreenViewModel: LoginScreenViewModel
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            value = loginScreenViewModel.email.value,
            onValueChange = {
                loginScreenViewModel.setEmail(it)
            },
            placeholder = { Text(text = "???????????? ??????????????????", color = Grey210)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Black33
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            ),
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            value = loginScreenViewModel.password.value,
            onValueChange = {
                loginScreenViewModel.setPassword(it)
            },
            placeholder = { Text(text = "??????????????? ??????????????????", color = Grey210)},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Black33
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun LoginBtn(
    authenticate: () -> Unit,
    loginScreenViewModel: LoginScreenViewModel
){
    val context = LocalContext.current

    Button(
        onClick = {
            GlobalScope.launch {
                loginScreenViewModel.requestLogin(
                    context = context
                )
                loginScreenViewModel.getUserInfo(
                    context = context,
                    authenticate = authenticate
                )
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Carrot
        ),
        shape = MaterialTheme.shapes.extraSmall,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = (loginScreenViewModel.email.value != "" && loginScreenViewModel.password.value != "")
    ) {
        Text(text = "?????????", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Preview("SignInScreen Preview")
@Composable
fun SignInScreenPreview(){
    CarrotTheme {
        Surface {
            LogInScreen({}, {}, AuthenticateViewModel(), LoginScreenViewModel(), {})
        }
    }
}

