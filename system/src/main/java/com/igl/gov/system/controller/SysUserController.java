package com.igl.gov.system.controller;


import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.entity.SysUserInfo;
import com.igl.gov.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     *分页查询用户
     * @param request
     * @param userDto
     * @return
     */
    @RequestMapping("/list")
    public DataGridResult list(HttpServletRequest request, SysUserDto userDto){

        return  sysUserService.queryPageList(request,userDto);
    }


    /**
     * 保存用户
     * @param user
     * @param userInfo
     * @return
     */
    @RequestMapping("/save")
    public DataResult save(SysUser user, SysUserInfo userInfo){
        return  new DataResult(sysUserService.save(user,userInfo));
    }

    @RequestMapping("/delete")
    public DataResult delete(String ids){
         Integer count = sysUserService.delete("1");
          return new DataResult(true,null,"你删除了" + count + "条记录！");
    }

    @RequestMapping("/find")
    public DataResult find(Integer id){
      return  new DataResult(sysUserService.find(id),null);
    }
}
