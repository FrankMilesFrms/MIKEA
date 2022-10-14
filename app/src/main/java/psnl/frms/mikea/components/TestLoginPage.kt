package psnl.frms.mikea.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import psnl.frms.mikea.theme.body1
import psnl.frms.mikea.theme.body2
import psnl.frms.mikea.theme.button
import psnl.frms.mikea.theme.gray
import psnl.frms.mikea.theme.h1
import psnl.frms.mikea.theme.pink900
import psnl.frms.mikea.theme.small
import psnl.frms.mikea.theme.white

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/09/25 23:06
 */

@Composable
fun LoginPage(logInListener : () -> Unit)
{
	Column(
			modifier = Modifier
					.fillMaxSize()
					.background(white)
					.padding(horizontal = 16.dp)
	) {
		LoginTitle()
		HintInputBox()
		HintWithUnderline()
		LoginButton(logInListener)
	}
}
@Preview
@Composable
fun LoginButton(logInListener : () -> Unit = {})
{
	Button(
			onClick = { logInListener() },
			modifier = Modifier
					.height(48.dp)
					.fillMaxWidth()
					.clip(small),
			colors = ButtonDefaults.buttonColors(pink900)
	) {
		Text(
				text = "Log in",
				style = button,
				color = white
		)
	}
}

@Composable
fun HintWithUnderline()
{
	Column(modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)) {
		TopText()
		BottomText()
	}
}

@Composable
fun BottomText()
{
	Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
	){
		Text(
				text = "and to our ",
				style = body2,
				color = gray
		)

		Spacer(modifier = Modifier.padding(2.dp))


		Text(
				text = "Privacy Policy",
				style = body2,
				color = gray,
				textDecoration = TextDecoration.Underline
		)
	}
}

@Composable
fun TopText()
{
	Row (
			horizontalArrangement = Arrangement.SpaceBetween
	){
		Text(
				text = "By Clicking below you agree to our",
				style = body2,
				color = gray
		)

		Spacer(modifier = Modifier.padding(2.dp))

		Text(
				text = "Terms of Use",
				style = body2,
				color = gray,
				textDecoration = TextDecoration.Underline
		)
	}
}

@Composable
fun HintInputBox()
{
	LoginTextField("Email Address")
	Spacer(modifier = Modifier.height(8.dp))
	LoginTextField("Password(8+ Characters)")
}


@Composable
fun LoginTextField(hideText : String)
{
	OutlinedTextField(
			value = "",
			onValueChange = {},
			modifier = Modifier
					.fillMaxWidth()
					.height(56.dp)
					.clip(small)
					.border(BorderStroke(1.dp, Color.Black)),

			placeholder = {
				Text(
						text = hideText,
						style = body1,
						color = gray
				)
			},

			)
}

@Composable
fun LoginTitle()
{
	Text(
			text = "Log in with email",
			modifier = Modifier
					.fillMaxWidth()
					.paddingFromBaseline(top = 184.dp,
					                     bottom = 16.dp),
			style = h1,
			color = gray,
			textAlign = TextAlign.Center
	)
}
