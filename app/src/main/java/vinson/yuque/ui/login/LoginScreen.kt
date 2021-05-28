package vinson.yuque.ui.login

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.*
import vinson.yuque.R

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = viewModel()
){
    val username: String by viewModel.username.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    LoginContent(
        username = username,
        password = password,
        onUsernameChange = { viewModel.onUsernameChange(it) },
        onPasswordChange = { viewModel.onPasswordChange(it) },
        onTryLogin = { viewModel.tryLogin() }
    )
}

@Composable
fun LoginContent(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTryLogin: () -> Unit
){
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.size(48.dp))
            Image(
                painter = painterResource(id = R.drawable.logo_login),
                contentDescription = null,
                modifier = Modifier
                    .height(32f.dp)
                    .width(79f.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(id = R.string.slogan_Chinese),
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = stringResource(id = R.string.description_Chiness),
                style = MaterialTheme.typography.overline
            )
            Spacer(modifier = Modifier.size(36.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_login),
                contentDescription = null,
                modifier = Modifier
                    .height(211f.dp)
                    .width(386f.dp),
                contentScale = ContentScale.Crop
            )

            TextField(
                value = username,
                onValueChange = onUsernameChange,
                label = { Text(text = "Username")},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = colorResource(id = R.color.main_green),
                    backgroundColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.main_green),
                    focusedLabelColor = colorResource(id = R.color.main_green)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 18.dp,
                        end = 18.dp
                    )

            )

            TextField(
                value = password,
                onValueChange = onPasswordChange,
                label = { Text(text = "Password")},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = colorResource(id = R.color.main_green),
                    backgroundColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.main_green),
                    focusedLabelColor = colorResource(id = R.color.main_green)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 18.dp,
                        end = 18.dp,
                        top = 8.dp
                    ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                )

            )

            TextButton(
                onClick = onTryLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 18.dp,
                        end = 18.dp,
                        top = 18.dp
                    )
            ){
                Text(
                    text = "Login",
                    style = TextStyle(
                        color = colorResource(id = R.color.main_green),
                        fontSize = 20.sp
                    )
                )
            }
            

        }
    }
}

@Composable
@Preview(name = "Login")
fun DefaultPreview(){
    LoginScreen()
}