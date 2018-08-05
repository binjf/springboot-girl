package com.binjf.demo.repository;

import com.binjf.demo.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Girl 持久层接口
 *
 * @author Sky
 * @create 2018-08-04 下午5:47
 **/
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    /**
     * 扩展：通过年龄查询girl
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);

}
