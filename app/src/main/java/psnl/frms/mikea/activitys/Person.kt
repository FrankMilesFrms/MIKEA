package psnl.frms.mikea.activitys

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import psnl.frms.mikea.R
import psnl.frms.mikea.theme.IKEA_BLUE
import psnl.frms.mikea.theme.IKEA_Yellow
import psnl.frms.mikea.theme.body1
import psnl.frms.mikea.theme.button
import psnl.frms.mikea.theme.h1
import psnl.frms.mikea.theme.white

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/10/05 17:38
 */

@Preview
@Composable
fun MainPerson()
{
	Column(modifier = Modifier.fillMaxSize()) {
		Column(
				modifier = Modifier
						.fillMaxWidth()
						.background(IKEA_BLUE)
		) {

			Spacer(modifier = Modifier.height(15.dp))

			Row(modifier = Modifier.fillMaxWidth(),
			    horizontalArrangement = Arrangement.End) {
				Icon(
						painter = painterResource(id = R.drawable.setting),
						contentDescription = "",
						modifier = Modifier
								.size(35.dp)
								.padding(end = 10.dp),
						tint = Color.Unspecified
				)
			}
			Spacer(modifier = Modifier.height(20.dp))

			Row {
				Spacer(modifier = Modifier.width(20.dp))

				Text(
						text = "欢迎来到",
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
			}

			Text(
					text = "很高兴您来到这里",
					style = h1,
					fontSize = 27.sp,
					color = white,
					modifier = Modifier.padding(start = 20.dp)
			)

			Spacer(modifier = Modifier.height(15.dp))

			Text(
					text = "如您在宜家官网注册登录过，可直接该宜家官网账号进行登录。",
					style = body1,
					fontSize = 15.sp,
					color = white,
					modifier = Modifier.padding(start = 20.dp, end = 20.dp)
			)

			Spacer(modifier = Modifier.height(35.dp))

			Row(modifier = Modifier.fillMaxWidth().padding(start = 30.dp, end = 30.dp))
			{
				Button(
						onClick = { /*TODO*/ },
						modifier = Modifier
								.clip(RoundedCornerShape(30.dp))
								.fillMaxWidth()
								.height(50.dp),
						colors = ButtonDefaults.buttonColors(white)
				) {
					Text(
							text = "注册/登录",
							style = button,
							color = Color.Black
					)
				}
			}

			Spacer(modifier = Modifier.height(15.dp))
		}

		Column(
				modifier = Modifier
						.fillMaxWidth()
						.background(white)
						.weight(2f)
		) {
			OptionOfPerson("在线客服")

			Divider(thickness = 0.4.dp)

			OptionOfPerson("问卷调查")
		}
	}
}

@Composable
fun OptionOfPerson(string: String)
{
	Row(
			modifier = Modifier
					.fillMaxWidth()
					.height(65.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
	) {
		Text(
				text = string,
				modifier = Modifier.padding(start = 20.dp)
		)

		Icon(
				painter = painterResource(id = R.drawable.forward),
				contentDescription = "",
				modifier = Modifier
						.size(30.dp)
						.padding(end = 10.dp)
		)
	}
}
