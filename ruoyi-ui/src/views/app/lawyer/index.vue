<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="简介" prop="introduction">
        <el-input
          v-model="queryParams.introduction"
          placeholder="请输入简介"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="标签" prop="field">
        <el-input
          v-model="queryParams.field"
          placeholder="请输入标签"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="营业时间" prop="businessHours">
        <el-input
          v-model="queryParams.businessHours"
          placeholder="请输入营业时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入地址"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="律师名称" prop="lawyerName">
        <el-input
          v-model="queryParams.lawyerName"
          placeholder="请输入律师名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['app:lawyer:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['app:lawyer:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['app:lawyer:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['app:lawyer:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="lawyerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="律所ID" align="center" prop="lawyerId"/>
      <el-table-column label="备注" align="center" prop="remark"/>
      <el-table-column label="简介" align="center" prop="introduction"/>
      <el-table-column label="标签" align="center" prop="field"/>
      <el-table-column label="营业时间" align="center" prop="businessHours"/>
      <el-table-column label="地址" align="center" prop="address"/>
      <el-table-column label="律师名称" align="center" prop="lawyerName"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['app:lawyer:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['app:lawyer:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改律师信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <el-form-item label="简介" prop="introduction">
          <el-input v-model="form.introduction" placeholder="请输入简介"/>
        </el-form-item>
        <el-form-item label="标签" prop="field">
          <el-input v-model="form.field" placeholder="请输入标签"/>
        </el-form-item>
        <el-form-item label="营业时间" prop="businessHours">
          <el-input v-model="form.businessHours" placeholder="请输入营业时间"/>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入地址"/>
        </el-form-item>
        <el-form-item label="律师名称" prop="lawyerName">
          <el-input v-model="form.lawyerName" placeholder="请输入律师名称"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {addLawyer, delLawyer, getLawyer, listLawyer, updateLawyer} from "@/api/app/lawyer";

export default {
  name: "Lawyer",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 律师信息表格数据
      lawyerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        introduction: null,
        field: null,
        businessHours: null,
        address: null,
        lawyerName: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        delFlag: [
          // {
          //   required: false,
          //   message: "删除标记不能为空",
          //   trigger: "blur"
          // }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询律师信息列表 */
    getList() {
      this.loading = true;
      listLawyer(this.queryParams).then(response => {
        this.lawyerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        lawyerId: null,
        createBy: null,
        updateBy: null,
        createTime: null,
        updateTime: null,
        delFlag: null,
        remark: null,
        introduction: null,
        field: null,
        businessHours: null,
        address: null,
        lawyerName: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.lawyerId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加律师信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const lawyerId = row.lawyerId || this.ids
      getLawyer(lawyerId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改律师信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.lawyerId != null) {
            updateLawyer(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addLawyer(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const lawyerIds = row.lawyerId || this.ids;
      this.$modal.confirm('是否确认删除律师信息编号为"' + lawyerIds + '"的数据项？').then(function () {
        return delLawyer(lawyerIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('app/lawyer/export', {
        ...this.queryParams
      }, `lawyer_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
