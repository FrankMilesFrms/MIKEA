package psnl.frms.mikea.activitys

import android.view.textclassifier.TextClassification
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerDefaults
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import psnl.frms.mikea.R
import psnl.frms.mikea.components.PartList
import psnl.frms.mikea.theme.IKEA_DARK_BLUE
import psnl.frms.mikea.theme.h1
import psnl.frms.mikea.theme.small
import psnl.frms.mikea.theme.white
import psnl.frms.mikea.utils.S

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/10/04 22:30
 */

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun Classification()
{
	Column(Modifier.fillMaxWidth())
	{

		ClassificationSearchBar()

		ClassificationTabs()

	}
}

@Preview
@Composable
fun RoomList()
{
	PartList(
			leftList = S.LIST_GOODS,
			scrollToItem = {
				listOf(
						0, 0, 1, 2, 3, 4, 5
				)[it]
			},

			itemToScroll = {
				listOf(
						0, 3, 4, 5, 6, 7, 8
				)[it]
			}
	) {
		item {
			Image(
					painter = painterResource(id = R.drawable.card17a),
					contentDescription = "",
					modifier = Modifier
							.fillMaxWidth()
							.padding(top = 10.dp,
							         bottom = 10.dp,
							         end = 10.dp),
					contentScale = ContentScale.FillWidth
			)

			Image(
					painter = painterResource(id = R.drawable.card17b),
					contentDescription = "",
					modifier = Modifier
							.fillMaxWidth()
							.padding(bottom = 10.dp,
							         end = 10.dp),
					contentScale = ContentScale.FillWidth
			)
		}

		items(5)
		{
			GridOfClassification(
					S.LIST_GOODS[it]
			)
		}
	}
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun GridOfClassification(
		titleString: String = "hello world"
)
{
	Column(
			modifier = Modifier
					.fillMaxWidth()
					.padding(bottom = 70.dp),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
				text = titleString,
				style = h1,
				fontSize = 17.sp
		)

		repeat(3){
			Row(
					modifier = Modifier.fillMaxWidth(),
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.SpaceAround
			) {
				repeat(3) {

					Column(
							verticalArrangement = Arrangement.Center,
							horizontalAlignment = Alignment.CenterHorizontally,
							modifier = Modifier
					)
					{
						Image(
								painter = painterResource(id = R.drawable.card21),
								contentDescription = "",
								modifier = Modifier.size(80.dp)
						)

						Text(
								text = "12345",
								fontSize = 12.sp
						)
					}

				}
			}
		}
	}
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun GoodsDoublePager()
{
	LazyColumn(
			modifier = Modifier.fillMaxWidth(),
			verticalArrangement = Arrangement.Center,
			horizontalAlignment = Alignment.CenterHorizontally
	)
	{
		items(10) {
			Image(
					painter = painterResource(id = R.drawable.card18),
					contentDescription = "",
					modifier = Modifier
							.fillMaxWidth()
							.padding(12.dp)
							.clip(small),
					contentScale = ContentScale.FillWidth
			)

			Image(
					painter = painterResource(id = R.drawable.card19),
					contentDescription = "",
					modifier = Modifier
							.fillMaxWidth()
							.padding(12.dp)
							.clip(small),
					contentScale = ContentScale.FillWidth
			)

			Image(
					painter = painterResource(id = R.drawable.card20),
					contentDescription = "",
					modifier = Modifier
							.fillMaxWidth()
							.padding(12.dp)
							.clip(small),
					contentScale = ContentScale.FillWidth
			)
		}
	}
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ClassificationTabs()
{
	var selectIndex by remember {
		mutableStateOf(0)
	}
	val titles = listOf("品类", "房间")

	val coroutineScope = rememberCoroutineScope()

	val pagerState = rememberPagerState()

	Column(modifier = Modifier.fillMaxWidth())
	{
		TabRow(
				selectedTabIndex = selectIndex,
				backgroundColor = white,
				indicator = @Composable { tabPositions ->
					TabRowDefaults.Indicator(
							Modifier.customTabIndicatorOffset(tabPositions[selectIndex]),
							color = IKEA_DARK_BLUE
					)
				},
				modifier = Modifier.fillMaxWidth()
		) {
			titles.forEachIndexed { index, title ->
				Tab(
						text = { Text(title) },
						selected = selectIndex == index,
						onClick = {
							selectIndex = index
							// 上联动下
							coroutineScope.launch {
								pagerState.animateScrollToPage(selectIndex)
							}
						}
				)
			}
		}
	}

	val getFirstVisibleItemIndex by remember {
		derivedStateOf {
			pagerState.currentPage
		}
	}

	LaunchedEffect(Unit) {
		snapshotFlow { getFirstVisibleItemIndex }
				.collect {
					selectIndex = it
				}
	}



	HorizontalPager(
			count = 2,
	state = pagerState,
	) {
		if(it == 0) {
			RoomList()
		} else {
			GoodsDoublePager()
		}
	}
}

// @see https://blog.csdn.net/weixin_42404361/article/details/122146437
fun Modifier.customTabIndicatorOffset(
		currentTabPosition: TabPosition
): Modifier = composed(
		inspectorInfo = debugInspectorInfo {
			name = "tabIndicatorOffset"
			value = currentTabPosition
		}
) {
	val currentTabWidth by animateDpAsState(
			targetValue = currentTabPosition.width,
			animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
	)
	val indicatorOffset by animateDpAsState(
			targetValue = currentTabPosition.left,
			animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing)
	)
	fillMaxWidth()
			.wrapContentSize(Alignment.BottomStart)
			// 推导： 原长为c, 起始位置a, 原长变为原来 1/k 倍， 则到中心位置（a + c/2）需要： a + c/2 - c/2k
			.offset(x = indicatorOffset + currentTabWidth / 2.66667f)  // 偏移量加上宽度的3/8
			.width(currentTabWidth / 4)  // 宽度Tab宽度的1/4
}

@Composable
fun ClassificationSearchBar()
{
	Spacer(modifier = Modifier.height(15.dp))

	Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center
	) {
		Row(
				Modifier.weight(9f)
		) {
			HomeSearchBar(
					false,
					40,
					0,
					30,
					false
			)
		}

		Icon(
				painter = painterResource(id = R.drawable.cq_code),
				contentDescription = "logo",
				modifier = Modifier
						.size(28.dp)
						.weight(1f)
						.padding(end = 10.dp),
				tint = Color.Unspecified
		)
	}
	Spacer(modifier = Modifier.height(15.dp))
}
