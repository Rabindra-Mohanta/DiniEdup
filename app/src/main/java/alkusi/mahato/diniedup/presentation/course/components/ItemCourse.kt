package alkusi.mahato.diniedup.presentation.course.components

import alkusi.mahato.diniedup.R
import alkusi.mahato.diniedup.common.DiniConstants
import alkusi.mahato.diniedup.presentation.course.Data.CourseData
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ItemCourse(courseData: CourseData)
{
 Card(modifier = Modifier
     .fillMaxWidth()
     .height(100.dp)
     .padding(vertical = 10.dp), shape = RoundedCornerShape(20), elevation = CardDefaults.cardElevation(defaultElevation = DiniConstants.TEN_INT.dp), colors =
 CardDefaults.cardColors(containerColor = colorResource(id = R.color.purple))) {
     Row(modifier = Modifier
         .padding(horizontal = 10.dp)
         .fillMaxWidth()
         .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically) {
      Text(text = courseData.courseName, fontSize = 25.sp, color = colorResource(id = R.color.white), modifier = Modifier.weight(1f))
                Card(modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp)
                    .padding(end = 10.dp, top = 10.dp, bottom = 10.dp), shape = RoundedCornerShape(10.dp)) {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()) {
                        Text(text = stringResource(id = R.string.symbol_rupee)+ courseData.price, modifier = Modifier.align(alignment = Alignment.Center), fontSize = 25.sp)

                    }
       }
     }

 }
}
