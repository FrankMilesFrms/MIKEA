package psnl.frms.mikea.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import psnl.frms.mikea.theme.Purple40
import psnl.frms.mikea.theme.Purple80
import psnl.frms.mikea.theme.PurpleGrey40
import psnl.frms.mikea.theme.PurpleGrey80
import psnl.frms.mikea.theme.Shapes

private val DarkColor = darkColors(
		primary = Purple80,
		secondary = PurpleGrey80,
)

private val LightColor = lightColors(
		primary = Purple40,
		secondary = PurpleGrey40,


		/* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun IKEATheme(
		darkTheme: Boolean = isSystemInDarkTheme(),
		content: @Composable () -> Unit
)
{
	val colors = if (darkTheme)
	{
		DarkColor
	} else
	{
		LightColor
	}

	MaterialTheme(
			colors = colors,
			typography = Typography,
			shapes = Shapes,
			content = content
	)
}