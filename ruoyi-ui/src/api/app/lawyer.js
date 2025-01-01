import request from '@/utils/request'

// 查询律师信息列表
export function listLawyer(query) {
  return request({
    url: '/app/lawyer/list',
    method: 'get',
    params: query
  })
}

// 查询律师信息详细
export function getLawyer(lawyerId) {
  return request({
    url: '/app/lawyer/' + lawyerId,
    method: 'get'
  })
}

// 新增律师信息
export function addLawyer(data) {
  return request({
    url: '/app/lawyer',
    method: 'post',
    data: data
  })
}

// 修改律师信息
export function updateLawyer(data) {
  return request({
    url: '/app/lawyer',
    method: 'put',
    data: data
  })
}

// 删除律师信息
export function delLawyer(lawyerId) {
  return request({
    url: '/app/lawyer/' + lawyerId,
    method: 'delete'
  })
}
