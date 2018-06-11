const APIV1 = '/api/v1'
const APIV2 = '/api/v2'
const DOMIN = 'http://127.0.0.1:8001'
// const DOMIN = 'http://101.200.42.185:8001'

module.exports = {
  name: 'Team Admin',
  prefix: 'team',
  footerText: 'Admin  © 2017 TEAM',
  logo: '/logo.svg',
  iconFontCSS: '/iconfont.css',
  iconFontJS: '/iconfont.js',
  CORS: [],
  openPages: ['/login'],
  apiPrefix: '/api/v1',
  APIV1,
  APIV2,
  api: {
    userLogin: `${APIV1}/user/login`,
    userLogout: `${APIV1}/user/logout`,
    user: `${APIV1}/user/:id`,
    dicListByDictNo: `${DOMIN}/api/sysdict/dictlistbydictno/:dictNo`,
    dicList: `${DOMIN}/api/sysdict/pagelist`,
    dicSave: `${DOMIN}/api/sysdict/save`,
    dicDelete: `${DOMIN}/api/sysdict/delete`,
    dicMultiDelete: `${DOMIN}/api/sysdict/multiDelete`,
    //组织
    organizationList: `${DOMIN}/api/sysorg/pagelist`,
    organizationDel: `${DOMIN}/api/sysorg/delete`,
    organizationSave: `${DOMIN}/api/sysorg/save`,
    // 角色组织
    roleOrganizationList: `${DOMIN}/api/sysroleorg/pagelist`,
    roleOrganizationBind: `${DOMIN}/api/sysroleorg/bind`,
    roleOrganizationListBind: `${DOMIN}/api/sysroleorg/bindlist`,
    roleOrganizationDel: `${DOMIN}/api/sysroleorg/delete`,
    //模块
    moduleList: `${DOMIN}/api/sysmodule/pagelist`,
    moduleDel: `${DOMIN}/api/sysmodule/delete`,
    moduleSave: `${DOMIN}/api/sysmodule/save`,
0    userSave: `${DOMIN}/api/sysuser/save`,
    userDelete: `${DOMIN}/api/sysuser/delete`,
    userList: `${DOMIN}/api/sysuser/pagelist`,
    menus: `${DOMIN}/api/sysrolemodule/queryrolemodulebyroleid`,
  },
}
