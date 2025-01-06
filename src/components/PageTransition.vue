<script setup lang="ts">
import { RouteLocationNormalized } from 'vue-router'
import { Component } from 'vue'

// 判断是否是详情页面（使用 PageLayout 的页面）
const isDetailPage = (path: string) => {
  return path.startsWith('/tools/') || path === '/detail'
}

// 根据路由变化决定动画方向
const getTransitionName = (to: string, from: string) => {
  const toIsDetail = isDetailPage(to)
  const fromIsDetail = isDetailPage(from)

  if (!fromIsDetail && toIsDetail) return 'slide-left'
  if (fromIsDetail && !toIsDetail) return 'slide-right'
  return 'none'
}
</script>

<template>
  <router-view v-slot="{ Component, route }: { Component: Component, route: RouteLocationNormalized }">
    <transition
      :name="getTransitionName(route.path, route.meta.previousRoute?.path || '')"
    >
       <component class="page-wrapper" :is="Component" />
    </transition>
  </router-view>
</template>

<style scoped>

.page-wrapper {
  position: absolute;
  width: 100%;
  height: 100%;
}

/* 右侧滑入动画 */
.slide-left-enter-active,
.slide-left-leave-active,
.slide-right-enter-active,
.slide-right-leave-active {
  transition: all 0.4s ease-out;
}

.slide-left-enter-from {
  transform: translateX(100%);
  opacity: 0.25;
  box-shadow: -3px 0px 10px -2px rgba(0, 0, 0, 0.15)
}

.slide-left-enter-active {
  z-index: 1;
  box-shadow: -3px 0px 10px -2px rgba(0, 0, 0, 0.15)
}

.slide-left-leave-to {
  transform: translateX(-100%);
  opacity: 0;
}

.slide-right-enter-from {
  transform: translateX(-100%);
  opacity: 0;
}

.slide-right-leave-to {
  transform: translateX(100%);
  opacity: 0;
}

/* 无动画 */
.none-enter-active,
.none-leave-active {
  transition: none;
}
</style> 