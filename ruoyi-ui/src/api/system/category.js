import request from '@/utils/request'

// 查询因子类别列表
export function listCategory(query) {
  return request({
    url: '/system/category/list',
    method: 'get',
    params: query
  })
}

// 查询因子列表
export function listFactor(query) {
  return request({
    url: '/system/category/listFactor',
    method: 'get',
    params: query
  })
}

// 查询因子类别详细
export function getCategory(factorCategoryId) {
  return request({
    url: '/system/category/' + factorCategoryId,
    method: 'get'
  })
}

// 新增因子类别
export function addCategory(data) {
  return request({
    url: '/system/category',
    method: 'post',
    data: data
  })
}

// 修改因子类别
export function updateCategory(data) {
  return request({
    url: '/system/category',
    method: 'put',
    data: data
  })
}

// 删除因子类别
export function delCategory(factorCategoryId) {
  return request({
    url: '/system/category/' + factorCategoryId,
    method: 'delete'
  })
}
