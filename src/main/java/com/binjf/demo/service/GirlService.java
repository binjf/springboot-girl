package com.binjf.demo.service;

import com.binjf.demo.entity.Girl;
import com.binjf.demo.enums.ResultEnum;
import com.binjf.demo.exception.GirlException;
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

    /**
     * 根据id获取该girl的年龄，当age小于16时抛出异常信息
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if(age < 10){
            //返回“你还在上小学吧” code=100
            //throw new Exception("你还在上小学吧");
            //throw new GirlException(100, "你还在上小学吧");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            //返回“你可能在上初中” code=101
            //throw new Exception("你可能在上初中");
            //throw new GirlException(101, "你可能在上初中");
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

    }

    /**
     * 通过id查询Girl的信息
     * @param id
     * @return
     */
    public Girl findGirlById(Integer id){
        return girlRepository.findById(id).orElse(null);
    }

}
