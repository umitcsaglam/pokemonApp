package com.example.myapplication.presentation.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapplication.R

val Roboto = FontFamily(
        Font(R.font.roboto_light, FontWeight.Light),
        Font(R.font.roboto_regular, FontWeight.Normal),
        Font(R.font.roboto_medium, FontWeight.Medium),
        Font(R.font.roboto_bold, FontWeight.Bold),
)

val RobotoCondensed = FontFamily(
        Font(R.font.roboto_condensed_light, FontWeight.Light),
        Font(R.font.roboto_condensed_regular, FontWeight.Normal),
)

val Typography = Typography(
        bodySmall = TextStyle(
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        ),

)