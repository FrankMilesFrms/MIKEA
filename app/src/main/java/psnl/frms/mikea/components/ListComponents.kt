package psnl.frms.mikea.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import psnl.frms.mikea.theme.IKEA_GRAY_LIGHT
import psnl.frms.mikea.theme.white
import psnl.frms.mikea.utils.S

/**
 * 实用组件
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/10/05 12:43
 */

/**
 * 双联动列表
 * @param leftList List<String> 左侧条目
 * @param scrollToItem Function1<Int, Int> 右侧滑动影响左侧位置
 * @param itemToScroll Function1<Int, Int> 左侧滑动影响右侧位置，与上者互为反函数
 * @param content [@kotlin.ExtensionFunctionType] Function1<LazyListScope, Unit> 右侧内容填充物
 */
@Composable
fun PartList(
		leftList : List<String>,
		scrollToItem : (Int) -> Int,
		itemToScroll : (Int) -> Int,
		content: LazyListScope.() -> Unit
)
{
	// 滑动状态
	val leftScrollState = rememberLazyListState()
	val rightScrollState = rememberLazyListState()

	// Remember a CoroutineScope to be able to launch
	val coroutineScope = rememberCoroutineScope()

	// 点击左侧的位置
	var onClickItem by remember {
		mutableStateOf(-1)
	}

	// 滑动右侧条目时，左侧联动
	// https://blog.csdn.net/vitaviva/article/details/121583183
	val getFirstVisibleItemIndex by remember {
		derivedStateOf {
			rightScrollState.firstVisibleItemIndex
		}
	}

	LaunchedEffect(Unit) {
		snapshotFlow { getFirstVisibleItemIndex }
				.collect {
					onClickItem = scrollToItem(it)
				}
	}

//	run {
		// 这里应该自行设计何处位置为标头
//		onClickItem = scrollToItem(rightScrollState.firstVisibleItemIndex)

		// todo positive
//		coroutineScope.launch {
//			leftScrollState.scrollToItem(onClickItem)
//		}
//	}


	Row(modifier = Modifier.fillMaxSize())
	{
		LazyColumn(
				state = leftScrollState,
				modifier = Modifier
						.fillMaxHeight()
						.background(IKEA_GRAY_LIGHT)
						.weight(2f)
		)
		{

			items(leftList.size)
			{

				Row(
						modifier = Modifier
								.fillMaxWidth()
								.height(40.dp)
								.background(if (onClickItem == it) white else IKEA_GRAY_LIGHT) // val IKEA_GRAY_LIGHT = Color(245, 245, 245)
								.clickable {
									// 点击左侧时设置跳转状态
									onClickItem = it
									coroutineScope.launch {
										rightScrollState.animateScrollToItem(itemToScroll(it))
									}
								},
						verticalAlignment = Alignment.CenterVertically,
						horizontalArrangement = Arrangement.Center
				) {
					Text(
							text = leftList[it],
							modifier = Modifier,
							color = if(onClickItem == it) Color(14, 97, 167) else Color.Black,
							fontSize = 11.sp,
					)
				}

			}
		}

		Spacer(modifier = Modifier.weight(0.5f))

		LazyColumn(
				state = rightScrollState,
				modifier = Modifier
						.fillMaxHeight()
						.weight(8f),
				content = content
		)
	}
}
