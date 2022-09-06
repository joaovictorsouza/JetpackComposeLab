/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package br.eng.joaovictor.assistant.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import br.eng.joaovictor.assistant.presentation.theme.AssistantTheme
import br.eng.joaovictor.assistant.presentation.ui.home.HomeScreen
import br.eng.joaovictor.assistant.presentation.ui.sleep_charge.SleepChargeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp() {
    val navController = rememberSwipeDismissableNavController()

    AssistantTheme {
        SwipeDismissableNavHost(
            navController = navController,
            startDestination = "home_screen"
        ){
            composable("home_screen"){
                HomeScreen(onClickParams = { navController.navigate("sleep_charge") })
            }
            composable("sleep_charge"){
                SleepChargeScreen()
            }
        }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}