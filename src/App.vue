<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-05 17:14:15
 * @LastEditTime : 2025-01-06 13:35:00
 * @Description  : 应用入口
-->
<script setup lang="ts">
</script>

<template>
  <n-config-provider>
    <n-layout class="app-container">
      <router-view></router-view>
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