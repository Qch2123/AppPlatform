<template>
  <div class="backendUser">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="账号">
        <el-input v-model="formInline.usercode" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item label="管理员名称">
        <el-input v-model="formInline.username" placeholder="管理员名称"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="id"
          label="id">
      </el-table-column>
      <el-table-column
          prop="usercode"
          label="账号">
      </el-table-column>
      <el-table-column
          prop="username"
          label="管理员名称">
      </el-table-column>
      <el-table-column
          prop="creationdate"
          label="注册时间">
      </el-table-column>
    </el-table>

    <el-pagination
        background
        :page-count="pages"
        :page-size="5"
        @current-change="changePageNum"
        layout="prev, pager, next"
        :total="total">
    </el-pagination>
  </div>
</template>

<script>
import {getBackendUserPage} from "@/api/app";

export default {
  name: 'BackendUserView',
  data(){
    return {
      tableData:[],
      pages:0,
      pageNum:1,
      total:0,
      formInline:{
        id:'',
        usercode:'',
        username:'',
        creationDate:''
      }
    }
  },
  methods:{
    changePageNum(value) {
      this.pageNum=value
      this.getPage()
    },
    onSubmit() {
      this.pageNum=1
      this.getPage()
    },
    getPage() {
      getBackendUserPage(this.formInline,this.pageNum).then(res=>{
        console.log(res);
        if(res.code==2000) {
          this.tableData=res.data.list
          this.pages=res.data.pages
          this.total=res.data.total
          this.pageNum=res.data.pageNum
        }
      })
    }
  },
  created() {
    this.getPage()
  }
}
</script>