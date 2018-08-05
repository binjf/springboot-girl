package com.binjf.demo.controller;

import com.binjf.demo.entity.Girl;
import com.binjf.demo.repository.GirlRepository;
import com.binjf.demo.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Girl控制器
 *
 * @author Sky
 * @create 2018-08-04 下午5:28
 **/
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 获取所有的girl
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加girl
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping("/addGirl")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize, @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 根据id查找girl
     * @param id
     * @return
     */
    @GetMapping("/girl/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepository.findById(id).orElse(null);
    }

    /**
     * 更新girl
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/updateGirl/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 根据id删除girl
     * @param id
     */
    @DeleteMapping("/deleteGirl/{id}")
    public void deleteGirlById(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询girl列表
     * @param age
     * @return
     */
    @GetMapping("/findGirlsByAge/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 插入2个Girl-事务
     */
    @PostMapping("/insertTwo")
    public void insertTwo(){
        girlService.insertTwo();
    }

}
