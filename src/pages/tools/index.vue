<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 20:13:53
 * @LastEditTime : 2025-01-07 22:45:30
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

// import gsap from 'gsap'

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

const handleToolClick = (tool: Tool, _index: number) => {

  // const card = document.querySelectorAll('.tool-item')[index]
  // const rect = card.getBoundingClientRect()
  // gsap.to(card, {
  //       width: '150vw',
  //       height: '150vh',
  //       position: 'fixed',
  //       // top: 0,
  //       // left: 0,
  //       x: - rect.left-8, // 居中
  //       y: - rect.top-8, // 居中
  //       zIndex: 999,
  //       duration: 0.8,
  //       ease: "power3.inout",
  //       onComplete: () => {
  //         // 动画完成后跳转
  //         setTimeout(() => {
  //           router.push(tool.route)
  //         }, 0.6);
  //       },
  //       onUpdate: () => {
  //         // 在动画进行到一半时执行跳转
  //         // if (parseFloat(gsap.getProperty(card,'x') as string) <= (-rect.left-8)*0.99) { // 判断动画进度
  //         //   router.push(tool.route)
  //         // }
  //       }
        
  //     })
  router.push(tool.route)
}
</script>

<template>
  <div class="tools-container px-8 py-16">
    <NGrid :x-gap="12" :y-gap="12" cols="3">
      <NGridItem v-for="(tool,index) in tools" :key="tool.id">
        <div
          class="flex flex-col items-center justify-center tool-item "
          @click="handleToolClick(tool,index)"
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
  height: 94%;
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