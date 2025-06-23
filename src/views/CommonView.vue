<template>
  <el-container style="height: 100vh; overflow: hidden">
    <!-- 侧边栏 -->
    <el-aside :width="sideWidth + 'px'" style="background-color: rgb(238, 241,246); box-shadow: 2px 0 6px rgba(0,21,41,0.35); min-height: 100vh;
                     overflow: hidden">
      <el-menu router default-active="/appInfo" :default-openeds="['1','2']"
               background-color="rgb(48, 65, 86)"
               text-color="#fff"
               active-text-color="#ffd04b"
               :collapse-transition="false"
               :collapse="isCollapse"
               style="height: 100%; border-right: none">

        <el-submenu index="1">
          <template slot="title">
            <img src="@/assets/手游后台.png"
                 style="
                    width: 25px;
                    height: 25px;
                    margin-right: 8px;      /* 与 Element 图标相同的右侧间距 */
                    vertical-align: middle; /* 确保与文字垂直居中 */
                  "
            >
            <span slot="title">手游管理平台</span>
          </template>

          <el-menu-item index="/appInfo"><i class="el-icon-menu"></i>
            <span slot="title">手游列表</span>
          </el-menu-item>
        </el-submenu>

        <el-submenu index="2" v-if="userType=='admin'">
          <template slot="title"><i class="el-icon-setting"></i>用户管理</template>
          <el-menu-item index="/devUser"><i class="el-icon-s-custom"></i>开发者列表</el-menu-item>
          <el-menu-item index="/backendUser"><i class="el-icon-s-cooperation"></i>管理员列表</el-menu-item>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container style="overflow: hidden">
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="logout">退出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>{{ usercode }}</span>
      </el-header>

      <el-main>
        <router-view/>
      </el-main>
    </el-container>
  </el-container>
</template>

<style>
html, body{
  height: 100vh;
  margin: 0 !important;
  padding: 0 !important;
  overflow: hidden !important;
}
#app {
  height: 100%;
  margin: 0;
  padding: 0;
}
.el-container {
  overflow: hidden !important;
  height: 100vh;
}
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 60px;
}

.el-aside {
  color: #333;
}
</style>

<script>
export default {
  data() {
    return {
      userType:'',
      usercode:'',
      sideWidth: 200, // 侧边栏宽度
      isCollapse: false// 是否折叠
    }
  },
  methods:{
    logout() {
      sessionStorage.clear()
      this.$router.push("/")
    }
  },
  created() {
    this.usercode=sessionStorage.getItem("usercode")
    //判断角色
    this.userType = sessionStorage.getItem("userType")
  }
};
</script>