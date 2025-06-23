<template>
  <div class="appInfo">
    <el-form :inline="true" :model="formInline" class="demo-form-inline">
      <el-form-item label="软件名称">
        <el-input v-model="formInline.softwarename" placeholder="软件名称"></el-input>
      </el-form-item>
      <el-form-item label="apk名称">
        <el-input v-model="formInline.apkname" placeholder="apk名称"></el-input>
      </el-form-item>
      <el-form-item label="状态">
        <el-select v-model="formInline.status" placeholder="状态">
          <el-option label="待审核" value="1"></el-option>
          <el-option label="审核通过" value="2"></el-option>
          <el-option label="审核未通过" value="3"></el-option>
          <el-option label="已上架" value="4"></el-option>
          <el-option label="已下架" value="5"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="所属平台">
        <el-select v-model="formInline.flatformid" placeholder="所属平台">
          <el-option label="手机" value="1"></el-option>
          <el-option label="平板" value="2"></el-option>
          <el-option label="通用" value="3"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="一级分类">
        <el-select @change="getLevel2()" v-model="formInline.categorylevel1" placeholder="请选择一级分类">
          <el-option label="请选择一级分类" value=""></el-option>
          <el-option v-for="c1 in level1" :key="c1.id" :label="c1.categoryname" :value="c1.id"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="二级分类">
        <el-select @change="getLevel3()" v-model="formInline.categorylevel2" placeholder="请选择二级分类">
          <el-option label="请选择二级分类" value=""></el-option>
          <el-option v-for="c2 in level2" :key="c2.id" :label="c2.categoryname" :value="c2.id"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="三级分类">
        <el-select v-model="formInline.categorylevel3" placeholder="请选择三级分类">
          <el-option label="请选择三级分类" value=""></el-option>
          <el-option v-for="c3 in level3" :key="c3.id" :label="c3.categoryname" :value="c3.id"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
        <el-button type="primary" v-if="userType=='dev'" @click="onAdd" >新增</el-button>
      </el-form-item>
    </el-form>

    <el-table
        :data="tableData"
        style="width: 100%">
      <el-table-column
          prop="devCode"
          label="开发者账号">
      </el-table-column>
      <el-table-column
          prop="softwarename"
          label="软件名称">
      </el-table-column>
      <el-table-column
          prop="apkname"
          label="apk名称">
      </el-table-column>


      <el-table-column
          label="logo图片">
        <template slot-scope="scope">
          <img :src="baseURL+'/'+scope.row.logopicpath" alt="" style="height:50px;width:50px">
        </template>
      </el-table-column>

      <el-table-column
          label="所属平台">
        <template slot-scope="scope">
          {{scope.row.flatformid==1?'手机':
            scope.row.flatformid==2?'平板':
            '通用'
          }}
        </template>
      </el-table-column>

      <el-table-column
          label="分类">
        <template slot-scope="scope">
          {{scope.row.level1Name}}->{{scope.row.level2Name}}->{{scope.row.level3Name}}
        </template>
      </el-table-column>

      <el-table-column
          label="状态">
        <template slot-scope="scope">
          {{scope.row.status==1?'待审核':
            scope.row.status==2?'审核通过':
                scope.row.status==3?'审核未通过':
                    scope.row.status==4?'已上架':'已下架'
          }}
        </template>
      </el-table-column>

      <el-table-column
          label="操作">
        <template slot-scope="scope">
          <!-- 如果是开发者且应用属于自己 -->
          <div v-if="userType === 'dev' && scope.row.devCode === userCode">
            <el-dropdown size="small" split-button type="primary">
              更多操作
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item v-if="scope.row.status === 1 || scope.row.status === 3 || scope.row.status === 5" @click.native="toUpdate(scope.row)">修改</el-dropdown-item>
                <el-dropdown-item v-if="scope.row.status === 1 || scope.row.status === 3 || scope.row.status === 5" @click.native="toAddVersion(scope.row.id)">添加版本</el-dropdown-item>
                <el-dropdown-item v-if="scope.row.status === 2 || scope.row.status === 5" @click.native="onUpOrOff(scope.row.id)">上架</el-dropdown-item>
                <el-dropdown-item v-if="scope.row.status === 4" @click.native="onUpOrOff(scope.row.id)">下架</el-dropdown-item>
                <el-dropdown-item v-if="scope.row.status === 1 || scope.row.status === 2 || scope.row.status === 3 || scope.row.status === 5" @click.native="toDel(scope.row.id)">删除</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>

            <el-upload
                class="upload-demo"
                name="logo"
                :headers="headerObj"
                :before-upload="beforeUpload"
                accept="image/*"
                :on-success="uploadSuccess"
                :show-file-list="false"
                :file-list="fileList"
                :action="baseURL + '/appInfo/upLogo/' + scope.row.id"
                :limit="1">
              <el-button size="small" type="warning">上传logo</el-button>
            </el-upload>
          </div>
          <!-- 如果是开发者但应用不属于自己的情况，显示无法操作的文字 -->
          <div v-else-if="userType === 'dev'">
            <span>仅供浏览</span>
          </div>
          <!-- 如果是管理员 -->
          <div v-if="userType === 'admin'">
            <el-button @click="OnExamine(scope.row)" type="primary" size="mini">审核</el-button>
          </div>
        </template>
      </el-table-column>
    </el-table>

    <el-pagination
        background
        :current-page="pageNum"
        :page-size="5"
        @current-change="changePageNum"
        :page-count="pages"
        layout="prev, pager, next"
        :total="total">
    </el-pagination>

    <el-dialog
        title="新增/修改"
        :visible.sync="dialogVisible"
        :destroy-on-close="true"
        width="60%">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-row>
          <el-col :span="8">
            <el-form-item label="软件名称" prop="softwarename">
            <el-input v-model="ruleForm.softwarename"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="apk名称" prop="apkname">
              <el-input v-model="ruleForm.apkname"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="所属平台" prop="flatformid">
              <el-select v-model="ruleForm.flatformid" placeholder="请选择所属平台">
                <el-option label="手机" :value="1"></el-option>
                <el-option label="平板" :value="2"></el-option>
                <el-option label="通用" :value="3"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="8">
            <el-form-item label="一级分类">
              <el-select @change="getLevel22()" v-model="ruleForm.categorylevel1" placeholder="请选择一级分类">
                <el-option label="请选择一级分类" value=""></el-option>
                <el-option v-for="c1 in addlevel1" :key="c1.id" :label="c1.categoryname" :value="c1.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="二级分类">
              <el-select @change="getLevel33()" v-model="ruleForm.categorylevel2" placeholder="请选择二级分类">
                <el-option label="请选择二级分类" value=""></el-option>
                <el-option v-for="c2 in addlevel2" :key="c2.id" :label="c2.categoryname" :value="c2.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="三级分类">
              <el-select v-model="ruleForm.categorylevel3" placeholder="请选择三级分类">
                <el-option label="请选择三级分类" value=""></el-option>
                <el-option v-for="c3 in addlevel3" :key="c3.id" :label="c3.categoryname" :value="c3.id"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="16">
            <el-form-item label="简介" prop="appinfo">
              <el-input type="textarea" v-model="ruleForm.appinfo"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="软件大小" prop="softwaresize">
              <el-input v-model="ruleForm.softwaresize"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import {delApp, getAppInfoPage, getCategoryTree, upOrOff, saveOrUpdateApp, validateApkName} from "@/api/app";

  export default {
    name: 'AppView',
    data() {
      var validateApkname = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入apk名称'));
        } else {
          validateApkName(value, this.ruleForm.id).then(res => {
            console.log(res);
            if (res.data) {
              callback();
            } else {
              callback(new Error('apk名称已占用'));
            }
           })
          }
        };
      return {
        userType:'',
        userCode:'',
        headerObj:{
          token:sessionStorage.getItem("token")
        },
        fileList:[],
        baseURL:process.env.VUE_APP_BASE_API,
        dialogVisible:false,
        ruleForm:{
          id:'',
          softwarename:'',
          apkname:'',
          flatformid:'',
          categorylevel1:'',
          categorylevel2:'',
          categorylevel3:'',
          softwaresize:'',
          appinfo:''
        },
        rules: {
          softwarename: [
            {required: true, message: '请输入软件名称', trigger: 'blur'}
          ],
          apkname: [
            {required: true, message: '请输入apk名称', trigger: 'blur'},
            {validator: validateApkname, trigger: 'blur' }
          ],
          softwaresize: [
            {required: true, message: '请输入软件大小', trigger: 'blur'},
            { pattern:/^(?!0+(\.0*)?$)(\+)?([1-9]\d*(\.\d+)?)$/, message:'必须是大于0的数字', trigger: 'blur' }
          ],
        },
        level1:[],
        level2:[],
        level3:[],

        addlevel1:[],
        addlevel2:[],
        addlevel3:[],

        tableData:[],
        pages:0,
        total:0,
        pageNum:1,
        formInline:{
          softwarename:'',
          apkname:'',
          status:'',
          flatformid:'',
          categorylevel1:'',
          categorylevel2:'',
          categorylevel3:''
        }
      }
    },
    methods:{
      beforeUpload(file) {
        const isImage = file.type.startsWith('image/');
        if (!isImage) {
          this.$message.error('只能上传图片文件！');
        }
        return isImage;
      },
      onUpOrOff(id) {
        upOrOff(id).then(res=> {
          console.log(res);
          if(res.code=='2000') {
            this.$message.success("操作成功")
            this.getPage()
          }
        })
      },
      OnExamine(row) {
        if (row.versionid > 0) {
          this.$router.push({path:'/examine',query:{appid:row.id}})
        }else {
          this.$message.error('没有添加版本，不能审核')
        }
      },
      toAddVersion(id) {
        console.log(id);
        this.$router.push({path:'/version',query:{appid:id}})
      },
      beforUpload(file) {
        const isImage=file.type.startsWith('image/');
        if(!isImage) {
          this.$message.error('只能上传图片文件！')
        }
        return isImage
      },
      uploadSuccess(response,file,fileList) {
        console.log(response);
        console.log(file);
        console.log(fileList);
        this.fileList=[]
        this.getPage()
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            saveOrUpdateApp(this.ruleForm).then(res=>{
              console.log(res);
              this.dialogVisible=false
              this.getPage();
            });
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      onAdd() {
        this.ruleForm={
          id:'',
          softwarename:'',
          apkname:'',
          flatformid:'',
          categorylevel1:'',
          categorylevel2:'',
          categorylevel3:'',
          softwaresize:'',
          appinfo:''
        }

        this.dialogVisible=true
      },
      getLevel2() {
        this.level2=[]
        this.level3=[]
        this.formInline.categorylevel2=''
        this.formInline.categorylevel3=''
        var one=this.formInline.categorylevel1
        var data=this.level1
        for (let i = 0; i < data.length; i++) {
          if(one==data[i].id) {
            this.level2=data[i].children
          }
        }
      },
      getLevel3() {
        this.level3=[]
        this.formInline.categorylevel3=''
        var two=this.formInline.categorylevel2
        var data=this.level2
        for (let i = 0; i < data.length; i++) {
          if(two==data[i].id) {
            this.level3=data[i].children
          }
        }
      },

      getLevel22() {
        this.addlevel2=[]
        this.addlevel3=[]
        this.ruleForm.categorylevel2=''
        this.ruleForm.categorylevel3=''
        var one=this.ruleForm.categorylevel1

        var data=this.addlevel1
        for (let i = 0; i < data.length; i++) {
          if(one==data[i].id) {
            this.addlevel2=data[i].children
          }
        }
      },
      getLevel33() {
        this.addlevel3=[]
        this.ruleForm.categorylevel3=''
        var two=this.ruleForm.categorylevel2
        var data=this.addlevel2
        for (let i = 0; i < data.length; i++) {
          if(two==data[i].id) {
            this.addlevel3=data[i].children
          }
        }
      },

      changePageNum(value) {
        this.pageNum=value
        this.getPage()
      },
      getPage() {
        getAppInfoPage(this.formInline, this.pageNum).then((res) => {
          console.log(res);

          if (res.code === 2000) {
              this.tableData = res.data.list;
              this.pages = res.data.pages;
              this.total = res.data.total;
              this.pageNum = res.data.pageNum;
          }
        });
      },
      toUpdate(row) {
        this.ruleForm.id=row.id
        this.ruleForm.appinfo=row.appinfo
        this.ruleForm.softwarename=row.softwarename
        this.ruleForm.apkname=row.apkname
        this.ruleForm.softwaresize=row.softwaresize
        this.ruleForm.categorylevel1=row.categorylevel1

        this.getLevel22()
        this.ruleForm.categorylevel2=row.categorylevel2
        this.getLevel33()
        this.ruleForm.categorylevel3=row.categorylevel3
        this.ruleForm.flatformid=row.flatformid

        this.dialogVisible=true
      },
      toDel(id) {
        this.$confirm('此操作将永久删除该app, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          delApp(id).then(res=>{
            console.log(res);
            this.$message({
              type: 'success',
              message: '删除成功!'
            });
            this.getPage();
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },
      getTree(){
        getCategoryTree().then(res=>{
          console.log(res);
          this.level1=res.data.children

          this.addlevel1=res.data.children

        })
      },
      onSubmit() {
        this.pageNum = 1,
            this.getPage()
      }
    },
    created() {
      //判断角色
      this.userType = sessionStorage.getItem("userType")
      this.userCode = sessionStorage.getItem("usercode")
      this.getPage()
      this.getTree()
      this.$route.query.usercode
    }
  }
</script>

<style scoped>

</style>

