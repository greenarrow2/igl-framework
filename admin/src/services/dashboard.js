import { request, config } from 'utils'

const { api } = config
const { dicList,dicSave,dicDelete } = api

export async function query (params) {
  return request({
    url: dicList,
    method: 'post',
    data: params,
  })
}

export async function create (params) {
  console.log("protocolprotocol",params)
  return request({
    url: dicSave,
    method: 'post',
    data: params,
  })
}

export async function remove (params) {
  return request({
    url: dicDelete,
    method: 'post',
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
