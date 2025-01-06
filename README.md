# ElecGeekBox - 电子极客工具箱

一款为电子开发工程师打造的跨平台工具集成应用。基于 Tauri + Vue 3 + TypeScript 开发，专注于提供简洁、高效的开发辅助工具。

## ✨ 特性

- 🛠 集成多种电子开发常用工具
- 📱 移动优先的响应式设计
- ⚡️ 基于 Rust 的高性能后端
- 🎨 简洁优雅的用户界面
- 🔒 安全可靠的本地运行环境

## 🚀 技术栈

- Tauri 2.0
- Vue 3 + TypeScript
- Naive UI
- Vite
- SCSS

## 🔧 开发环境设置

安装依赖
```bash
npm install
``` 
启动开发服务器
```bash
npm run tauri android dev
```
构建生产版本
```bash
npm run tauri android build -- --aab --target aarch64
```


## 📝 许可证

[GNU General Public License v3.0]

---
*本项目由 AI 辅助开发，致力于提供更好的开发体验。*


# Original Content


## Tauri + Vue + TypeScript

This template should help get you started developing with Vue 3 and TypeScript in Vite. The template uses Vue 3 `<script setup>` SFCs, check out the [script setup docs](https://v3.vuejs.org/api/sfc-script-setup.html#sfc-script-setup) to learn more.

### Recommended IDE Setup

- [VS Code](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) + [Tauri](https://marketplace.visualstudio.com/items?itemName=tauri-apps.tauri-vscode) + [rust-analyzer](https://marketplace.visualstudio.com/items?itemName=rust-lang.rust-analyzer)

### Type Support For `.vue` Imports in TS

Since TypeScript cannot handle type information for `.vue` imports, they are shimmed to be a generic Vue component type by default. In most cases this is fine if you don't really care about component prop types outside of templates. However, if you wish to get actual prop types in `.vue` imports (for example to get props validation when using manual `h(...)` calls), you can enable Volar's Take Over mode by following these steps:

1. Run `Extensions: Show Built-in Extensions` from VS Code's command palette, look for `TypeScript and JavaScript Language Features`, then right click and select `Disable (Workspace)`. By default, Take Over mode will enable itself if the default TypeScript extension is disabled.
2. Reload the VS Code window by running `Developer: Reload Window` from the command palette.

You can learn more about Take Over mode [here](https://github.com/johnsoncodehk/volar/discussions/471).
