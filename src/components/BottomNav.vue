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

// 判断当前路由是否匹配导航项
const isActive = (path: string) => {
  return route.path === path || route.path.startsWith(path + '/')
}
</script>

<template>
  <n-layout-footer class="bottom-nav flex justify-around p-16">
    <div
      v-for="item in navItems"
      :key="item.path"
      class="nav-item flex flex-col items-center flex-1 cursor-pointer"
      :class="{ 'active': isActive(item.path) }"
      @click="router.push(item.path)"
    >
      <div class="icon-wrapper">
        <n-icon size="24">
          <component :is="item.icon" />
        </n-icon>
      </div>
      <span class="mt-2 label">{{ item.label }}</span>
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
  background: rgba(255, 255, 255, 0.95);
  backdrop-filter: blur(10px);
  box-shadow: 0 -1px 0 rgba(0, 0, 0, 0.05);
}

.nav-item {
  position: relative;
  padding: 8px 0;
  transition: all 0.3s ease;
  color: var(--nav-color, #666);
}

.icon-wrapper {
  position: relative;
  z-index: 1;
}

.nav-item.active {
  color: var(--primary-color, #2080f0);
}

/* 光晕基础样式 */
.nav-item::before {
  content: '';
  position: absolute;
  top: 50%;
  left: 50%;
  width: 48px;
  height: 48px;
  border-radius: 50%;
  transform: translate(-52%, -48%) scale(0.6);
  opacity: 0;
  background: radial-gradient(
    circle at 45% 55%,
    var(--primary-glow, rgba(32, 128, 240, 0.2)) 20%,
    var(--primary-glow-outer, rgba(32, 128, 240, 0.05)) 60%,
    transparent 100%
  );
  filter: blur(2px);
  transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
}

/* 激活状态的光晕效果 */
.nav-item.active::before {
  opacity: 1;
  transform: translate(-52%, -48%) scale(1);
}

.label {
  font-size: 12px;
  transition: color 0.3s ease;
}

/* 暗色模式适配 */
@media (prefers-color-scheme: dark) {
  .bottom-nav {
    background: rgba(24, 24, 28, 0.95);
    box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.05);
  }

  .nav-item {
    --nav-color: #999;
    --primary-glow: rgba(32, 128, 240, 0.25);
    --primary-glow-outer: rgba(32, 128, 240, 0.08);
  }
}

/* 悬停效果 */
.nav-item:hover::before {
  opacity: 0.5;
  transform: translate(-52%, -48%) scale(0.8);
}

/* 点击效果 */
.nav-item:active::before {
  opacity: 0.7;
  transform: translate(-52%, -48%) scale(0.9);
}
</style> 