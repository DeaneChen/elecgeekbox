package com.luheqiu.elecgeekbox

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : TauriActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        // Allow content to extend under the system bars
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Get the insets controller to manage system UI
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)

        // Ensure the status bar is fully transparent
        window.statusBarColor = android.graphics.Color.TRANSPARENT
    }
}