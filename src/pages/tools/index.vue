<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 20:13:53
 * @LastEditTime : 2025-01-07 01:53:01
 * @LastEditors  : LuHeQiu
 * @Description  : 
 * @FilePath     : /elecgeekbox/src/pages/tools/index.vue
 * @HomePage     : https://www.luheqiu.com
-->
<script setup lang="ts">
import { NGrid, NGridItem } from 'naive-ui'
import { useRouter } from 'vue-router'
import { ManualGearbox } from '@vicons/tabler'

import { DefineComponent } from 'vue'

interface Tool {
  id: string
  name: string
  icon: string | DefineComponent<{}, {}, any>
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
  <div class="tools-container px-8 py-16">
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
  height: 97%;
  overflow-y: auto;
}

.tool-item {
  padding: 0.5rem;
  border: 1px solid var(--border-color);
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.2s ease;
  aspect-ratio: 1 / 1;
  background-color: var(--bg-secondary);
}

.tool-item:hover {
  background-color: var(--bg-secondary);
  transform: translateY(-2px);
  box-shadow: 0 2px 8px var(--shadow-color);
}

.tool-item:active {
  transform: scale(0.95);
}

.tool-name {
  font-size: 14px;
  color: var(--text-primary);
  white-space: pre-line;
  text-align: center;
}
</style> 