package com.wm.controller;

import com.wm.po.Role;
import com.wm.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author cc
 * 角色控制器
 */
@Controller
public class RoleController {

    Logger logger=Logger.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;

    @GetMapping("/rolelist")
    public String roleList(Model model){
        logger.info("查看角色列表");
        List<Role> list=roleService.findAll();
        logger.info(list.size());
        model.addAttribute("list",list);
        return "backjsp/rolelist";
    }

    @GetMapping("/toupdaterole")
    public String toUpdateRole(int rid,Model model){
        logger.info(rid);
        Role role=roleService.findByRid(rid);
        model.addAttribute("role",role);
        return "backjsp/updaterole";
    }

    @PostMapping("/updaterolesave")
    public String updateRole(Role role,Model model){
        logger.info(role);
        if (roleService.findByRname(role.getRname()) != null&&!role.getRname().equals(roleService.findByRid(role.getRid()).getRname())) {
            model.addAttribute("role", role);
            model.addAttribute("mess", "该角色已存在！");
            return "backjsp/updaterole";
        }
        if (role.getRname() == "" || role.getRname() == null) {
            model.addAttribute("role", role);
            model.addAttribute("mess", "角色名称不能为空！");
            return "backjsp/updaterole";
        }
        roleService.update(role);
        return "redirect:/rolelist.action";
    }

    @GetMapping("/toaddrole")
    public String toAddRole(){
        logger.info("新增角色");
        return "backjsp/addrole";
    }

    @RequestMapping("/addrolesave")
    public String addRole(Role role,Model model){
        logger.info(role);
        if (role.getRname()=="" || role.getRname()==null){
            model.addAttribute("mess","角色名称不能为空");
            return "backjsp/addrole";
        }
        if(roleService.findByRname(role.getRname())!=null){
            model.addAttribute("mess","该角色已存在");
            return "backjsp/addrole";
        }
        roleService.add(role);
        return "redirect:/rolelist.action";
    }
}
