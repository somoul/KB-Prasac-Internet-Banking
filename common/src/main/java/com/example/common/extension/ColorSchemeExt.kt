package com.example.common.extension

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import com.example.common.ui.theme.colorBackgroundPrimary
import com.example.common.ui.theme.colorError
import com.example.common.ui.theme.colorSuccessful

val ColorScheme.mbBackground get() = colorBackgroundPrimary
val ColorScheme.mbPrimary get() = primary
val ColorScheme.mbPrimaryContain get() = primaryContainer
val ColorScheme.mbSecondary get() = secondary
val ColorScheme.mbSecondaryContainer get() = secondaryContainer
val ColorScheme.mbColorSuccessful get() = colorSuccessful
val ColorScheme.mbColorError get() = colorError
