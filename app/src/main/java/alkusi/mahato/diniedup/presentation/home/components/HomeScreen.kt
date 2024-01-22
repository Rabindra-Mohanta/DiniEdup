package alkusi.mahato.diniedup.presentation.home.components
import alkusi.mahato.diniedup.R
import alkusi.mahato.diniedup.presentation.home.components.data.HomeData
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable()
@Preview(showBackground = true)
fun HomeScreen() {
    Column {

        Image(modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .clip(CircleShape)
            .align(alignment = Alignment.End)
            .padding(top = 5.dp, end = 5.dp), painter = painterResource(id = R.drawable.logo), contentDescription = stringResource(id = R.string.txt_image)
        )
        Text(text = stringResource(id = R.string.txt_welcome_back) +" Rabindra Mohanta!", modifier = Modifier.padding(horizontal = 10.dp), fontSize = 34.sp, fontWeight = FontWeight.W500, color = colorResource(id = R.color.dark_purple), lineHeight = 35.sp)
        Spacer(modifier = Modifier.height(10.dp))
        var editSear by remember { mutableStateOf("") }
        TextField(value = editSear, onValueChange ={editSear = it}, placeholder = { Text(text = stringResource(id = R.string.txt_search_for_new_knowledge), fontSize = 15.sp)},modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(50.dp), keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search), singleLine = true, trailingIcon = { Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon"
        )},shape = RectangleShape, textStyle = LocalTextStyle.current.copy(fontSize = 15.sp))

        val listData = ArrayList<HomeData>()
        listData.add(HomeData("Courses","Categories"))
        listData.add(HomeData("Live Class","Categories"))
        listData.add(HomeData("Test Series","Categories"))
        listData.add(HomeData("Payment","Categories"))
         LazyColumn(modifier = Modifier
             .padding(top = 10.dp, start = 10.dp, end = 10.dp)
             .fillMaxHeight()
             .fillMaxWidth())
         {
            items(items = listData){ data->
                HomeItem(homeData = data)

            }
         }
    }
}
