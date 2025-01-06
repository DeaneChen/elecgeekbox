<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 20:13:53
 * @LastEditTime : 2025-01-06 23:27:31
 * @LastEditors  : LuHeQiu
 * @Description  : 
 * @FilePath     : /elecgeekbox/src/pages/tools/index.vue
 * @HomePage     : https://www.luheqiu.com
-->
<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-05 22:55:59
 * @LastEditTime : 2025-01-06 13:21:11
 * @LastEditors  : LuHeQiu
 * @Description  : 主页
 * @FilePath     : /elecgeekbox/src/pages/home/index.vue
 * @HomePage     : https://www.luheqiu.com
-->
<script setup lang="ts">
import { NGrid, NGridItem } from 'naive-ui'
import { useRouter } from 'vue-router'
import { ManualGearbox } from '@vicons/tabler'

import { Component } from 'vue'

interface Tool {
  id: string
  name: string
  icon: string | Component
  route: string
}

const tools: Tool[] = [
  {
    id: 'buck-inductor',
    name: "Buck\n电感计算器",
    icon: ManualGearbox, // 临时使用emoji，后续可替换为实际图标
    route: '/tools/buck-inductor'
  }
  // 后续可以继续添加更多工具
]

const router = useRouter()

const handleToolClick = (tool: Tool) => {
  router.push(tool.route)
}
</script>

<template>
  <div class="tools-container p-4">
    <NGrid :x-gap="12" :y-gap="12" cols="3">
      <NGridItem v-for="tool in tools" :key="tool.id">
        <div
          class="flex flex-col items-center justify-center tool-item "
          @click="handleToolClick(tool)"
        >
          <n-icon class="p-4" size="24">
            <component :is="tool.icon" />
          </n-icon>
          <div class="p-4 tool-name">{{ tool.name }}</div>
        </div>
      </NGridItem>
    </NGrid>
  </div>
</template>

<style scoped>
.tools-container {
  height: 98%;
  overflow-y: auto;
}

.tool-item {
  padding: 0.5rem;
  border: 2px solid #fff;
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.3s ease;
  aspect-ratio: 1 / 1;
}

.tool-item:hover {
  background-color: rgba(0, 0, 0, 0.05);
  transform: translateY(-2px);
}

.tool-item:active {
  transform: scale(0.98);
}

.tool-name {
  font-size: 14px;
  color: var(--text-color);
  white-space: pre-line;
  text-align: center;
}

:root {
  --border-color: #eee;
  --text-color: #333;
}

/* 暗色模式 */
@media (prefers-color-scheme: dark) {
  :root {
    --border-color: #333;
    --text-color: #fff;
  }
}
</style> 