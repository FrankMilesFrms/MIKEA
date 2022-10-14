package psnl.frms.mikea.utils

import androidx.compose.ui.graphics.vector.ImageVector
import psnl.frms.mikea.R

/**
 *
 *@author Frms(Frank Miles)
 *@email 3505826836@qq.com
 *@time 2022/09/26 22:06
 */
data class HomeImageItem(val name:String, val resId: Int)

data class HomeImageVectorItem(val name:String, val resVector: ImageVector)
data class HomeImageResourceItem(val name:String, val resVector: Int, val resVectorSelect: Int, val targetString: String)

val bloomBannerList = listOf(
		HomeImageItem("Chic Mao",   R.drawable.a_pic),
		HomeImageItem("Tiny Mao",   R.drawable.b_pic),
		HomeImageItem("Jungle Mao", R.drawable.c_pic),
		HomeImageItem("Chic Mao",   R.drawable.d_pic),
		HomeImageItem("Tiny Mao",   R.drawable.a_pic),
		HomeImageItem("Jungle Mao", R.drawable.b_pic),
		HomeImageItem("Chic Mao",   R.drawable.c_pic),
		HomeImageItem("Tiny Mao",   R.drawable.d_pic),
		HomeImageItem("Jungle Mao", R.drawable.a_pic),
)

val bloomInfoList = listOf(
		HomeImageItem("Chic Mao",   R.drawable.a_pic),
		HomeImageItem("Tiny Mao",   R.drawable.b_pic),
		HomeImageItem("Jungle Mao", R.drawable.c_pic),
		HomeImageItem("Chic Mao",   R.drawable.d_pic),
		HomeImageItem("Tiny Mao",   R.drawable.a_pic),
		HomeImageItem("Jungle Mao", R.drawable.b_pic),
		HomeImageItem("Chic Mao",   R.drawable.c_pic),
		HomeImageItem("Tiny Mao",   R.drawable.d_pic),
		HomeImageItem("Jungle Mao", R.drawable.a_pic),

		)

val navList = listOf(
		HomeImageResourceItem("首页",   R.drawable.shop,      R.drawable.shop_d,       S.NAV_HomePage),
		HomeImageResourceItem("分类",   R.drawable.category,  R.drawable.category_d,   S.NAV_Classification),
		HomeImageResourceItem("灵感",   R.drawable.idea,      R.drawable.idea_d,       S.NAV_Idea),
		HomeImageResourceItem("购物袋", R.drawable.shop_cart, R.drawable.shop_cart_d,  S.NAV_Cart),
		HomeImageResourceItem("我的",   R.drawable.person,    R.drawable.persion_d,    S.NAV_Person),
)


