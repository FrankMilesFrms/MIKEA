package psnl.frms.mikea.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import psnl.frms.mikea.theme.Pink80
import psnl.frms.mikea.theme.body1
import psnl.frms.mikea.theme.caption
import psnl.frms.mikea.theme.gray
import psnl.frms.mikea.theme.h1
import psnl.frms.mikea.theme.h2
import psnl.frms.mikea.theme.pink100
import psnl.frms.mikea.theme.white
import psnl.frms.mikea.utils.HomeImageItem
import psnl.frms.mikea.utils.bloomBannerList
import psnl.frms.mikea.utils.bloomInfoList
import psnl.frms.mikea.utils.navList

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/09/26 21:48
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun HomePage()
{
	Scaffold(
			bottomBar = {
				BottomBar()
			}
	) {
		Column(
				modifier = Modifier
						.fillMaxSize()
						.background(white)
						.padding(horizontal = 16.dp)
		) {
			SearchBar()
			BloomRowBanner()
			BloomInfoList()
		}
	}
}

@Composable
fun BloomInfoList()
{
	Column {
		Row (
				Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(
					text = "Design your home garden",
					style = h1,
					color = gray,
					modifier = Modifier
							.paddingFromBaseline(top = 40.dp)
			)

			Icon(
					imageVector = Icons.Filled.List,
					"filler",
					modifier = Modifier.padding(top = 24.dp).size(24.dp)
			)

		}
		Spacer(modifier = Modifier.height(16.dp))

		LazyColumn(modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(bottom = 56.dp))
		{
			items(bloomInfoList.size) {
				if(it != 0) {
					Spacer(modifier = Modifier.width(8.dp))
				}

				DesignCard(plant = bloomInfoList[it])
			}
		}
	}
}

@Composable
fun DesignCard(plant: HomeImageItem)
{
	Row(modifier = Modifier.fillMaxWidth()) {
		Image(
				painterResource(id = plant.resId),
				contentScale = ContentScale.Crop,
				contentDescription = "image",
				modifier = Modifier
						.size(64.dp)
						.clip(RoundedCornerShape(4.dp))
		)
		Spacer(modifier = Modifier.width(16.dp))

		Column {
			Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
				Column {
					Text(
							text = plant.name,
							style = h2,
							color = gray,
							modifier = Modifier.paddingFromBaseline(top = 24.dp)
					)

					Text(
							text = "This is a description",
							style = body1,
							color = gray,
							modifier = Modifier
					)
				}
				Checkbox(
						checked = false,
						onCheckedChange = {},
						modifier = Modifier
								.padding(top = 24.dp)
								.size(24.dp),
						colors = CheckboxDefaults.colors(
								checkmarkColor = white
						)
				)
			}
			Divider(color = gray, modifier = Modifier.padding(top = 16.dp), thickness = 0.5.dp)
		}
	}
}

@Composable
fun BloomRowBanner()
{
	Column {
		Box (
				Modifier.fillMaxWidth()
		) {
			Text(
					text = "Browse themes",
					style = h1,
					color = gray,
					modifier = Modifier
							.fillMaxWidth()
							.paddingFromBaseline(top = 32.dp)
			)
		}
		Spacer(modifier = Modifier.height(16.dp))

		LazyRow(modifier = Modifier.height(136.dp))
		{
			items(bloomBannerList.size) {
				if(it != 0) {
					Spacer(modifier = Modifier.width(8.dp))
				}

				PlantCard(plant = bloomBannerList[it])
			}
		}
	}
}

@Composable
fun SearchBar()
{
	Box {
		TextField(
				value = "",
				onValueChange = {},
				modifier = Modifier
						.fillMaxWidth()
						.height(56.dp)
						.clip(RoundedCornerShape(4.dp))
						.border(BorderStroke(1.dp, Color.Black)),
				leadingIcon = {
					Icon(
							imageVector = Icons.Outlined.Search,
							contentDescription = null,
							modifier = Modifier.size(18.dp)
					)
				},
				placeholder = {
					Text(
							text = "Search",
							style = body1,
							color = gray
					)
				},
				colors = TextFieldDefaults.outlinedTextFieldColors(
						backgroundColor = white,
						unfocusedBorderColor = white,
						focusedBorderColor = white
				)
		)
	}
}

@Composable
fun PlantCard(plant : HomeImageItem)
{
	Card(
			modifier = Modifier
					.size(136.dp)
					.clip(RoundedCornerShape(4.dp))
	) {
		Column {
			Image(
					painterResource(id = plant.resId),
					contentDescription = "image",
					contentScale = ContentScale.Crop,
					modifier = Modifier
							.fillMaxWidth()
							.height(96.dp)
			)

			Box(
					modifier = Modifier
							.fillMaxWidth()
							.background(color = Color(0x223f3f3f))
							.padding(start = 16.dp)
			) {

				Text(text = plant.name,
				     style = h2,
				     color = gray,
				     modifier = Modifier
								.fillMaxWidth()
								.paddingFromBaseline(top = 24.dp, bottom = 16.dp)

				)
			}
		}
	}
}

@Composable
fun BottomBar()
{
	BottomNavigation(
			modifier = Modifier
					.fillMaxWidth()
					.height(56.dp)
					.background(pink100)
	) {
		navList.forEach {
			BottomNavigationItem(
					modifier = Modifier.background(Pink80),
					onClick = { /*TODO*/ },
					icon = {
//						Icon(
//								imageVector = it.resVector,
//								contentDescription = null,
//								modifier = Modifier.size(24.dp)
//						)
					},
					label = {
						Text(
								it.name,
								style = caption,
								color = gray
						)
					},
					selected = ("Home" == it.name)
			)
		}
	}
}
