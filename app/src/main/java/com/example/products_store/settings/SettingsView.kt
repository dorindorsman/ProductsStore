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
import com.example.products_store.data.models.AppLanguage
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
            currentLanguage = viewModel.getLanguage(),
            onClick = { language ->
                viewModel.handle(SettingsEvent.UpdateLanguage(language))
            }
        )
    }
}

@Composable
fun ThemeRadioButton(onThemeChange: (AppTheme) -> Unit, theme: AppTheme) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )  {
        Text(stringResource(id = R.string.theme))
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
fun LanguagePreference(onClick: (AppLanguage) -> Unit, currentLanguage: AppLanguage) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(stringResource(id = R.string.language))
        Row {
            Button(onClick = { onClick(AppLanguage.English) }) {
                Text(
                    text = stringResource(id = R.string.english),
                    color = if (currentLanguage == AppLanguage.English) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.onPrimary
                    )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { onClick(AppLanguage.Hebrew) }) {
                Text(
                    text = stringResource(id = R.string.hebrew),
                    color = if (currentLanguage == AppLanguage.Hebrew) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.onPrimary
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { onClick(AppLanguage.System) }) {
                Text(
                    text = stringResource(id = R.string.system),
                    color = if (currentLanguage == AppLanguage.System) MaterialTheme.colors.secondaryVariant else MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}