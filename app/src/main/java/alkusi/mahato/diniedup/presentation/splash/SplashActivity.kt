package alkusi.mahato.diniedup.presentation.splash

import alkusi.mahato.diniedup.R
import alkusi.mahato.diniedup.common.DiniConstants
import alkusi.mahato.diniedup.presentation.MainActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import alkusi.mahato.diniedup.presentation.ui.theme.DiniEdupTheme
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiniEdupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreen()
                }
            }
        }
    }

    @Composable
    @Preview
    fun SplashScreen() {
        val customFontFamily = FontFamily(Font(R.font.inter_600, FontWeight.W700))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.splash_img),
                contentDescription = DiniConstants.txt_splash_image,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
            )

            Text(
                text = stringResource(id = R.string.msg_learn_at_home),
                color = colorResource(id = R.color.deep_purple),
                modifier = Modifier.padding(horizontal = DiniConstants.INT_40.dp),
                style = LocalTextStyle.current.copy(
                    fontSize = DiniConstants.INT_24.sp,
                    lineHeight = DiniConstants.INT_40.sp,
                    fontFamily = customFontFamily
                ),
                textAlign = TextAlign.Center
            )
        }

        LaunchedEffect(key1 = true) {
            delay(DiniConstants.INT_4000.toLong())
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()

        }
    }
}





