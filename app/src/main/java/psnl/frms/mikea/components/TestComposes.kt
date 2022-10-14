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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import psnl.frms.mikea.theme.IKEA_GRAY_LIGHT
import psnl.frms.mikea.theme.white
import psnl.frms.mikea.utils.S

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/10/01 21:56
 */





//@Preview(showBackground = true, backgroundColor = 0xffffff)
//@Composable
//fun Animated()
//{
//
//	val scrollState = rememberScrollState()
//
//
//	Column(Modifier.fillMaxSize())
//	{
//
//		TopSearchBar(scrollState)
//
//		LazyColumn(modifier = Modifier.verticalScroll(scrollState, enabled = scrollState.value.dp > 30.dp))
//		{
//
//			repeat(20)
//			{
//				Button(
//						onClick = { /*TODO*/ },
//						modifier = Modifier.fillMaxWidth()
//				) {
//					Text(text = " Text $it")
//				}
//			}
//		}
//	}
//}
//
//@Composable
//private fun TopSearchBar(scrollState: ScrollState)
//{
//	var size by remember {
//		mutableStateOf(true)
//	}
//
//
//	Row(
//			modifier = Modifier
//					.fillMaxWidth(),
//			horizontalArrangement = Arrangement.SpaceBetween
//	) {
//		IconButton(
//				onClick = {
//					size = size.not()
//				},
//				modifier = Modifier.weight(1f)
//		) {
//			Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "back", )
//		}
//
//		TextField(
//				value = "",
//				onValueChange = {},
//				modifier = Modifier
//						.padding(start = 5.dp,
//						         top = 30.dp - (scrollState.value.dp.coerceIn(5.dp, 30.dp)),
//						         end = 5.dp,
//						         bottom = 5.dp)
//						.weight(7f)
//						.clip(medium)
//		)
//
//		Row (modifier = Modifier.weight(2f)) {
//			Icon(
//					imageVector = Icons.Outlined.ShoppingCart,
//					contentDescription = "back"
//			)
//
//			Icon(
//					imageVector = Icons.Outlined.Home,
//					contentDescription = "back"
//			)
//		}
//	}
//}
//
//
//@Composable
//fun Draggable()
//{
//	var offsetX by remember {mutableStateOf(0f)}
//	val boxSideLengthDp = 50.dp
//	val boxSildeLengthPx = with(LocalDensity.current) {
//		boxSideLengthDp.toPx()
//	}
//	val draggableState = rememberDraggableState {
//		offsetX = (offsetX + it).coerceIn(0f, 3 * boxSildeLengthPx)
//	}
//	Box(
//			Modifier
//					.width(boxSideLengthDp * 4)
//					.height(boxSideLengthDp)
//					.background(Color.LightGray)
//	) {
//		Box(
//				Modifier
//						.size(boxSideLengthDp)
//						.offset {
//							IntOffset(offsetX.roundToInt(),
//							          0)
//						}
//						.draggable(
//								orientation = Orientation.Horizontal,
//								state = draggableState
//						)
//						.background(Color.DarkGray)
//		)
//	}
//}

