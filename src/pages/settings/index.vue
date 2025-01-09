<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-05 22:55:59
 * @LastEditTime : 2025-01-09 19:49:44
 * @LastEditors  : LuHeQiu
 * @Description  : 主页
 * @FilePath     : /elecgeekbox/src/pages/settings/index.vue
 * @HomePage     : https://www.luheqiu.com
-->

<template>
  <div class="flex items-center justify-center h-full">
    <n-config-provider :theme="theme">
      <n-card> 当前操作系统的主题是 {{ osTheme }}。 </n-card>
    </n-config-provider>
  </div>
</template>

<script setup lang="ts">
import { darkTheme, useOsTheme } from 'naive-ui'
import { computed } from 'vue'
// 使用 useOsTheme 获取操作系统主题
const osThemeRef = useOsTheme()
// 计算属性，根据操作系统主题返回对应的 naive-ui 主题
const theme = computed(() => (osThemeRef.value === 'dark' ? darkTheme : null))
// 直接暴露 osThemeRef 到模板中
const osTheme = osThemeRef
</script>

<style scoped>
h1 {
  color: #333;
}
</style> 