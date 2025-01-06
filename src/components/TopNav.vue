<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 12:35:00
 * @Description  : 顶部导航栏
-->
<script setup lang="ts">
import { useRouter } from 'vue-router'

defineProps<{
  title: string
  showBack?: boolean
}>()

const router = useRouter()

const handleBack = () => {
  router.back()
}
</script>

<template>
  <n-layout-header class="top-nav flex items-center justify-between p-4">
    <div v-if="showBack" class="cursor-pointer" @click="handleBack">
      <n-icon><arrow-back /></n-icon>
    </div>
    <h1 class="text-lg font-bold flex-1 text-center">{{ title }}</h1>
  </n-layout-header>
</template>

<style scoped>
.top-nav {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 100;
  background: #fff;
  box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}
</style> 