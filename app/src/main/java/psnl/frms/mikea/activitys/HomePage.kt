package psnl.frms.mikea.activitys

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/10/03 16:51
 */
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import psnl.frms.mikea.R
import psnl.frms.mikea.theme.IKEA_BLUE
import psnl.frms.mikea.theme.IKEA_GRAY
import psnl.frms.mikea.theme.IKEA_GRAY_LIGHT
import psnl.frms.mikea.theme.body1
import psnl.frms.mikea.theme.gray
import psnl.frms.mikea.theme.h1
import psnl.frms.mikea.theme.h2
import psnl.frms.mikea.theme.small
import psnl.frms.mikea.theme.white
import psnl.frms.mikea.utils.S
import psnl.frms.mikea.utils.navList

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true,
         backgroundColor = 0xFFFFFFFF)
@Composable
fun MainHome(systemUiController: SystemUiController = rememberSystemUiController())
{
	val scroll = rememberScrollState()
	val navController = rememberNavController()

	Scaffold(bottomBar = {
		MainBottomBar(navController, systemUiController)
	}) {
		NavHost(navController = navController, startDestination = S.NAV_HomePage)
		{
			composable(S.NAV_HomePage) {
				HomePage(scroll)
			}

			composable(S.NAV_Classification) {
				Classification()
			}

			composable(S.NAV_Idea) {
				MainIdea()
			}

			composable(S.NAV_Cart) {
				MainShopCart()
			}

			composable(S.NAV_Person) {
				MainPerson()
			}

		}
	}
}

@Composable
fun HomePage(scroll: ScrollState)
{
	Column(
			modifier = Modifier
					.fillMaxSize()
	) {
		// 顶部检索框
		TopAppBar()

		Column(
				modifier = Modifier
						.fillMaxSize()
						.verticalScroll(scroll)
		) {
			// banner
			HomePageBanner()

			// 重要通知
			HomePageText()

			// 大卡片
			CardOfGoodsRecommends()

			// 单个手动轮播图
			RowBannerSingle()

			// 单个Card手动轮播图
			RowBannerCard()

			// 从房间开始，探索居家灵感
			RowBannerRoomCard()

			//宜家设计服务，一对一服务
			OtherCardOfGoods()

			// 瀑布流商品栏目
			MasonryLayouts()
		}
	}
}

@Composable
fun OtherCardOfGoods()
{
	TipTextOfRowBanner(
			"宜家设计服务，", "一对一服务。"
	)

	CardOfGoodsRecommends(
			R.drawable.card10,
			R.drawable.card11,
			R.drawable.card12
	)
}

@Composable
fun RowBannerRoomCard()
{
	val resImage = listOf(
			R.drawable.card6,
			R.drawable.card7,
			R.drawable.card8,
			R.drawable.card9
	)
	TipTextOfRowBanner(
			"从房间开始，", "探索居家灵感。"
	)

	LazyRow(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically
	) {
		items(resImage.size)
		{
			Image(
					painter = painterResource(id = resImage[it]),
					contentDescription = "",
					contentScale = ContentScale.FillHeight,
					modifier = Modifier
							.padding(start = 7.dp)
							.height(200.dp)
							.clip(small)
			)
		}
	}
}

@Preview(showBackground = true, backgroundColor = 0xfffffff)
@Composable
fun RowBannerCard()
{
	TipTextOfBannerCard()

	LazyRow(modifier = Modifier.fillMaxWidth())
	{
		items(1)
		{
			RowBannerListCard(color = Color(90, 164, 137), categoryString = "书柜")
			RowBannerListCard(color = Color(79, 151, 194), categoryString = "浴室化妆镜")
			RowBannerListCard(color = Color(212, 151, 60), categoryString = "碗")
		}
	}
}

