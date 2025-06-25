<template>
  <div class="register-root">
    <div class="background">
      <div class="register-container">
        <h1>欢迎注册</h1>

        <el-form
            ref="ruleForm"
            :model="ruleForm"
            :rules="rules"
            label-width="80px"
            class="register-form"
            style="margin-left: -8px; box-shadow: none !important"
        >
          <el-form-item label="账号" prop="usercode">
            <el-input v-model="ruleForm.usercode" style="width: 200px;"></el-input>
          </el-form-item>

          <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username" style="width: 200px;"></el-input>
          </el-form-item>

          <el-form-item label="密码" prop="password">
            <el-input type="password" v-model="ruleForm.password" style="width: 200px;"></el-input>
          </el-form-item>

          <el-form-item label="确认密码" prop="checkPass">
            <el-input type="password" v-model="ruleForm.checkPass" style="width: 200px;"></el-input>
          </el-form-item>

          <el-form-item label="账户类型" prop="userType">
            <el-radio-group v-model="ruleForm.userType">
              <el-radio label="admin">管理员</el-radio>
              <el-radio label="dev">开发者</el-radio>
            </el-radio-group>
          </el-form-item>
            <el-button type="primary" @click="submitForm">确定注册</el-button>
        </el-form>
        <div class="login-link">
          <a @click="toLogin">没有账号？去注册</a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {regiser} from "@/api/app";

export default {
  name: 'RegisterView',
  data() {
    return {
      ruleForm: {
        usercode: '',
        username: '',
        password: '',
        checkPass: '',
        userType: ''
      },
      rules: {
        usercode: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 2, max: 9, message: '长度在 2 到 9 个字符', trigger: 'blur' }
        ],
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 2, max: 3, message: '长度在 2 到 3 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 12, message: '密码长度应在6到12个字符之间', trigger: 'blur' }
        ],
        checkPass: [
          { required: true, message: '请再次输入密码', trigger: 'blur' },
          { min: 6, max: 12, message: '密码长度应在6到12个字符之间', trigger: 'blur' }
        ],
        userType: [
          { required: true, message: '请选择账户类型', trigger: 'blur' }
        ]
      }
    };
  },
  methods: {
    submitForm() {
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          if (this.ruleForm.password !== this.ruleForm.checkPass) {
            this.$message.error("两次输入的密码不一致");
            return;
          }
          regiser(this.ruleForm).then((res) => {
            console.log(res);
            if (res.code === 2000) {
              this.$message.success(res.mess);
              this.$router.push("/");
            } else {
              this.$message.error(res.mess);
            }
          }).catch((err) => {
            console.error(err);
            this.$message.error("注册失败，请稍后再试");
          });
        } else {
          this.$message.error("表单信息填写有误，请检查");
        }
      });
    },
    toLogin() {
      if(this.ruleForm)
      this.$router.push("/");
    }
  }
}
</script>

<style scoped>
.register-root {
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

.register-container {
  background-color: rgba(255, 255, 255, 0.9);
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  width: 400px;
}

.register-form {
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

.el-form-item__label::before {
  content: none !important;
}

.el-button {
  margin-right: 10px;
  width: 100px;
}

.login-link {
  margin-top: 20px;
  font-size: 14px;
  color: #409EFF;
  cursor: pointer;
  text-decoration: underline;
}

.login-link a {
  color: inherit;
  text-decoration: inherit;
}
</style>