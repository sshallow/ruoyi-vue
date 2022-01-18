<template>
  <div class="bc">
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium"
             label-width="150px" class="components-form">
      <el-form-item :label="factorItemTitle" prop="field103" class="item">
        <el-select v-model="formData.field112" placeholder="大于" clearable class="components-select">
          <el-option v-for="(item, index) in field112Options" :key="index"
                     :label="item.label"
                     :value="item.value" :disabled="item.disabled"></el-option>
        </el-select>
        <el-input v-model="formData.field103" placeholder="0.00" clearable
                  :style="{width: '50%'}">
        </el-input>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  components: {},
  props: ['factorItemTitle'],
  data() {
    return {
      formData: {
        field112: undefined
      },
      rules: {
        field112: [{
          required: true,
          message: '请选择下拉选择',
          trigger: 'change'
        }]
      },
      field112Options: [{
        'label': '大于',
        'value': 1
      }, {
        'label': '小于',
        'value': 2
      }, {
        'label': '等于',
        'value': 3
      }, {
        'label': '区间',
        'value': 4
      }]
    }
  },
  computed: {},
  watch: {},
  created() {
  },
  mounted() {
  },
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    }
  }
}

</script>
<style>

.bc {
  /*background-color: pink;*/
}

.components-form {
  line-height: 1.5;
}

.item {
  /*line-height: 10px*/
}

.item .el-form-item__label{
  text-align: left;
  /*vertical-align: middle;*/
  font-size: 10px;
  /*display: inline-block;*/
  /*background-color: #00afff;*/
  line-height: 1;
  margin-top: 10px;
  /*padding-bottom: 10px;*/
}

.components-select {
  width: 80px;
}

</style>
