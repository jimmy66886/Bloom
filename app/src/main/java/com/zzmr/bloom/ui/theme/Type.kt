package com.zzmr.bloom.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.zzmr.bloom.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

// Bloom 字体
val nunitoSansFamily = FontFamily(
    Font(resId = R.font.nunitosans_light, FontWeight.Light),
    Font(resId = R.font.nunitosans_semibold, FontWeight.SemiBold),
    Font(resId = R.font.nunitosans_bold, FontWeight.Bold),
)

val h1 = TextStyle(
    fontSize = 18.sp,
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.Bold
)

val h2 = TextStyle(
    fontSize = 14.sp,
    letterSpacing = 0.15.sp,
    fontFamily = nunitoSansFamily,
    fontWeight = FontWeight.Bold
)

val subtitle1 = TextStyle(
    fontSize = 16.sp, fontFamily = nunitoSansFamily, fontWeight = FontWeight.Light
)

val body1 = TextStyle(
    fontSize = 14.sp, fontFamily = nunitoSansFamily, fontWeight = FontWeight.Light
)

val body2 = TextStyle(
    fontSize = 12.sp, fontFamily = nunitoSansFamily, fontWeight = FontWeight.Light
)

val button = TextStyle(
    fontSize = 14.sp, fontFamily = nunitoSansFamily, fontWeight = FontWeight.SemiBold
)

val caption = TextStyle(
    fontSize = 12.sp, fontFamily = nunitoSansFamily, fontWeight = FontWeight.SemiBold
)