<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 12:35:00
 * @Description  : 底部导航栏
-->
<script setup lang="ts">
import { useRouter, useRoute } from 'vue-router'

const router = useRouter()
const route = useRoute()

const navItems = [
  { path: '/home', label: '首页' },
  { path: '/tools', label: '工具' },
  { path: '/settings', label: '设置' }
]
</script>

<template>
  <n-layout-footer class="bottom-nav flex justify-around p-4">
    <div
      v-for="item in navItems"
      :key="item.path"
      class="cursor-pointer"
      :class="{ 'text-primary': route.path === item.path }"
      @click="router.push(item.path)"
    >
      {{ item.label }}
    </div>
  </n-layout-footer>
</template>

<style scoped>
.bottom-nav {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 100;
  background: #fff;
  box-shadow: 0 -2px 4px rgba(0,0,0,0.1);
}
</style> 