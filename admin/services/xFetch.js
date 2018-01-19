// 自定义访问服务器api函数

import {notification} from 'antd';
import 'whatwg-fetch'; //兼容safari浏览器

const errorMessages = (res) => `${res.status} ${res.statusText}`;

function check401(res) {
  if (res.status === 401) {
    location.href = '/401';
  }
  return res;
}

function check404(res) {
  if (res.status === 404) {
    return Promise.reject(errorMessages(res));
  }
  return res;
}

function jsonParse(res) {
  return res.json();
}

function errorMessageParse(res) {
  const success = res.success;
  const code = res.code;
  if (!success || code != '200') {
    notification.error({
      message: '系统异常',
      description: res.msg
    });
    return Promise.reject(res.msg);
  }
  return res;
}

function catchError(error){
    if(error){
        console.error('ERROR:',error);
    }
}

export function xPostFetch(url,body) {
  const option =  {
    method: 'POST',
    headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
    body: body
  };
  return xFetch(url,option);
}

export function xFetch(url ,options) {
    let seperator = '';
    let token = '';

    if(!options){
      options = {
        method: 'get'
      };
    }

    //开发时候指定SERVER_URL,需带token,正式发布不需要携带该tokenlo
    //开发环境下，不携带cookie
    if(SERVER_URL){
      token = 'token_inc=91516181373092355';
    }else{
        options.credentials = 'include';
    }

    if(url.endsWith('.json')){
        seperator = '?';
    }else{
        seperator = '&';
    }
    url = url + seperator + token;


    return fetch(url, options)
        .then(check401)
        .then(check404)
        .then(jsonParse)
        .then(errorMessageParse)
        .catch(catchError);
}

export default xFetch;
