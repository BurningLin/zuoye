package cn.hzxy.springbootusejpa.service.impl;

import cn.hzxy.springbootusejpa.entity.NewTeacher;
import cn.hzxy.springbootusejpa.repository.TeacherRepository;
import cn.hzxy.springbootusejpa.service.NewTeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


import java.util.Collection;
import java.util.List;


@Service
public class NewTeacherServiceImpl implements NewTeacherService{
    @Resource(name="teacherRepository")
    private TeacherRepository teacherRepository;

    @Override
    public NewTeacher findById(String id){
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<NewTeacher> findAll(){
        List<NewTeacher> newTeacherList=teacherRepository.findAll();
        return newTeacherList;
    }

    @Override
    public NewTeacher save(NewTeacher newTeacher){
        return teacherRepository.save(newTeacher);
    }

    @Override
    public void delete(String id){
        teacherRepository.deleteById(id);
    }

    @Override
    public Page<NewTeacher> findAll(Pageable pageable){
        return teacherRepository.findAll(pageable);
    }

    @Override
    public List<NewTeacher> findByName(String name){
        return teacherRepository.findByName(name);
    }

    @Override
    public List<NewTeacher> findByNameLike(String name){
        return teacherRepository.findByNameLike(name);
    }

    @Override
    public List<NewTeacher> findByIdIn(Collection<String> ids){
        return teacherRepository.findByIdIn(ids);
    }
}
