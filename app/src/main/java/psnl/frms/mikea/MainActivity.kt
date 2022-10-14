package psnl.frms.mikea

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlin.concurrent.thread
import psnl.frms.mikea.activitys.Classification
import psnl.frms.mikea.activitys.MainHome
import psnl.frms.mikea.components.HomePage
import psnl.frms.mikea.components.LoginPage
import psnl.frms.mikea.components.WelcomePage
import psnl.frms.mikea.theme.IKEATheme
import psnl.frms.mikea.theme.IKEATheme
import psnl.frms.mikea.theme.IKEA_Yellow
import psnl.frms.mikea.theme.white
import psnl.frms.mikea.utils.S

class MainActivity : ComponentActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)


		setContent {
			IKEATheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize())
				{
					val systemUiController = rememberSystemUiController()

					SideEffect {
						// 系统字体颜色
						systemUiController.statusBarDarkContentEnabled = false
						systemUiController.setSystemBarsColor(color = white)
					}

					MainHome(systemUiController)
				}
			}
		}
	}
}