<template>
  <div class="login-root">
    <div class="background">
      <div class="login-container">
        <h1>欢迎登录手游平台管理系统</h1>

        <el-form
            ref="form"
            :model="form"
            label-width="80px"
            class="login-form"
            style="margin-left: -8px;
            box-shadow: none !important"
        >
          <el-form-item label="账号">
            <el-input v-model="form.usercode" style="width: 200px;"></el-input>
          </el-form-item>

          <el-form-item label="密码">
            <el-input type="password" v-model="form.password" style="width: 200px;"></el-input>
          </el-form-item>

          <el-form-item label="账户类型">
            <el-radio-group v-model="form.userType">
              <el-radio label="admin">管理员</el-radio>
              <el-radio label="dev">开发者</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-button type="primary" @click="onLogin">登录</el-button>
        </el-form>

        <div class="register-link">
          <a @click="onRegister">没有账号？去注册</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { loginApi } from "@/api/app";

export default {
  name: 'LoginView',
  data() {
    return {
      form: {
        usercode: '',
        password: '',
        userType: 'dev'
      }
    }
  },
  methods: {
    onLogin() {
      loginApi(this.form).then(res => {
        console.log(res);
        this.$message.success(res.mess);
        sessionStorage.setItem("token", res.data);
        sessionStorage.setItem("usercode", this.form.usercode);
        sessionStorage.setItem("userType", this.form.userType);
        this.$router.push("/appInfo");
      });
    },
    onRegister() {
      this.$router.push("/register");
    }
  }
}
</script>

<style scoped>
.login-root {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  overflow: hidden;
}

.background {
  width: 100vw;
  height: 100vh;
  background-image: url("../assets/login.png");
  background-size: cover;
  background-position: center;
  display: flex;
  justify-content: center;
  align-items: center;
}

.login-container {
  background-color: rgba(255, 255, 255, 0.9);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 400px;
}

.login-form {
  background-color: rgba(255, 255, 255, 0.9);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 400px;
  max-width: 90%;
}

h1 {
  margin-bottom: 30px;
  font-size: 24px;
  color: #303133;
  font-weight: 500;
}

.el-form-item {
  margin-bottom: 20px;
}

.el-button {
  margin-right: 10px;
}

.register-link {
  margin-top: 20px;
  font-size: 14px;
  color: #409EFF;
  cursor: pointer;
  text-decoration: underline;
}

.register-link a {
  color: inherit;
  text-decoration: inherit;
}
</style>