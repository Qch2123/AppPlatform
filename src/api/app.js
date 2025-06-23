import {request} from '@/plugins/axios'

export function getAppInfoPage(data,pageNum) {
    return request({
        url: '/appInfo/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}

export function getDevUserPage(data,pageNum) {
    return request({
        url: '/devUser/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}

export function getBackendUserPage(data,pageNum) {
    return request({
        url: '/backendUser/page?pageNum='+pageNum,
        method: 'post',
        data: data
    })
}

export function getCategoryTree() {
    return request({
        url: '/appCategory/tree',
        method: 'get'
    })
}

export function validateApkName(apkname,id) {
    return request({
        url: '/appInfo/validateApkName?apkname='+apkname+'&id='+id,
        method: 'get'
    })
}

export function saveOrUpdateApp(data) {
    return request({
        url: '/appInfo/add',
        method: 'post',
        data:data
    })
}

export function getAppWithVersion(appid) {
    return request({
        url: '/appInfo/appWithVersion/'+appid,
        method: 'get'
    })
}

export function addVersion(formData) {
    return request({
        url: '/version',
        method: 'post',
        data:formData
    })
}

export function upOrOff(appid) {
    return request({
        url: '/appInfo/'+appid,
        method: 'put'
    })
}

export function delApp(id) {
    return request({
        url: '/appInfo/'+id,
        method: 'delete'
    })
}

export function loginApi(data) {
    return request({
        url: '/login',
        method: 'post',
        data:data
    })
}

export function regiser(data) {
    return request({
        url: '/register',
        method: 'post',
        data:data
    })
}

export function sayYes(appid) {
    return request({
        url: '/appInfo/examine?appId='+appid+"&opType=1",
        method: 'get'
    })
}

export function sayNo(appid) {
    return request({
        url: '/appInfo/examine?appId='+appid+"&opType=2",
        method: 'get'
    })
}