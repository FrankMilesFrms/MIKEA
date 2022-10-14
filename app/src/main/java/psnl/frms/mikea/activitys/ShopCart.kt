package psnl.frms.mikea.activitys

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import psnl.frms.mikea.theme.IKEA_BLUE
import psnl.frms.mikea.theme.IKEA_Yellow
import psnl.frms.mikea.theme.body2
import psnl.frms.mikea.theme.button
import psnl.frms.mikea.theme.h1
import psnl.frms.mikea.theme.large
import psnl.frms.mikea.theme.medium
import psnl.frms.mikea.theme.pink900
import psnl.frms.mikea.theme.small
import psnl.frms.mikea.theme.white

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/10/05 17:03
 */

@Preview()
@Composable
fun MainShopCart()
{
	Box(
			Modifier
					.fillMaxWidth()
					.background(IKEA_BLUE)
	) {
		Text(
				text = "购物袋",
				style = h1,
				fontSize = 20.sp,
				color = white,
				modifier = Modifier.padding(top =  30.dp, start = 15.dp)
		)

		Column(
				Modifier.fillMaxSize(),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
		) {
			Row (modifier = Modifier.padding(bottom = 10.dp)) {
				Text(
						text = "登录",
						style = h1,
						fontSize = 27.sp,
						color = white
				)

				Text(
						text = "宜家",
						style = h1,
						fontSize = 27.sp,
						color = IKEA_Yellow
				)

				Text(
						text = "账户",
						style = h1,
						fontSize = 27.sp,
						color = white
				)
			}

			Text(
					text = "随时随地，将万千灵感装进口袋。",
					style = body2,
					fontSize = 15.sp,
					color = white,
					modifier = Modifier.padding(top =  0.dp)
			)

			Spacer(modifier = Modifier.height(20.dp))
			Button(
					onClick = { /*TODO*/ },
					modifier = Modifier
							.clip(RoundedCornerShape(134.dp))
							.width(170.dp)
							.height(50.dp),
					colors = ButtonDefaults.buttonColors(white)
			) {
				Text(
						text = "注册/登录",
						style = button,
						color = Color.Black
				)
			}

			Spacer(modifier = Modifier.height(50.dp))
		}
	}
}