<script setup lang="ts">
import { ref, onMounted, onUnmounted, computed, reactive } from 'vue'
import inductor from '@/assets/circuit/inductor.svg';
import mosfet from '@/assets/circuit/mosfet.svg';
import capacitor from '@/assets/circuit/capacitor.svg';
import end_vcc from '@/assets/circuit/end_vcc.svg';
import end from '@/assets/circuit/end.svg';
import t_line from '@/assets/circuit/t_line.svg';
import h_line from '@/assets/circuit/h_line.svg';

// 定义可交互的元件类型
const interactiveComponents = ['end_vcc', 'inductor']

// 定义电路元件类型
interface CircuitItem {
  component: any
  class?: string
  transform?: string
  interactive?: boolean // 新增标记是否可交互
}

// 电路图尺寸计算
const BASE_WIDTH = 336 // 基准宽度
const BASE_ICON_SIZE = 48 // 基准图标大小
const buck_circuit = ref<HTMLElement | null>(null)
const containerWidth = ref(BASE_WIDTH)

// 计算图标大小
const iconSize = computed(() => {
  return Math.floor((containerWidth.value / 7)) // 7是网格列数
})

// 计算位移距离
const translateX = computed(() => {
  return -iconSize.value / 4 // 位移为图标大小的1/4
})

// 监听容器大小变化
const updateSize = () => {
  if (buck_circuit.value) {
    const parentWidth = buck_circuit.value.parentElement?.clientWidth || BASE_WIDTH
    containerWidth.value = Math.min(parentWidth - 32, BASE_WIDTH) // 32是左右padding
  }
}

onMounted(() => {
  updateSize()
  window.addEventListener('resize', updateSize)
})

onUnmounted(() => {
  window.removeEventListener('resize', updateSize)
})

// 定义电路布局数据
const circuitLayout: CircuitItem[][] = [
  [
    { component: end_vcc, class: 'h-flip', interactive: true },
    { component: t_line },
    { component: mosfet, class: 'mid-right-rot', interactive: true },
    { component: t_line },
    { component: inductor, interactive: true },
    { component: t_line },
    { component: end_vcc, interactive: true }
  ],
  [
    { component: null },
    { component: capacitor },
    { component: null },
    { component: mosfet, class: 'mid', interactive: true },
    { component: null },
    { component: capacitor },
    { component: null }
  ],
  [
    { component: end, class: 'h-flip' },
    { component: t_line, class: 'v-flip' },
    { component: h_line },
    { component: t_line, class: 'v-flip' },
    { component: h_line },
    { component: t_line, class: 'v-flip' },
    { component: end }
  ]
]

// 根据类名生成样式
const getItemStyle = (className?: string) => {
  if (className?.includes('mid-right-rot')) {
    return {
      transform: `rotate(-90deg) translateX(${translateX.value}px)`
    }
  }
  if (className?.includes('mid')) {
    return {
      transform: `translateX(${translateX.value}px)`
    }
  }
  return {}
}

// 参数输入相关
interface Parameter {
  value: string | number
  placeholder: string
  label: string
  unit: string
}

const parameters = reactive({
  inputVoltage: {
    value: '',
    placeholder: '例如: 12',
    label: '输入电压',
    unit: 'V'
  },
  outputVoltage: {
    value: '',
    placeholder: '例如: 5',
    label: '输出电压',
    unit: 'V'
  },
  loadCurrent: {
    value: '',
    placeholder: '例如: 1',
    label: '负载电流',
    unit: 'A'
  },
  switchFreq: {
    value: '',
    placeholder: '例如: 100',
    label: '开关频率',
    unit: 'kHz'
  }
})

// 判断是否是可交互元件
const isInteractive = (item: CircuitItem) => {
  return item.interactive
}

// 添加选中状态管理
const selectedComponent = ref<string | null>(null) // 只允许一个选中

// 处理元件点击
const handleComponentClick = (item: CircuitItem, rowIndex: number, colIndex: number) => {
  if (!item.interactive) return
  
  const componentId = `${rowIndex}-${colIndex}`
  // 如果当前选中的是同一个元件，则取消选中
  if (selectedComponent.value === componentId) {
    selectedComponent.value = null
  } else {
    selectedComponent.value = componentId // 选中新的元件
  }
}

// 判断元件是否被选中
const isSelected = (rowIndex: number, colIndex: number) => {
  return selectedComponent.value === `${rowIndex}-${colIndex}`
}

</script>

