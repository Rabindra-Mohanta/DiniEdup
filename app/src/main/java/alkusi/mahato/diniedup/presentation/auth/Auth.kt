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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                    var loginTextColor =
                        if (selectedText == 0) colorResource(id = R.color.white) else colorResource(
                            id = R.color.gray
                        )
                    var signUpTextColor =
                        if (selectedText == 1) colorResource(id = R.color.white) else colorResource(
                            id = R.color.gray
                        )
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ) {
                        ClickableText(
                            text = AnnotatedString(stringResource(id = R.string.txt_login).toUpperCase()),
                            onClick = { selectedText = 0 },
                            style = TextStyle(fontSize = 20.sp, color = loginTextColor)
                        )
                        ClickableText(
                            text = AnnotatedString(stringResource(id = R.string.txt_signUp).toUpperCase()),
                            onClick = { selectedText = 1 },
                            style = TextStyle(fontSize = 20.sp, color = signUpTextColor)
                        )
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
                        if (selectedText == 0) {
                            loginScreen()
                        } else {
                            signUpScreen()
                        }

                    }
                }
            }
        }
    }
}


