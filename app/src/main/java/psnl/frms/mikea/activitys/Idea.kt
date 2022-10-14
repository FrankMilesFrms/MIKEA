package psnl.frms.mikea.activitys

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import psnl.frms.mikea.R

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/10/05 18:23
 */

@Preview
@Composable
fun MainIdea()
{
	Column(modifier = Modifier.fillMaxSize()) {
		RowBanner()

		ButtonBanner()

		Spacer(modifier = Modifier.height(15.dp))

		MasonryLayouts(false)
	}
}

@Composable
fun ButtonBanner()
{
	Image(
			painter = painterResource(id = R.drawable.card24),
			contentDescription = "",
			modifier = Modifier.fillMaxWidth(),
			contentScale = ContentScale.FillWidth
	)
}

@Composable
fun RowBanner()
{
	TipTextOfRowBanner("灵感点亮生活", "")

	Spacer(modifier = Modifier.height(15.dp))

	RowImageBanner(
			R.drawable.card22,
			R.drawable.card23,
			100
	)
}
