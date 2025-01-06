<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-05 17:14:15
 * @LastEditTime : 2025-01-07 02:12:36
 * @Description  : 应用入口
-->
<script setup lang="ts">
import PageTransition from './components/PageTransition.vue'
import { darkTheme, useOsTheme } from 'naive-ui'
import { computed } from 'vue'
// 使用 useOsTheme 获取操作系统主题
const osThemeRef = useOsTheme()
// 计算属性，根据操作系统主题返回对应的 naive-ui 主题
const theme = computed(() => (osThemeRef.value === 'dark' ? darkTheme : null))
</script>

<template>
  <n-config-provider :theme="theme">
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