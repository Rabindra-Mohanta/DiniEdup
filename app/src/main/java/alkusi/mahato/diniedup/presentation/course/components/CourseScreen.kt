package alkusi.mahato.diniedup.presentation.course.components

import alkusi.mahato.diniedup.R
import alkusi.mahato.diniedup.presentation.course.Data.CourseData
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CourseScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = stringResource(id = R.string.txt_courses),
            color = colorResource(id = R.color.black),
            fontSize = 40.sp,
            modifier = Modifier.padding(start = 10.dp, top = 10.dp)
        )
        val courseList = ArrayList<CourseData>()
        courseList.add(CourseData("UGC-NET/JRF", "2500"))
        courseList.add(CourseData("KUDMALI-EXCISE", "500"))
        courseList.add(CourseData("KUDMALI-CGL", "500"))
        courseList.add(CourseData("KUDMALI-JH POLICW", "500"))
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
        {
            items(courseList) { courseData ->
                ItemCourse(courseData = courseData)

            }
        }
    }

}