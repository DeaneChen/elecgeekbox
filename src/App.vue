<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-05 17:14:15
 * @LastEditTime : 2025-01-09 19:53:15
 * @Description  : 应用入口
-->
<script setup lang="ts">
import PageTransition from './components/PageTransition.vue'
import { darkTheme, useOsTheme, GlobalThemeOverrides } from 'naive-ui'
import { computed } from 'vue'
// 使用 useOsTheme 获取操作系统主题
const osThemeRef = useOsTheme()
// 计算属性，根据操作系统主题返回对应的 naive-ui 主题
const theme = computed(() => (osThemeRef.value === 'dark' ? darkTheme : null))

const themeOverrides: GlobalThemeOverrides = {
    "common": {
    "primaryColor": "#189BA0FF",
    "primaryColorHover": "#36ADA9FF",
    "primaryColorPressed": "#0C647AFF",
    "primaryColorSuppl": "#368DADFF"
  }
}

</script>

<template>
  <n-config-provider :theme="theme" :theme-overrides="themeOverrides">
    <n-layout class="app-container">
      <PageTransition />
    </n-layout>
  </n-config-provider>
</template>

<style>
.app-container {
  height: 100vh;
  width: 100vw;
  position: fixed;
  top: 0;
  left: 0;
  overflow: hidden;
}
</style>