@Composable
fun RowBannerListCard(
		color: Color,
		categoryString : String
)
{
	Card(modifier = Modifier
			.height(280.dp)
			.width(220.dp)
			.clip(small)
			.padding(5.dp)
	) {
		Column(modifier = Modifier.fillMaxSize()) {
			Column(
					Modifier
							.fillMaxWidth()
							.background(color)
							.padding(start = 7.dp)
							.height(90.dp)
			) {
				Text(
						text = "热销榜",
						style = h2,
						fontSize = 12.sp,
						modifier = Modifier.padding(start =  6.dp, top = 7.dp, bottom = 10.dp),
						color = white
				)

				Row(modifier = Modifier.fillMaxWidth(),
				    horizontalArrangement = Arrangement.SpaceBetween,
				    verticalAlignment = Alignment.CenterVertically) {

					Text(
							text = categoryString,
							style = h2,
							fontSize = 20.sp,
							modifier = Modifier.padding(start = 9.dp),
							color = white
					)

					Text(
							text =  ">",
							style = h2,
							fontSize = 15.sp,
							color = white,
							modifier = Modifier.padding(end = 8.dp)
					)
				}
			}

			Column(modifier = Modifier
					.fillMaxWidth()
					.height(170.dp)
					.background(white)
			) {
				Image(painter = painterResource(id = R.drawable.card13), contentDescription = "")
			}
		}
	}
}

