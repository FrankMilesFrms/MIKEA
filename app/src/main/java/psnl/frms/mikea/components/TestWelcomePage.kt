package psnl.frms.mikea.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import psnl.frms.mikea.R
import psnl.frms.mikea.theme.button
import psnl.frms.mikea.theme.gray
import psnl.frms.mikea.theme.medium
import psnl.frms.mikea.theme.pink100
import psnl.frms.mikea.theme.pink900
import psnl.frms.mikea.theme.subtitle1
import psnl.frms.mikea.theme.white

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/09/25 22:25
 */


@Composable
fun WelcomePage(onClick: () -> Unit)
{
	Box(
		modifier = Modifier
				.fillMaxSize()
				.background(pink100)
	) {
		Image(
				painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.light_welcome_bg)),
				contentDescription = "背景",
				Modifier.fillMaxSize()
		)

		WelcomeContent(onClick)
	}
}

@Composable
fun WelcomeContent(onClick: () -> Unit)
{
	Column(modifier = Modifier.fillMaxSize()) {
		Spacer(modifier = Modifier.height(72.dp))

		LeafImage()

		Spacer(modifier = Modifier.height(48.dp))

		WelcomeTitle()

		Spacer(modifier = Modifier.height(40.dp))

		WelcomeButtons(onClick)
	}
}

@Composable
fun WelcomeButtons(onClick: () -> Unit)
{
	Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier.fillMaxWidth()
	) {
		Button(
				onClick = {
					onClick()
				},
				modifier = Modifier
						.height(48.dp)
						.padding(horizontal = 16.dp)
						.fillMaxWidth()
						.clip(medium),
				colors = ButtonDefaults.buttonColors(pink900)
		) {
			Text(
					text = "Create account",
					style = button,
					color = white,
			)
		}

		Spacer(modifier = Modifier.height(24.dp))

		TextButton(onClick = {
			onClick()
		}) {
			Text(
					text = "Log in",
					style = button,
					color = pink900
			)
		}
	}
}

@Composable
fun WelcomeTitle()
{
	Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
		Image(
				painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.light_logo)),
				contentDescription = "logo",
				modifier = Modifier
						.wrapContentSize()
						.padding(32.dp)
		)

		Box(
				modifier = Modifier
						.fillMaxWidth()
						.height(32.dp),
				contentAlignment = Alignment.BottomCenter
		) {
			Text(
					text = "Beautiful hom garden solutions.",
					textAlign = TextAlign.Center,
					style = subtitle1,
					color = gray
			)
		}
	}
}

@Composable
fun LeafImage()
{
	Image(
			painter = rememberVectorPainter(image = ImageVector.vectorResource(id = R.drawable.light_welcome_illos)),
			contentDescription = "ill",
			modifier = Modifier
					.wrapContentSize()
					.padding(start = 88.dp)
	)
}
