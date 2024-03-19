package com.ff.controller;

import com.ff.domain.Miss;
import com.ff.service.MissService;
import com.ff.utils.Result;
import com.ff.utils.SmsUtils;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("miss")
@CrossOrigin//解决跨域问题
public class AllMissController {

    @Autowired
    MissService missService;

    @RequestMapping("queryAll")
    public Result query(){

        List<Miss> list = missService.list();

        return Result.success(list);
    }

    @RequestMapping("del")
    public Result del(Integer id){

        missService.removeById(id);
        return Result.success("删除成功");
    }

    @RequestMapping("save")
    public Result save(Miss miss){

        missService.save(miss);

        return Result.success("添加成功");
    }

    @RequestMapping("updatemes")
    public Result updatemes(Miss miss){

        missService.updateById(miss);

        return Result.success("修改成功");
    }

    @RequestMapping("selectEx")
    public Map selectEx(){

        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();

        HashMap map = new HashMap();

        List <Miss> list = missService.selectEx();
        for (Miss miss : list) {

            x.add(miss.getXdata());
            y.add(miss.getYdata());

        }

        map.put("x",x);
        map.put("y",y);

        return map;
    }

    @RequestMapping("selectYear")
    public Map selectYear(){

        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();

        HashMap map = new HashMap();

        List <Miss> list = missService.selectYear();
        for (Miss miss : list) {

            x.add(miss.getX()+"年");
            y.add(miss.getY());

        }

        map.put("x",x);
        map.put("y",y);

        return map;
    }


    @Autowired
    JavaMailSender javaMailSender;

    @XxlJob("birthdaysend")
    @RequestMapping("today")
    public void sendmes(){

        List<Miss> list = missService.list();
        for (Miss miss : list) {

            if (miss.getBirthday().getMonth()==new Date().getMonth() && miss.getBirthday().getDay()==new Date().getDay()){

                SmsUtils.sendSms(miss.getTel(),"今天是你生日，祝ni生日快乐","2");

                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom("2329856431@qq.com");
                simpleMailMessage.setSentDate(new Date());
                simpleMailMessage.setTo("2329856431@qq.com");
                simpleMailMessage.setText("Fu~生日快乐");
                simpleMailMessage.setSubject("生日祝福");

                javaMailSender.send(simpleMailMessage);

            }

        }

    }

}
