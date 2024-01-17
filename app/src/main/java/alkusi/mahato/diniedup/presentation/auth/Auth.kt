package alkusi.mahato.diniedup.presentation.auth

import alkusi.mahato.diniedup.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun Auth() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    )
    {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.white)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.txt_image),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(), alignment = Alignment.TopCenter
            )
            Box {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.deep_purple),
                    )
                ) {
                   var selectedText by remember {
                       mutableStateOf(0)
                   }
                    var loginTextColor = if(selectedText==0) colorResource(id = R.color.white) else colorResource(id = R.color.gray)
                    var signUpTextColor = if(selectedText ==1) colorResource(id = R.color.white) else colorResource(id = R.color.gray)
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {
                       ClickableText(text = AnnotatedString(stringResource(id = R.string.txt_login).toUpperCase()), onClick = {selectedText=0}, style = TextStyle(fontSize = 20.sp, color = loginTextColor))
                       ClickableText(text = AnnotatedString(stringResource(id = R.string.txt_signUp).toUpperCase()), onClick = {selectedText=1}, style = TextStyle(fontSize = 20.sp, color = signUpTextColor))
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.white),
                        )
                    ) {
                        Spacer(modifier = Modifier.height(60.dp))
                        var editEmail by remember {
                            mutableStateOf("")
                        }
                        OutlinedTextField(
                            value = editEmail,
                            onValueChange = { editEmail = it },
                            label = {
                                Text(
                                    text = stringResource(id = R.string.txt_email)
                                )
                            },
                            placeholder = { Text(text = stringResource(id = R.string.txt_email)) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp))

                        Spacer(modifier = Modifier.height(20.dp))
                        var edtPassword by remember {
                            mutableStateOf("")
                        }
                        var passwordVisibility by remember {
                            mutableStateOf(false)
                        }
                        val icon =
                            if (passwordVisibility) painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
                            else painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)
                        OutlinedTextField(value = edtPassword,
                            onValueChange = { edtPassword = it },
                            label = {
                                Text(
                                    text = stringResource(id = R.string.txt_password)
                                )
                            },
                            placeholder = { Text(text = stringResource(id = R.string.txt_password)) },
                            trailingIcon = {
                                IconButton(
                                    onClick = { passwordVisibility = !passwordVisibility }) {
                                    Icon(painter = icon, contentDescription = "visibility icon")

                                }
                            },
                            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 30.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = stringResource(id = R.string.txt_forgot_pass),
                            modifier = Modifier.padding(horizontal = 30.dp),
                            color = colorResource(
                                id = R.color.deep_purple
                            )
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Button(
                            onClick = { /*TODO*/ }, modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(horizontal = 30.dp), shape = RoundedCornerShape(10), colors = ButtonDefaults.buttonColors(containerColor = colorResource(
                                id = R.color.deep_purple
                            ))
                        ) {
                            Text(text = stringResource(id = R.string.txt_login))
                        }
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            text = stringResource(id = R.string.txt_create_account),
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = colorResource(
                                id = R.color.deep_purple
                            )
                        )
                    }


                }


            }

        }


    }
}


