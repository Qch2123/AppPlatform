import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from "@/views/LoginView";
import AppInfoView from "@/views/AppInfoView";
import CommonView from "@/views/CommonView";
import DevUserView from "@/views/DevUserView";
import BackendUserView from "@/views/BackendUserView";
import VersionView from "@/views/VersionView";
import ExamineView from "@/views/ExamineView";
import RegisterView from "@/views/RegisterView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/register',
    name: 'register',
    component: RegisterView,
  },
  {
    path: '/appInfo',
    name: 'appInfo',
    component: CommonView,
    children:[{path:'',component:AppInfoView}]
  },
  {
    path: '/devUser',
    name: 'devUser',
    component: CommonView,
    children:[{path:'',component:DevUserView}]
  },
  {
    path: '/backendUser',
    name: 'backendUser',
    component: CommonView,
    children:[{path:'',component:BackendUserView}]
  },
  {
    path: '/version',
    name: 'version',
    component: CommonView,
    children:[{path:'',component:VersionView}]
  },
  {
    path: '/examine',
    name: 'examine',
    component: CommonView,
    children:[{path:'',component:ExamineView}]
  }
  // {
  //   path: '/about',
  //   name: 'about',
  //   route level code-splitting
  //   this generates a separate chunk (about.[hash].js) for this route
  //   which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
]

const router = new VueRouter({
  routes
})

export default router
