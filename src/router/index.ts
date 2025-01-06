import { createRouter, createWebHistory } from 'vue-router'
import DefaultLayout from '../layouts/DefaultLayout.vue'
import PageLayout from '../layouts/PageLayout.vue'

const routes = [
  {
    path: '/',
    redirect: '/home',
    component: DefaultLayout,
    meta: { layout: 'default' },
    children: [
      {
        path: 'home',
        name: 'Home',
        component: () => import('../pages/home/index.vue'),
        meta: { title: '首页' }
      },
      {
        path: 'tools',
        name: 'Tools',
        component: () => import('../pages/tools/index.vue'),
        meta: { title: '工具' }
      },
      {
        path: 'settings',
        name: 'Settings',
        component: () => import('../pages/settings/index.vue'),
        meta: { title: '设置' }
      }
    ]
  },
  {
    path: '/detail',
    component: PageLayout,
    children: [
      {
        path: '',
        name: 'Detail',
        component: () => import('../pages/detail/index.vue'),
        meta: { title: '详情' }
      }
    ]
  },
  {
    path: '/tools/buck-inductor',
    component: PageLayout,
    meta: { layout: 'page', title: 'Buck电感计算器' },
    children: [
      {
        path: '',
        component: () => import('../pages/tools/buck-inductor/index.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    }
    return { top: 0 }
  }
})

router.beforeEach((to, from) => {
  to.from = from
})

export default router 