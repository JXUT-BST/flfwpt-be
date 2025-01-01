import request from '@/utils/request'

// 查询法律问答信息列表
export function listQa(query) {
  return request({
    url: '/app/qa/list',
    method: 'get',
    params: query
  })
}

// 查询法律问答信息详细
export function getQa(legalQaId) {
  return request({
    url: '/app/qa/' + legalQaId,
    method: 'get'
  })
}

// 新增法律问答信息
export function addQa(data) {
  return request({
    url: '/app/qa',
    method: 'post',
    data: data
  })
}

// 修改法律问答信息
export function updateQa(data) {
  return request({
    url: '/app/qa',
    method: 'put',
    data: data
  })
}

// 删除法律问答信息
export function delQa(legalQaId) {
  return request({
    url: '/app/qa/' + legalQaId,
    method: 'delete'
  })
}
