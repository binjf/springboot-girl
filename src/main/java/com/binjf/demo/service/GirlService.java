package com.binjf.demo.service;

import com.binjf.demo.entity.Girl;
import com.binjf.demo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * girl Service层-事务
 *
 * @author Sky
 * @create 2018-08-05 上午9:16
 **/
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 事务管理
     */
    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("C");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BB");
        girlRepository.save(girlB);
    }

}
