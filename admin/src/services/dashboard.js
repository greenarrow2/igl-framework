import { request, config } from 'utils'

const { api } = config
const { dashboard } = api

export async function query (params) {
  return request({
    url: dashboard,
    method: 'post',
    data: params,
  })
}

export async function create (params) {
  return request({
    url: dashboard.replace('/:id', ''),
    method: 'post',
    data: params,
  })
}

export async function remove (params) {
  return request({
    url: dashboard,
    method: 'delete',
    data: params,
  })
}

export async function update (params) {
  return request({
    url: dashboard,
    method: 'patch',
    data: params,
  })
}
