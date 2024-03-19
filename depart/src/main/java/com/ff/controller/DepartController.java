package com.ff.controller;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.ff.domain.Depart;
import com.ff.service.DepartService;
import com.ff.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("depart")
@CrossOrigin
public class DepartController {

    @Autowired
    DepartService departservice;
    @RequestMapping("list")
    public Result getlist(){
        List<Depart> list = departservice.list();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();

//转换器 (含义:找出父节点为字符串零的所有子节点, 并递归查找对应的子节点, 深度最多为 3)
        List<Tree<String>> build = TreeUtil.build(list, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId().toString());
                    tree.setParentId(treeNode.getParentId().toString());
                    // 扩展属性 ...
                    tree.putExtra("type", treeNode.getType());
                    tree.putExtra("name", treeNode.getName());
                    tree.putExtra("level", treeNode.getLevel());
                    tree.putExtra("place", treeNode.getPlace());
                    tree.putExtra("id", treeNode.getId());
                    tree.putExtra("creatTime", treeNode.getCreatTime());
                });

        return Result.success(build);
    }






    @RequestMapping("del")
    public Result del(Integer id){

        departservice.removeById(id);
        return Result.success("删除成功");
    }

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("save")
    public Result save(Depart depart){

        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("depart", depart, 5, TimeUnit.MINUTES);

        if (aBoolean){
            // 设置成功
            departservice.save(depart);
            return Result.success("提交成功");
        }else {
            // 设置失败
            return Result.fail("请勿重复提交");
        }

    }

    @RequestMapping("queryById")
    public Result queryById(Depart depart){

        boolean b = departservice.updateById(depart);

        if (b){
            return Result.success("修改成功");
        }else {
            return Result.fail("修改失败");
        }

    }

    @RequestMapping("updatemes")
    public Result updatemes(Depart depart){

        departservice.updateById(depart);

        return Result.success("修改成功");
    }

}
