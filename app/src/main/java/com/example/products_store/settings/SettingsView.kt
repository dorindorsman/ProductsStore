import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.products_store.R
import com.example.products_store.settings.SettingsViewModel
import com.example.products_store.data.models.AppTheme
import com.example.products_store.settings.SettingsEvent

@Composable
fun SettingsView(viewModel: SettingsViewModel) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        ThemeRadioButton(
            theme = viewModel.getTheme(),
            onThemeChange = { theme ->
                viewModel.handle(SettingsEvent.UpdateTheme(theme))
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
fun ThemeRadioButton(onThemeChange: (AppTheme) -> Unit, theme: AppTheme) {
    Column {
        Text("Theme")
        LabeledRadioButton(
            label = stringResource(id = R.string.light),
            selected = AppTheme.Light == theme,
            onClick = { onThemeChange(AppTheme.Light) }
        )
        LabeledRadioButton(
            label = stringResource(id = R.string.dark),
            selected = AppTheme.Dark == theme,
            onClick = { onThemeChange(AppTheme.Dark) }
        )
        LabeledRadioButton(
            label = stringResource(id = R.string.system),
            selected = AppTheme.System == theme,
            onClick =  { onThemeChange(AppTheme.System) }
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
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
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