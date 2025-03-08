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
import android.content.res.Configuration

class MainActivity : TauriActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 初始化时立即应用主题
        updateStatusBarByTheme(resources.configuration)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updateStatusBarByTheme(newConfig)
    }

    private fun updateStatusBarByTheme(config: Configuration) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val isDarkMode = config.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
            
            if (isDarkMode) {
                // 夜间模式：深色背景，白色图标
                window.statusBarColor = Color.parseColor("#18171C")
                window.decorView.systemUiVisibility = 0 // 重置为默认状态（白色图标）
            } else {
                // 日间模式：白色背景，黑色图标
                window.statusBarColor = Color.WHITE
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
        }
    }
}