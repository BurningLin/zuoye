package cn.hzxy.springbootusejpa;

import cn.hzxy.springbootusejpa.entity.NewTeacher;
import cn.hzxy.springbootusejpa.service.NewTeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SpringBootUsejpaApplicationTests {

    @Resource
    private NewTeacherService newTeacherService;

    @Test
    public void testTransaction(){
        NewTeacher newTeacher=new NewTeacher();
        newTeacher.setId("5");
        newTeacher.setName("张小琨");
        newTeacher.setPassword("111111");
        newTeacherService.save(newTeacher);
    }

    @Test
    public void testRepository(){
        List<NewTeacher> teacherList= newTeacherService.findAll();
        System.out.println("findAll():"+teacherList.size());

        List<NewTeacher> teacherList2=newTeacherService.findByName("马驰");
        System. out.println("findByName():"+teacherList2.size());
        Assert.isTrue(teacherList2.get(0).getName().equals("马驰"),"data error");

        List<NewTeacher> teacherList3=newTeacherService.findByNameLike("%张%");
        System.out.println("findByNameLike():"+teacherList3.size());
        System.out.println("第一条记录是:"+teacherList3.get(0).getName());
        System.out.println("第二条记录是:"+teacherList3.get(1).getName ());
        Assert.isTrue(teacherList3.get(0).getName().equals("张晓欢"),"data error");

        List<String> ids =new ArrayList<String>();
        ids.add("1");
        ids.add("3");
        List<NewTeacher> teacherList4=newTeacherService.findByIdIn(ids);
        System.out.println("findByIdIn():"+teacherList4.size());

        PageRequest pageRequest =PageRequest.of(0,10);
        Page<NewTeacher> teacherList5=newTeacherService.findAll(pageRequest);
        System.out.println ("page findAl1():"+teacherList5.getTotalPages()+"/"+teacherList5.getSize());

        NewTeacher newTeacher=new NewTeacher();
        newTeacher.setId("4");
        newTeacher.setName("彭小刚");
        newTeacher.setPassword("000000");
        newTeacherService.save(newTeacher);
    }
}
