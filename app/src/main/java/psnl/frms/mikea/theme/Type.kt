package psnl.frms.mikea.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import psnl.frms.mikea.R

// Set of Material typography styles to start with
val Typography = Typography(
		body1 = TextStyle(
				fontFamily = FontFamily.Default,
				fontWeight = FontWeight.Normal,
				fontSize = 16.sp
		)
		/* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
val DejaVuSansFamily = FontFamily(
	Font(R.font.deja_vu_sans_mono, FontWeight.Light),
	Font(R.font.deja_vu_serif_italic, FontWeight.SemiBold),
	Font(R.font.dejavu_sans_condense_bold, FontWeight.Bold)
)

val h1 = TextStyle(
	fontSize = 18.sp,
	fontFamily = DejaVuSansFamily,
	fontWeight = FontWeight.Bold
)

val h2 = TextStyle(
	fontSize = 14.sp,
	letterSpacing = 0.15.sp,
	fontFamily = DejaVuSansFamily,
	fontWeight = FontWeight.Bold
)

val subtitle1 = TextStyle(
	fontSize = 16.sp,
	letterSpacing = 0.sp,
	fontFamily = DejaVuSansFamily,
	fontWeight = FontWeight.Light
)

val body1 = TextStyle(
	fontSize = 14.sp,
	letterSpacing = 0.sp,
	fontFamily = DejaVuSansFamily,
	fontWeight = FontWeight.Light
)

val body2 = TextStyle(
	fontSize = 12.sp,
	letterSpacing = 0.sp,
	fontFamily = DejaVuSansFamily,
	fontWeight = FontWeight.Light
)

val button = TextStyle(
	fontSize = 14.sp,
	letterSpacing = 1.sp,
	fontFamily = DejaVuSansFamily,
	fontWeight = FontWeight.Bold
)

val caption = TextStyle(
	fontSize = 12.sp,
	letterSpacing = 0.sp,
	fontFamily = DejaVuSansFamily,
	fontWeight = FontWeight.SemiBold
)
