<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 12:35:00
 * @Description  : 底部导航栏
-->
<script setup lang="ts">
import { useRouter, useRoute } from 'vue-router'
import { SmartHome, Apps, Settings } from '@vicons/tabler'

const router = useRouter()
const route = useRoute()

const navItems = [
  { path: '/tools', label: '工具', icon: Apps },
  { path: '/home', label: '首页', icon: SmartHome },
  { path: '/settings', label: '设置', icon: Settings }
]
</script>

<template>
  <n-layout-footer class="bottom-nav flex justify-around p-16">
    <div
      v-for="item in navItems"
      :key="item.path"
      class="nav-item flex flex-col items-center flex-1 cursor-pointer"
      :class="{ 'text-primary': route.path === item.path }"
      @click="router.push(item.path)"
    >
      <n-icon size="24">
        <component :is="item.icon" />
      </n-icon>
      <span class="mt-2">{{ item.label }}</span>
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

.nav-item {
  transition: color 0.3s;
}
</style> 