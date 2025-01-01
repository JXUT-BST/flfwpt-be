import request from '@/utils/request'

// 查询客户提问列表
export function listQuery(query) {
  return request({
    url: '/app/query/list',
    method: 'get',
    params: query
  })
}

// 查询客户提问详细
export function getQuery(legalQaId) {
  return request({
    url: '/app/query/' + legalQaId,
    method: 'get'
  })
}

// 新增客户提问
export function addQuery(data) {
  return request({
    url: '/app/query',
    method: 'post',
    data: data
  })
}

// 修改客户提问
export function updateQuery(data) {
  return request({
    url: '/app/query',
    method: 'put',
    data: data
  })
}

// 删除客户提问
export function delQuery(legalQaId) {
  return request({
    url: '/app/query/' + legalQaId,
    method: 'delete'
  })
}