@Composable
fun TipTextOfBannerCard()
{
	Row(
			modifier = Modifier
					.fillMaxWidth()
					.padding(top = 17.dp,
					         bottom = 4.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
	) {
		Row(
				Modifier,
				verticalAlignment = Alignment.CenterVertically
		) {
			Text(
					text = "宜家榜单，",
					style = h2,
					fontSize = 17.sp,
					modifier = Modifier.padding(start = 15.dp)
			)
			Text(
					text =  "人气之选。",
					style = h2,
					fontSize = 17.sp,
					color = Color.Gray
			)
		}

		Row(verticalAlignment = Alignment.CenterVertically) {
			Text(
					text =  "查看全部  >",
					style = h2,
					fontSize = 12.sp,
					color = Color.Gray
			)

//			Icon(
//					imageVector = Icons.Outlined.ArrowForward,
//					contentDescription = ""
//			)
		}
	}
}

@Composable
fun MainBottomBar(navController : NavHostController, systemUiController: SystemUiController)
{
	BottomNavigation(
			modifier = Modifier
					.fillMaxWidth()
					.height(56.dp)
					.background(white)
	) {
		val navBackStackEntry by navController.currentBackStackEntryAsState()
		val currentDestination = navBackStackEntry?.destination

		SideEffect {
			if(
				currentDestination?.hierarchy?.any {
					now ->
					(S.NAV_Cart == now.route) or (S.NAV_Person == now.route)
				}  == true
			) {
				systemUiController.setSystemBarsColor(color = IKEA_BLUE)
			} else {
				systemUiController.setSystemBarsColor(color = white)
			}
		}
		navList.forEach {
			val selected = currentDestination?.hierarchy?.any {now -> it.targetString == now.route} == true

			BottomNavigationItem(
					modifier = Modifier.background(white),

					onClick = {
							navController.navigate(it.targetString)
							{
								popUpTo(navController.graph.findStartDestination().id) {
									saveState = true
								}

								launchSingleTop = true
								restoreState = true
							}
					},
					icon = {
						Icon(
								painter = painterResource(id = if(selected) it.resVectorSelect else it.resVector),
								contentDescription = null,
								modifier = Modifier
										.size(24.dp),
								tint = Color.Unspecified
						)
					},
					label = {
						Text(
								it.name,
								style = body1,
								color = if(selected) Color(0xff1296db) else gray
						)
					},
					selected = selected
			)
		}
	}
}

@Composable
fun HomePageText()
{
	Row(
			modifier = Modifier
					.fillMaxWidth()
					.height(30.dp)
					.background(IKEA_GRAY),
			verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
				imageVector = Icons.Outlined.Info,
				modifier = Modifier
						.padding(start = 1.dp,
						         end = 1.dp)
						.weight(1f)
						.size(15.dp),
				contentDescription = ""
		)

		Text(
				text = "疫情影响配送服务通知",
				modifier = Modifier.weight(7f),
				fontSize = 12.sp
		)

		Icon(
				imageVector = Icons.Filled.ArrowForward,
				modifier = Modifier
						.padding(start = 10.dp,
						         end = 5.dp)
						.weight(1f)
						.size(15.dp),
				contentDescription = ""
		)
	}

	Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MasonryLayouts(
		showRecommendText : Boolean = true
)
{
	val images = listOf(
			R.drawable.card17,
			R.drawable.card15,
			R.drawable.card14
	)
	Column(Modifier
			       .fillMaxWidth()
			       .height(1000.dp)
			       .background( if(showRecommendText) IKEA_GRAY_LIGHT else white),
	       horizontalAlignment = Alignment.CenterHorizontally
	) {
		if(showRecommendText) {
			Text(
					text = "为你推荐",
					fontSize = 20.sp,
					color = Color.Black,
					style = h1,
					modifier = Modifier.padding(top = 15.dp,
					                            bottom = 15.dp)
			)
		}

		LazyVerticalGrid(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.spacedBy(10.dp),
				verticalArrangement = Arrangement.spacedBy(10.dp),
				// 固定两列
				columns = GridCells.Fixed(2),
				content = {
					items(30){
						RandomGoodsBox(images[it % images.size])
					}
				}
		)
	}
}

@Composable
fun RandomGoodsBox(resInt : Int)
{
	Card(
			modifier = Modifier.fillMaxWidth()
	) {
		Image(
				painter = painterResource(id = resInt),
				contentDescription = "",
				contentScale = ContentScale.FillWidth
		)
	}
}

@Composable
fun RowBannerSingle()
{
	TipTextOfRowBanner()

	RowImageBanner()
}

@Composable
fun RowImageBanner(
		image1Int: Int = R.drawable.card4,
		image2Int: Int = R.drawable.card5,
		heightInt: Int = 120
)
{
	LazyRow(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically
	) {
		items(3)
		{
			Image(
					painter = painterResource(id = image1Int),
					contentDescription = "",
					modifier = Modifier
							.padding(start = 7.dp)
							.height(heightInt.dp)
							.clip(small),
					contentScale = ContentScale.FillHeight
			)

			Image(
					painter = painterResource(id = image2Int),
					contentDescription = "",
					modifier = Modifier
							.padding(start = 7.dp)
							.height(heightInt.dp)
							.clip(small),
					contentScale = ContentScale.FillHeight
			)
		}
	}
}


@Composable
fun TipTextOfRowBanner(
		firstString: String = "最新动态，",
		secondString: String = "时刻关注。"
)
{
	Row(
			Modifier
					.fillMaxWidth()
					.padding(top = 17.dp,
					         bottom = 4.dp),
			verticalAlignment = Alignment.CenterVertically
	) {
		Text(
				text = firstString,
				style = h2,
				fontSize = 17.sp,
				modifier = Modifier.padding(start = 15.dp)
		)
		Text(
				text = secondString,
				style = h2,
				fontSize = 17.sp,
				color = Color.Gray
		)
	}
}

@Composable
fun CardOfGoodsRecommends(
		leftCard : Int = R.drawable.card1,
		topCard : Int = R.drawable.card2,
		bottomCard : Int = R.drawable.card3
)
{
	Row(
			modifier = Modifier
					.fillMaxWidth()
					.height(280.dp)
					.padding(10.dp),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically

	) {

		Column(
				modifier = Modifier.weight(45f),
				horizontalAlignment = Alignment.CenterHorizontally,
				verticalArrangement = Arrangement.Center
		) {
			Image(
					painter = painterResource(id = leftCard),
					contentDescription = "",
					contentScale = ContentScale.FillBounds,
					modifier = Modifier
							.fillMaxSize()
							.clip(small)
			)
		}

		Column(
				modifier = Modifier
						.weight(50f)
						.padding(start = 10.dp),
				verticalArrangement = Arrangement.Center,
				horizontalAlignment = Alignment.CenterHorizontally
		) {
			Image(
					painter = painterResource(id = topCard),
					contentDescription = "",
					contentScale = ContentScale.FillBounds,
					modifier = Modifier
							.fillMaxWidth()
							.padding(bottom = 3.dp)
							.clip(small)
							.weight(1f)
			)


			Image(
					painter = painterResource(id = bottomCard),
					contentDescription = "",
					contentScale = ContentScale.FillBounds,
					modifier = Modifier
							.fillMaxWidth()
							.padding(top = 3.dp)
							.clip(small)
							.weight(1f)
			)
		}
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePageBanner()
{
	val pagerState = rememberPagerState()

	// todo auto scroll to page
//	LaunchedEffect(pagerState.currentPage) {
//		if (pagerState.pageCount > 0) {
//			delay(1500)
//			//这里直接+1就可以循环，前提是pagerState的infiniteLoop == true
//			pagerState.animateScrollToPage(pagerState.currentPage + 1)
//		}
//	}

	HorizontalPager(
			state = pagerState,
			count = 4,
			modifier = Modifier.fillMaxWidth(),
	) {

		Image(
				painter = painterResource(id = R.drawable.banner2),
				contentDescription = "",
				modifier = Modifier.fillMaxWidth()
		)
	}

}

@Composable
fun TopAppBar()
{
	Column(modifier = Modifier.fillMaxWidth())
	{

		Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically
		)
		{
			Icon(
					painter = painterResource(id = R.drawable.ikea_logo),
					contentDescription = "logo",
					modifier = Modifier
							.size(55.dp)
							.weight(2.0f)
							.padding(start = 5.dp),
					tint = Color.Unspecified,

					)

			Spacer(modifier = Modifier.weight(8f))

			Icon(
					imageVector = Icons.Outlined.Notifications,
					contentDescription = "logo",
					modifier = Modifier
							.size(25.dp)
							.weight(1f),
					tint = Color.Unspecified
			)

			Spacer(modifier = Modifier.weight(0.25f))

			Icon(
					painter = painterResource(id = R.drawable.cq_code),
					contentDescription = "logo",
					modifier = Modifier
							.size(25.dp)
							.weight(1f)
							.padding(end = 0.dp),
					tint = Color.Unspecified
			)

			Spacer(modifier = Modifier.weight(0.45f))
		}

		HomeSearchBar()
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeSearchBar(
		hasSearchButtonBoolean: Boolean = true,
		barHeight : Int = 50,
		bottomOfHeight : Int = 10,
		sizeOfRoundCornerShape : Int = 20,
		needScrollText : Boolean = true
)
{
	val searchTips = listOf("床", "书柜", "柜子")
	val pagerState = rememberPagerState()

	LaunchedEffect(pagerState.currentPage) {
		if (pagerState.pageCount > 0 && needScrollText) {
			delay(1500)
			//这里直接+1就可以循环，前提是pagerState的infiniteLoop == true
			pagerState.animateScrollToPage(pagerState.currentPage + 1, 1f)
		}
	}

	Row(
			modifier = Modifier
					.fillMaxWidth()
					.height(barHeight.dp)
					.padding(start = 15.dp,
					         end = 15.dp,
					         bottom = bottomOfHeight.dp)
					.clip(RoundedCornerShape(sizeOfRoundCornerShape.dp))
					.background(IKEA_GRAY_LIGHT),
			horizontalArrangement = Arrangement.Center,
			verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
				imageVector = Icons.Rounded.Search,
				contentDescription = "search",
				modifier = Modifier
						.padding(start = 10.dp,
						         end = 10.dp)
						.size(20.dp),
				tint = Color.Unspecified
		)

		VerticalPager(
				count = 3,
				state = pagerState,
				modifier = Modifier.weight(5f),
				horizontalAlignment = Alignment.Start,
		) {
			Text(
					text = searchTips[it],
					color = Color.Gray,
			)
		}

		if (hasSearchButtonBoolean)
		{
			Divider(modifier = Modifier
					.fillMaxHeight()
					.padding(end = 10.dp)
					.width(1.dp)
			)

			Text(
					text = "搜索",
					fontSize = 12.sp,
					modifier = Modifier.padding(end = 14.dp)
			)
		}
	}
}
