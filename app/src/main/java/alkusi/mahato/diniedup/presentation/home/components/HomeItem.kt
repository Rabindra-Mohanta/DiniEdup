package alkusi.mahato.diniedup.presentation.home.components

import alkusi.mahato.diniedup.R
import alkusi.mahato.diniedup.presentation.home.components.data.HomeData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable()
fun HomeItem(homeData: HomeData) {

    Card(
        shape = RoundedCornerShape(15.dp), modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = colorResource(id = R.color.dark_purple))
        )
        {
            Image(
                painter = painterResource(id = R.drawable.bg_illustration),
                contentDescription = stringResource(id = R.string.txt_image),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    text = homeData.type,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.padding(start = 20.dp, top = 10.dp),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .width(150.dp)
                        .height(30.dp)
                        .padding(start = 20.dp), shape = RoundedCornerShape(20),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(id = R.color.deep_purple),
                        containerColor = colorResource(id = R.color.white)
                    )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Text(
                            text = homeData.name,
                            fontSize = 10.sp,
                            modifier = Modifier.align(alignment = Alignment.Center)
                        )
                        Image(
                            imageVector = Icons.Default.NavigateNext,
                            contentDescription = stringResource(id = R.string.txt_image),
                            modifier = Modifier
                                .align(alignment = Alignment.TopEnd)
                                .padding(top = 1.dp)
                        )
                    }
                }

            }
        }
    }

}
