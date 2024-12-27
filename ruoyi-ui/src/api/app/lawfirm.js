import request from '@/utils/request'

// 查询律所信息列表
export function listLawfirm(query) {
  return request({
    url: '/app/lawfirm/list',
    method: 'get',
    params: query
  })
}

// 查询律所信息详细
export function getLawfirm(lawfirmId) {
  return request({
    url: '/app/lawfirm/' + lawfirmId,
    method: 'get'
  })
}

// 新增律所信息
export function addLawfirm(data) {
  return request({
    url: '/app/lawfirm',
    method: 'post',
    data: data
  })
}

// 修改律所信息
export function updateLawfirm(data) {
  return request({
    url: '/app/lawfirm',
    method: 'put',
    data: data
  })
}

// 删除律所信息
export function delLawfirm(lawfirmId) {
  return request({
    url: '/app/lawfirm/' + lawfirmId,
    method: 'delete'
  })
}
