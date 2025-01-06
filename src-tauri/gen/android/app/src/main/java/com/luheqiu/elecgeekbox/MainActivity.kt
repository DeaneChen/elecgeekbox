package com.luheqiu.elecgeekbox

import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.graphics.Color

class MainActivity : TauriActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Set the status bar color
            window.setStatusBarColor( Color.WHITE) 

            // // Allow content to extend under the system bars
            // WindowCompat.setDecorFitsSystemWindows(window, false);

            // // Get the insets controller to manage system UI
            // val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView);

            // // Ensure the status bar is fully transparent
            // window.statusBarColor = android.graphics.Color.TRANSPARENT;
        }

         // 设置状态栏图标为黑色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val decorView: View = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }

    }
}