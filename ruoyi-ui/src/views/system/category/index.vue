<template>
  <div style="padding: 10px;">
    <el-row :gutter="20">
      <!-- 因子菜单 -->
      <el-col :span="10" :xs="24" class="left-board">
        <!-- 因子搜索框 -->
        <div class="head-container">
          <el-input
            v-model="factorItemTitle"
            placeholder="请输入因子名称"
            clearable
            size="small"
            prefix-icon="el-icon-search"
            style="margin-bottom: 10px"
          />
        </div>
        <!-- 因子选择 -->
        <el-row>
          <!-- 因子大类别 -->
          <el-col :span="4" class="components-factorCategory">
            <div v-for="factorCategory in categoryList"
                 :key="factorCategory.factorCategoryId"
                 class="components-factorTitle"
                 @click="getFactorList(factorCategory.factorCategoryId)">
              {{ factorCategory.factorCategoryTitle }}
            </div>
          </el-col>
          <!-- 因子 -->
          <el-col :span="20"
                  style="height: 100vh;  padding-left: 8px; overflow: scroll">
            <div v-for="factor in factorList" :key="factor.factorItemTitle"
                 @click="addConditionItem(factor)"
                 class="components-item">
              <div class="components-body">
                {{ factor.factorItemTitle }}
              </div>
            </div>
          </el-col>
        </el-row>

      </el-col>
      <!-- 生成策略表单 -->
      <el-col :span="14" :xs="24">
        <el-scrollbar class="center-scrollbar">
          <el-row class="center-board-row" :gutter="formConf.gutter">
            <el-form
              :size="formConf.size"
              :label-position="formConf.labelPosition"
              :disabled="formConf.disabled"
              :label-width="formConf.labelWidth + 'px'"
            >
              <draggable class="drawing-board" :list="conditionItemList"
                         :animation="340" group="componentsGroup">
                <condition-item v-for="factorCategory in conditionItemList"
                                :key="factorCategory.factorItemTitle"
                                :factor-item-title="factorCategory.factorItemTitle">
                </condition-item>
              </draggable>
              <div v-show="!conditionItemList.length" class="empty-info">
                从左侧拖入或点选组件进行表单设计
              </div>
            </el-form>
          </el-row>
        </el-scrollbar>
        <div style="align-content: center">
          <el-button type="primary" @click="submitForm">提交1</el-button>
          <el-button @click="resetForm">重置</el-button>
        </div>
      </el-col>
    </el-row>
    <!-- 添加或修改因子类别对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="因子类别标题" prop="factorCategoryTitle">
          <el-input v-model="form.factorCategoryTitle" placeholder="请输入因子类别标题"/>
        </el-form-item>
        <el-form-item label="排序" prop="sort">
          <el-input v-model="form.sort" placeholder="请输入排序"/>
        </el-form-item>
        <el-form-item label="是否删除" prop="isdelete">
          <el-input v-model="form.isdelete" placeholder="请输入是否删除"/>
        </el-form-item>
        <el-form-item label="是否多选" prop="isdouble">
          <el-input v-model="form.isdouble" placeholder="请输入是否多选"/>
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
import {
  listCategory,
  listFactor,
  getCategory,
  delCategory,
  addCategory,
  updateCategory
} from '@/api/system/category'
import draggable from 'vuedraggable'
import ConditionItem from './ConditionItem'