<template>
  <div class="buck-inductor-calculator">
    <n-card title="Buck电路" hoverable class="adaptive-card">
      <div ref="buck_circuit"
           class="flex flex-col justify-center items-center"
           :style="{
             width: `${containerWidth}px`,
             transformOrigin: 'top left'
           }"
      >
        <n-grid x-gap="0" y-gap="0" :cols="7" item-responsive>
          <template v-for="(row, rowIndex) in circuitLayout" :key="rowIndex">
            <n-gi v-for="(item, colIndex) in row" :key="`${rowIndex}-${colIndex}`">
              <n-icon 
                v-if="item.component" 
                :size="iconSize"
                :class="[isInteractive(item) && 'interactive-component', isSelected(rowIndex, colIndex) && 'selected']"
                @click="handleComponentClick(item, rowIndex, colIndex)"
              >
                <component 
                  :is="item.component" 
                  class="circuit-item" 
                  :class="[item.class, isInteractive(item) && 'interactive', isSelected(rowIndex, colIndex) && 'selected-component']"
                  :style="getItemStyle(item.class)" 
                />
              </n-icon>
            </n-gi>
          </template>
        </n-grid>
      </div>
    </n-card>

    <n-card title="参数输入" class="mt-16" hoverable>
      <div class="parameters-grid">
        <div v-for="(param, key) in parameters" 
             :key="key" 
             class="parameter-item"
        >
          <div class="param-label">{{ param.label }} ({{ param.unit }})</div>
          <n-input
            v-model:value="param.value"
            :placeholder="param.placeholder"
            type="text"
            class="param-input"
          />
        </div>
      </div>
    </n-card>
  </div>
</template>

<style scoped>
.buck-inductor-calculator {
  padding: 16px;
}

.circuit-item {
  margin-bottom: -8px;
}

.left-rot {
  transform: rotate(90deg);
}

.right-rot {
  transform: rotate(-90deg);
}

.h-flip {
  transform: scaleX(-1);
}

.v-flip {
  transform: scaleY(-1);
}

/* 参数输入面板样式 */
.parameters-grid {
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 16px;
  padding: 8px 0;
}

.parameter-item {
  display: flex;
  flex-direction: column;
  gap: 8px;
}

.param-label {
  font-size: 14px;
  color: var(--text-secondary);
}

.param-input {
  width: 100%;
}

/* 响应式布局 */
@media (max-width: 340px) {
  .parameters-grid {
    grid-template-columns: 1fr;
  }
}

/* 可交互元件的基础样式 */
.interactive-component {
  cursor: pointer;
  transition: all 0.3s cubic-bezier(0.4, 0, 0.2, 1);
  position: relative;
  color: var(--text-primary);
}

/* 悬停效果 */
.interactive-component:hover {
  transform: scale(1.05);
  color: var(--primary-color, #189BA0);
}

.interactive-component:hover::before {
  content: '';
  position: absolute;
  top: 50%;
  left: 50%;
  width: 100%;
  height: 100%;
  transform: translate(-50%, -50%);
  background: radial-gradient(
    circle at center,
    var(--primary-color-hover, rgba(24, 155, 160, 0.1)) 0%,
    transparent 70%
  );
  border-radius: 50%;
  z-index: -1;
  opacity: 0;
  animation: glow 0.3s ease-out forwards;
}

/* 选中状态 */
.interactive-component.selected {
  transform: scale(1.08); /* 选中时略微放大 */
  color: var(--primary-color, #189BA0);
}

.interactive-component.selected::before {
  content: '';
  position: absolute;
  top: 50%;
  left: 50%;
  width: 140%;
  height: 140%;
  transform: translate(-50%, -50%);
  background: radial-gradient(
    circle at center,
    var(--primary-color-hover, rgba(24, 155, 160, 0.15)) 0%,
    transparent 70%
  );
  border-radius: 50%;
  z-index: -1;
  opacity: 1;
  box-shadow: 0 0 12px rgba(24, 155, 160, 0.2);
}

/* 按压效果 */
.interactive-component:active {
  transform: scale(1.12);
  color: var(--primary-color-pressed, #0C647A);
}

.interactive-component:active::before {
  background: radial-gradient(
    circle at center,
    var(--primary-color-pressed, rgba(24, 155, 160, 0.25)) 0%,
    transparent 70%
  );
  animation: glow-press 0.15s ease-out forwards;
}

/* 光晕动画 */
@keyframes glow {
  from {
    opacity: 0;
    width: 80%;
    height: 80%;
  }
  to {
    opacity: 1;
    width: 140%;
    height: 140%;
  }
}

@keyframes glow-press {
  from {
    opacity: 0;
    width: 100%;
    height: 100%;
  }
  to {
    opacity: 1;
    width: 160%;
    height: 160%;
  }
}

/* 暗色模式适配 */
@media (prefers-color-scheme: dark) {
  .interactive-component {
    color: var(--text-primary);
  }

  .interactive-component:hover,
  .interactive-component.selected {
    color: var(--primary-color, #189BA0);
  }

  .interactive-component.selected::before {
    box-shadow: 0 0 16px rgba(24, 155, 160, 0.3);
  }

  .interactive-component:hover::before {
    background: radial-gradient(
      circle at center,
      var(--primary-color-hover, rgba(24, 155, 160, 0.2)) 0%,
      transparent 70%
    );
  }

  .interactive-component:active::before {
    background: radial-gradient(
      circle at center,
      var(--primary-color-pressed, rgba(24, 155, 160, 0.3)) 0%,
      transparent 70%
    );
  }
}
</style> 