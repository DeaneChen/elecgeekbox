<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 12:35:00
 * @Description  : 页面布局(仅顶部导航)
-->
<script setup lang="ts">
import TopNav from '../components/TopNav.vue'
import { useRoute } from 'vue-router'

const route = useRoute()
</script>

<template>
  <div class="flex flex-col h-full">
    <TopNav :title="route.meta.title as string" :showBack="true" />
    <main class="flex-1 main-content">
      <router-view></router-view>
    </main>
  </div>
</template> 


<style scoped>
.main-content {
  margin-top: 44.8px;
  /* margin-bottom: 73.2px; */
  overflow-y: auto;
  background-color: var(--bg-primary);
}
</style> 