export default {
  components: {
    ConditionItem,
    draggable
  },
  name: 'Category',
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
      // 因子类别表格数据
      categoryList: [],
      // 弹出层标题
      title: '',
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        factorCategoryId: null,
        factorCategoryTitle: null,
        sort: null,
        isdelete: null,
        isdouble: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {},
      //因子类别 id
      factorCategoryId: '',
      //因子列表
      factorList: [],
      //因子名称，用作搜索用
      factorItemTitle: null,

      //
      formConf: {
        formRef: 'elForm',
        formModel: 'formData',
        size: 'medium',
        labelPosition: 'right',
        labelWidth: 100,
        formRules: 'rules',
        gutter: 15,
        disabled: false,
        span: 24,
        formBtns: true
      },

      conditionItemList: []
    }
  },
  watch: {
    // 根据名称筛选因子
    factorItemTitle(val) {
      this.$refs.tree.filter(val)
    }
  },
  created() {
    this.getList()
  },
  methods: {
    activeFormItem(element) {
      this.activeData = element
      this.activeId = element.formId
    },

    /** 查询因子类别列表 */
    getList() {
      this.loading = true
      listCategory(this.queryParams).then(response => {
        this.categoryList = response.rows
        this.total = response.total
        this.loading = false
        // this.conditionItemList = response.rows;
      })
    },

    // 查询因子列表
    getFactorList(factorCategoryId) {
      this.loading = true
      this.queryParams.factorCategoryId = factorCategoryId
      listFactor(this.queryParams).then(response => {
        this.factorList = response.rows
        this.loading = false
      })
    },

    // 添加条件(选中因子)
    addConditionItem(item) {
      this.conditionItemList.push(item)
      // const clone = this.cloneComponent(item)
      // this.drawingList.push(clone)
      // this.activeFormItem(clone)
    },

    // 取消按钮
    cancel() {
      this.open = false
      this.reset()
    },
    // 表单重置
    reset() {
      this.form = {
        factorCategoryId: null,
        factorCategoryTitle: null,
        sort: null,
        isdelete: null,
        isdouble: null
      }
      this.resetForm('form')
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1
      this.getList()
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm('queryForm')
      this.handleQuery()
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.factorCategoryId)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset()
      this.open = true
      this.title = '添加因子类别'
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset()
      const factorCategoryId = row.factorCategoryId || this.ids
      getCategory(factorCategoryId).then(response => {
        this.form = response.data
        this.open = true
        this.title = '修改因子类别'
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const factorCategoryIds = row.factorCategoryId || this.ids
      this.$modal.confirm('是否确认删除因子类别编号为"' + factorCategoryIds + '"的数据项？').then(function() {
        return delCategory(factorCategoryIds)
      }).then(() => {
        this.getList()
        this.$modal.msgSuccess('删除成功')
      }).catch(() => {
      })
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/category/export', {
        ...this.queryParams
      }, `category_${new Date().getTime()}.xlsx`)
    },

    /** 提交按钮 */
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    //重置
    resetForm() {
      this.$refs['elForm'].resetFields()
    }
  }
}
</script>

<style lang='scss'>

$selectedColor: #f6f7ff;
$lighterBlue: #409EFF;

.left-board {
  width: 440px;
  //position: absolute;
  left: 0;
  top: 10px;
  height: 100vh;
}

.components-factorCategory {
  background: #F0F1FF;
  height: 1000px;
  box-shadow: 1.5px 0 1px #E6E8FF;
}

.components-factorTitle {
  font-size: 12px;
  font-weight: bold;
  color: #222;
  text-align: center;
  margin-top: 10px;

  &:hover {
    color: #787be8;
    background: #E6E8FF;
  }
}

.components-item {
  display: inline-block;
  width: 48%;
  margin: 1%;
  transition: transform 0ms !important;
}

.components-body {
  padding: 8px 10px;
  background: $selectedColor;
  font-size: 12px;

  .svg-icon {
    color: #777;
    font-size: 15px;
  }

  &:hover {
    color: #787be8;
    background: #E6E8FF;
    border-radius: 3px;
  }
}

.center-scrollbar {
  height: calc(100vh - 42px);
  overflow: hidden;
  border-left: 1px solid #f1e8e8;
  border-right: 1px solid #f1e8e8;
  box-sizing: border-box;
}

.center-board-row {
  padding: 12px 12px 15px 12px;
  box-sizing: border-box;

  & > .el-form {
    // 69 = 12+15+42
    height: calc(100vh - 69px);
  }
}

.drawing-board {
  height: 100%;
  position: relative;

  .components-body {
    padding: 0;
    margin: 0;
    font-size: 0;
  }

  .sortable-ghost {
    position: relative;
    display: block;
    overflow: hidden;

    &::before {
      content: " ";
      position: absolute;
      left: 0;
      right: 0;
      top: 0;
      height: 3px;
      background: rgb(89, 89, 223);
      z-index: 2;
    }
  }

  .components-item.sortable-ghost {
    width: 100%;
    height: 60px;
    background-color: $selectedColor;
  }

  .active-from-item {
    & > .el-form-item {
      background: $selectedColor;
      border-radius: 6px;
    }

    & > .drawing-item-copy, & > .drawing-item-delete {
      display: initial;
    }

    & > .component-name {
      color: $lighterBlue;
    }
  }

  .el-form-item {
    margin-bottom: 15px;
  }
}

.empty-info {
  position: absolute;
  top: 46%;
  left: 0;
  right: 0;
  text-align: center;
  font-size: 18px;
  color: #ccb1ea;
  letter-spacing: 4px;
}

</style>
