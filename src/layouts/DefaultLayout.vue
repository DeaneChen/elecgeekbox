<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 12:35:00
 * @Description  : 默认布局(含底部导航)
-->
<script setup lang="ts">
import TopNav from '../components/TopNav.vue'
import BottomNav from '../components/BottomNav.vue'
import { useRoute } from 'vue-router'

const route = useRoute()
</script>

<template>
  <div class="flex flex-col h-full">
    <TopNav :title="route.meta.title as string" />
    <main class="flex-1 overflow-auto main-content">
      <router-view></router-view>
    </main>
    <BottomNav />
  </div>
</template>

<style scoped>
.main-content {
  margin-top: 56px; /* 顶部导航栏高度 */
  margin-bottom: 60px; /* 底部导航栏高度 */
  overflow-y: auto;
}
</style> 