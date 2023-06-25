package cn.hzxy.springbootusejpa.controller;

import cn.hzxy.springbootusejpa.entity.NewTeacher;
import cn.hzxy.springbootusejpa.service.NewTeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/newTeacher")
public class NewTeacherController {
    @Resource
    private NewTeacherService newTeacherService;

    @RequestMapping("/test")
    public String test(Model model){
        List<NewTeacher> newTeacherList= newTeacherService.findAll();
        model.addAttribute("newTeachers",newTeacherList);
        return "newTeacher";
    }
}
