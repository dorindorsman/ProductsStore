import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.products_store.R
import com.example.products_store.settings.SettingsViewModel
import com.example.products_store.settings.AppTheme

@Composable
fun SettingsView(viewModel: SettingsViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") }
            )
        }
    ) { padding ->
        SettingsContent(padding = padding, viewModel = viewModel)
    }
}

@Composable
fun SettingsContent(padding: PaddingValues, viewModel: SettingsViewModel) {
    Column(modifier = Modifier
        .padding(padding)
        .fillMaxWidth()) {
        ThemeRadioButton(
            isDarkTheme = viewModel.themeRepository.isDarkTheme,
            onThemeChange =  { isDarkTheme ->
                //ThemeRepository.onThemeChange(isDarkTheme = isDarkTheme)
            }
        )
        LanguagePreference(
            currentLanguage = viewModel.currentLanguage.value ?: "English",
            onLanguageSelected = {
             //   viewModel.setLanguage(it)
            }
        )
        Button(
            onClick = {
              //  viewModel.logOut()
                      },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Log Out")
        }
    }
}

@Composable
fun ThemeRadioButton(onThemeChange: @Composable (AppTheme?) -> Unit, isDarkTheme: AppTheme) {
    Column {
        LabeledRadioButton(
            label = stringResource(id = R.string.light),
            selected = AppTheme.Light == isDarkTheme,
            onClick =  {
                AppTheme.Light
            }
        )
        LabeledRadioButton(
            label =  stringResource(id = R.string.dark),
            selected = AppTheme.Dark == isDarkTheme,
            onClick = {
                AppTheme.Dark
            }
        )
        LabeledRadioButton(
            label = stringResource(id = R.string.system),
            selected = AppTheme.System == isDarkTheme,
            onClick = {
                AppTheme.System
            }
        )
    }
}

@Composable
fun LabeledRadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    label: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick
        )
        Text(label)
    }
}

@Composable
fun LanguagePreference(currentLanguage: String, onLanguageSelected: (String) -> Unit) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Text("Language")
        Row {
            Button(onClick = { onLanguageSelected("English") }) {
                Text("English", color = if (currentLanguage == "English") MaterialTheme.colors.primary else MaterialTheme.colors.onSurface)
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { onLanguageSelected("Hebrew") }) {
                Text("Hebrew", color = if (currentLanguage == "Hebrew") MaterialTheme.colors.primary else MaterialTheme.colors.onSurface)
            }
        }
    }
}