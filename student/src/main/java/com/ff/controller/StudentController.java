package com.ff.controller;

import com.baomidou.mybatisplus.extension.conditions.update.UpdateChainWrapper;
import com.ff.domain.Scope;
import com.ff.domain.Student;
import com.ff.domain.Subject;
import com.ff.service.ScopeService;
import com.ff.service.StudentService;
import com.ff.service.SubjectService;
import com.ff.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("student")
@CrossOrigin
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("AllList")
    public Result AllList(){

       List<Student> list = studentService.listAll();

       return Result.success(list);
    }

    @Autowired
    ScopeService scopeService;
    @RequestMapping("checkLi")
    public Result checkli(){

        List<Scope> list = scopeService.list();

        return Result.success(list);

    }

    @Autowired
    SubjectService subjectService;

    @RequestMapping("save")
    public void save(Student student){

        boolean save = studentService.save(student);

        if (save){

            List<Integer> allscopeId = student.getAllscopeId();

            Integer id = student.getId();

            for (Integer i : allscopeId) {

                subjectService.savesId(i,id);

            }
        }

    }


    @RequestMapping("Exscope")
    public Map Exscope(){

        ArrayList x = new ArrayList();
        ArrayList y = new ArrayList();
        HashMap map = new HashMap();

        List<Subject> list = subjectService.Exlist();

        for (Subject subject : list) {

            if (subject.getX().equals("1")){
                x.add("语文");
            }
            if (subject.getX().equals("2")){
                x.add("计算机");
            }
            if (subject.getX().equals("3")){
                x.add("毛概");
            }
            if (subject.getX().equals("4")){
                x.add("体育");
            }
            y.add(subject.getY());

        }

        map.put("x",x);
        map.put("y",y);

        return map;
    }

    @RequestMapping("del")
    public void delMes(String id){

        studentService.removeById(id);

    }

    //回显
    @RequestMapping("huixian")
    public Result huixian(String id){
        //查看该同学的课程信息
        List<Student> list =  studentService.echoStudent(id);

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (Student student : list) {
            arrayList.add(student.getCid());
        }
        //看看该同学其他信息
        Student byId = studentService.getById(id);
        byId.setAllscopeId(arrayList);

        return Result.success(byId);
    }

    @RequestMapping("update")
    public void update(Student student){

        studentService.updateById(student);

        ArrayList list = new ArrayList();

        List<Integer> allscopeId = student.getAllscopeId();
        subjectService.removeStudentById(student.getId());

        for (Integer i : allscopeId) {

            subjectService.savesId(i,student.getId());

        }

        UpdateChainWrapper<Subject> update = subjectService.update();
        boolean update1 = update.update();



    }

    @RequestMapping("scopetype")
    public Result scopetype(){

        List<Scope> list = scopeService.list();

        return Result.success(list);

    }

}
