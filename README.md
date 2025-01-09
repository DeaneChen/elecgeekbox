<!--
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 20:13:53
 * @LastEditTime : 2025-01-07 16:26:34
 * @LastEditors  : LuHeQiu
 * @Description  : 
 * @FilePath     : /elecgeekbox/README.md
 * @HomePage     : https://www.luheqiu.com
-->


<div align="center">
    <h1>ElecGeekBox - 电子极客工具箱</h1>
    <p>一款为电子开发工程师打造的跨平台工具集成应用</p>
</div>

<p align="center">
    <img src="https://img.shields.io/badge/Version-0.1.0-blue?style=flat-square" alt="Version">
    <img src="https://img.shields.io/badge/Tauri-2.0-blue?style=flat-square" alt="Tauri">
    <img src="https://img.shields.io/badge/Vue-3.0-green?style=flat-square" alt="Vue">
    <img src="https://img.shields.io/badge/TypeScript-5.6-blue?style=flat-square" alt="TypeScript">
    <img src="https://img.shields.io/badge/Platform-Android%20|%20Desktop-lightgray?style=flat-square" alt="Platform">
    <img src="https://img.shields.io/badge/License-GPL%20v3-yellow?style=flat-square" alt="License">
</p>

<p align="center">
    <img src="https://img.shields.io/badge/Status-开发中-orange?style=flat-square" alt="Status">
    <img src="https://img.shields.io/badge/UI-Naive%20UI-blue?style=flat-square" alt="UI">
    <img src="https://img.shields.io/badge/Build-Vite-brightgreen?style=flat-square" alt="Build">
</p>


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
npm run tauri android build -- --apk --target aarch64
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
