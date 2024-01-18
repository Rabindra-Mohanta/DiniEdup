package alkusi.mahato.diniedup.presentation.auth

import alkusi.mahato.diniedup.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun signUpScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        var edtFirstName by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = edtFirstName,
            onValueChange = { edtFirstName = it },
            label = { Text(text = stringResource(id = R.string.user_name)) },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.user_name)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        var edtEmail by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = edtEmail,
            onValueChange = { edtEmail = it },
            label = { Text(text = stringResource(id = R.string.txt_email)) },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.txt_email)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        var edtContactNumber by remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = edtContactNumber,
            onValueChange = { edtContactNumber = it },
            label = { Text(text = stringResource(id = R.string.txt_contactNumber)) },
            placeholder = {
                Text(
                    text = stringResource(id = R.string.txt_contactNumber)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        var edtPassword by remember {
            mutableStateOf("")
        }
        var passwordVisibility by remember {
            mutableStateOf(false)
        }
        var passWordIcon =
            if (passwordVisibility) painterResource(id = com.google.android.material.R.drawable.design_ic_visibility) else painterResource(
                id = com.google.android.material.R.drawable.design_ic_visibility_off
            )
        OutlinedTextField(
            value = edtPassword,
            onValueChange = { edtPassword = it },
            label = {
                Text(
                    text = stringResource(id = R.string.txt_password)
                )
            },
            placeholder = { Text(text = stringResource(R.string.txt_password)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp), trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(
                        painter = passWordIcon,
                        contentDescription = stringResource(id = R.string.txt_visibility_icon)
                    )
                }
            }, visualTransformation = if(passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(20.dp))
        var edtConfirmPassword by remember {
            mutableStateOf("")
        }
        var confirmPassVisibility by remember {
            mutableStateOf(false)
        }
        val confirmPassIcon =
            if (confirmPassVisibility) painterResource(id = com.google.android.material.R.drawable.design_ic_visibility)
            else painterResource(id = com.google.android.material.R.drawable.design_ic_visibility_off)

        OutlinedTextField(
            value = edtConfirmPassword,
            onValueChange = { edtConfirmPassword = it },
            label = {
                Text(
                    text = stringResource(id = R.string.txt_confirm_pass)
                )
            },
            placeholder = { Text(text = stringResource(id = R.string.txt_confirm_pass)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp), trailingIcon = {
                IconButton(onClick = { confirmPassVisibility = !confirmPassVisibility }) {
                    Icon(
                        painter = confirmPassIcon,
                        contentDescription = stringResource(id = R.string.txt_visibility_icon)
                    )

                }
            }
            , visualTransformation = if(confirmPassVisibility) VisualTransformation.None else PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .height(50.dp), shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.deep_purple))
        ) {
            Text(text = stringResource(id = R.string.txt_create_account))

        }

    }

}
