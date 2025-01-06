/*
 * @Author       : LuHeQiu
 * @Date         : 2025-01-06 23:29:48
 * @LastEditTime : 2025-01-06 23:30:04
 * @LastEditors  : LuHeQiu
 * @Description  : 
 * @FilePath     : /elecgeekbox/src/types/vue-router.d.ts
 * @HomePage     : https://www.luheqiu.com
 */
import { RouteMeta, RouteLocationNormalized } from 'vue-router'

declare module 'vue-router' {
  interface RouteMeta {
    previousRoute?: RouteLocationNormalized
  }
}
