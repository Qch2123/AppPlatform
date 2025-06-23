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
          <a :href="'http://localhost:8888/'+scope.row.downloadlink">{{scope.row.downloadlink}}</a>
        </template>
      </el-table-column>
    </el-table>
    <hr>
    <el-descriptions title="审核">
    </el-descriptions>
    <el-button @click="OnYes" type="success" size="mini">通过</el-button>
    <el-button @click="OnNo" type="danger" size="mini">驳回</el-button>

  </div>
</template>

<script>
import {getAppWithVersion,sayYes,sayNo} from "@/api/app";

export default {
  name: "ExamineView",
  data() {
    return {
      appInfo:{
        id:'',
        softwarename:'',
        apkname:'',
        downloads:''
      },
      tableData:[],
    }
  },
  methods:{
    OnYes() {
      var that=this
      that.$confirm('此操作将通过审核, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        sayYes(that.appInfo.id).then(function (result) {
          if (result.code == '2000') {
            that.$message({
              type: 'success',
              message: '审核通过!'
            });
            that.$router.push("/appinfo")
          }else {
            that.$message({
              type: 'error',
              message: result.mess
            });
          }
        })
      }).catch(() => {
        that.$message({
          type: 'info',
          message: '已取消通过操作'
        });
      });
    },
    OnNo() {
        var that=this
        that.$confirm('此操作将驳回审核, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
        }).then(() => {
          sayNo(that.appInfo.id).then(function (result) {
            if (result.code == '2000') {
              that.$message({
                type: 'success',
                message: '驳回成功!'
              });
              that.$router.push("/appinfo")
            }else {
              that.$message({
                type: 'error',
                message: result.mess
              });
            }
            })
          }).catch(() => {
          that.$message({
              type: 'info',
              message: '已取消驳回操作'
            });
          });
    },
    getApp() {
    getAppWithVersion(this.appInfo.id).then(res => {
      console.log(res);
      this.appInfo = res.data
      this.tableData = res.data.versions
    })
  }
},
  created() {
    console.log(this.$route.query.appid)
    this.appInfo.id=this.$route.query.appid
    this.getApp()
  }
}
</script>

<style scoped>

</style>