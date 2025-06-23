<template>
  <div>
    <el-descriptions title="app信息">
      <el-descriptions-item label="软件名称">{{appInfo.softwarename}}</el-descriptions-item>
      <el-descriptions-item label="apk名称">{{appInfo.apkname}}</el-descriptions-item>
      <el-descriptions-item label="下载量">
        <el-tag size="small">{{appInfo.downloads}}</el-tag>
      </el-descriptions-item>
    </el-descriptions>
    <hr>
    <el-descriptions title="版本列表">
    </el-descriptions>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="versionno"
          label="版本号">
      </el-table-column>

      <el-table-column
          prop="versioninfo"
          label="版本介绍">
      </el-table-column>

      <el-table-column
          prop="creationdate"
          label="创建时间">
      </el-table-column>

      <el-table-column
          label="下载链接">
        <template slot-scope="scope">
          <a :href="'http://localhost:8888' + scope.row.downloadlink">
            {{ scope.row.downloadlink }}
          </a>
        </template>
      </el-table-column>

    </el-table>

    <el-descriptions title="添加版本">
    </el-descriptions>

    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="版本号" prop="versionno">
        <el-input v-model="ruleForm.versionno"></el-input>
      </el-form-item>

      <el-form-item label="版本介绍" prop="versioninfo">
        <el-input type="textarea" v-model="ruleForm.versioninfo"></el-input>
      </el-form-item>

      <el-form-item label="版本大小" prop="versionsize">
        <el-input type="textarea" v-model="ruleForm.versionsize"></el-input>
      </el-form-item>

      <el-form-item label="apk文件" prop="apkFile">
        <el-upload
            class="upload-demo"
            action="#"
            :on-change="changeUpload"
            :auto-upload="false"
            multiple
            :limit="1">
          <el-button size="small" type="primary">选取文件</el-button>
        </el-upload>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
        <el-button @click="resetForm('ruleForm')">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>


import {addVersion, getAppWithVersion} from "@/api/app";

export default {
  name: 'VersionView',
  data(){
    return {
      tableData:[],
      ruleForm:{
        appid:'',
        versionno:'',
        versioninfo:'',
        versionsize:'',
        apkFile:''
    },
      rules:{
        versionno: [
          { required: true, message: '请输入版本号', trigger: 'blur' }
        ],
        versioninfo: [
          { required: true, message: '请输入版本介绍', trigger: 'blur' }
        ],
        versionsize: [
          { required: true, message: '请输入版本大小', trigger: 'blur' },
          {pattern:/^(?!0+(\.0*)?$)(\+)?([1-9]\d*(\.\d+)?)$/, message:'必须是大于0的数字', trigger: 'blur' }
        ],
        apkFile: [
          { required: true, message: '请选择apk文件', trigger: 'blur' }
        ],
      },
      appInfo:{
        id:'',
        softwarename:'',
        apkname:'',
        downloads:''
      }
    }
  },
  methods:{
    changeUpload(file) {
      this.ruleForm.apkFile=file.raw
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
            var data=this.ruleForm
            var formData = new FormData;
            for(let key in data) {
              formData.append(key,data[key])
            }
            addVersion(formData).then(res=>{
              console.log(res);
              this.$message.success("添加成功")
              this.getApp()
            })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    getApp() {
      getAppWithVersion(this.appInfo.id).then(res=>{
        console.log(res);
        this.appInfo=res.data
        this.tableData=res.data.versions
      })
    }
  },
  created() {
    this.appInfo.id=this.$route.query.appid
    this.ruleForm.appid=this.$route.query.appid
    this.getApp()
  }
}
</script>
