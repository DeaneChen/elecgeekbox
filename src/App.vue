<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-05 17:14:15
 * @LastEditTime : 2025-01-06 21:20:37
 * @Description  : 应用入口
-->
<script setup lang="ts">
import PageTransition from './components/PageTransition.vue'
</script>

<template>
  <n-config-provider>
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