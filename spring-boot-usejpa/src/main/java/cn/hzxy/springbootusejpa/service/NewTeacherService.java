package cn.hzxy.springbootusejpa.service;

import cn.hzxy.springbootusejpa.entity.NewTeacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface NewTeacherService {
    NewTeacher findById(String id);
    List<NewTeacher> findAll();
    NewTeacher save(NewTeacher newTeacher);
    void delete(String id);

    Page<NewTeacher> findAll(Pageable pageable);

    List<NewTeacher> findByName(String name);
    List<NewTeacher> findByNameLike(String name);
    List<NewTeacher> findByIdIn(Collection<String> ids);
}