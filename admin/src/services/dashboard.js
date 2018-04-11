import { request, config } from 'utils'

const { api } = config
const { dicList,dicSave,dicDelete,dicMultiDelete } = api

export async function query (params) {
  return request({
    url: dicList,
    method: 'post',
    data: params,
  })
}

export async function create (params) {
  return request({
    url: dicSave,
    method: 'post',
    data: params,
  })
}

export async function remove (params) {
  console.log("delete ddd",params)
  return request({
    url: dicDelete,
    method: 'delete',
    data: params,
  })
}

export async function multiRemove (params) {
  console.log("multiRemove ddd",params)
  return request({
    url: dicMultiDelete,
    method: 'delete',
    data: params,
  })
}

export async function update (params) {
  return request({
    url: dicSave,
    method: 'post',
    data: params,
  })
}
