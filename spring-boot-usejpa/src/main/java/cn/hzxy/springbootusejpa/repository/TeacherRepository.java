package cn.hzxy.springbootusejpa.repository;

import cn.hzxy.springbootusejpa.entity.NewTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Collection;
import java.util.List;

public interface TeacherRepository extends JpaRepository<NewTeacher,String> {
    List<NewTeacher> findByName(String name);
    List<NewTeacher> findByNameLike(String name);
    List<NewTeacher> findByIdIn(Collection<String> ids);
}
