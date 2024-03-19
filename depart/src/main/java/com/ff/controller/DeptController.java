package com.ff.controller;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.ff.domain.SysDept;
import com.ff.service.SysDeptService;
import com.ff.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dept")
@CrossOrigin
public class DeptController {
    @Autowired
    SysDeptService deptService;

    @RequestMapping("list")
    public Result list(){
        List<SysDept> list = deptService.list();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();

//转换器 (含义:找出父节点为字符串零的所有子节点, 并递归查找对应的子节点, 深度最多为 3)
        List<Tree<String>> build = TreeUtil.build(list, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getDeptId().toString());
                    tree.setParentId(treeNode.getParentId().toString());
                    // 扩展属性 ...
                    tree.putExtra("deptId", treeNode.getDeptId());
                    tree.putExtra("deptName", treeNode.getDeptName());
                    tree.putExtra("leader", treeNode.getLeader());
                    tree.putExtra("phone", treeNode.getPhone());
                    tree.putExtra("email", treeNode.getEmail());
                    tree.putExtra("status", treeNode.getStatus());
                    tree.putExtra("createTime", treeNode.getCreateTime());
                });

        return Result.success(build);
    }

    @RequestMapping("update")
    public Result update(@RequestBody SysDept dept){
         deptService.updateById(dept);
        return Result.success("修改完成");
    }

    @RequestMapping("save")
    public Result save(@RequestBody SysDept dept){
         deptService.save(dept);
        return Result.success("添加完成");
    }

    @RequestMapping("delete")
    public void save(String id){

        deptService.removeById(id);

    }
}
