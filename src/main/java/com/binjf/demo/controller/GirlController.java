package com.binjf.demo.controller;

import com.binjf.demo.entity.Girl;
import com.binjf.demo.entity.Result;
import com.binjf.demo.repository.GirlRepository;
import com.binjf.demo.service.GirlService;
import com.binjf.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Girl控制器
 *
 * @author Sky
 * @create 2018-08-04 下午5:28
 **/
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

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
     * 添加girl--新增校验年龄大于18
     * @param girl
     * @param bindingResult 校验结果
     * @return
     */
    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        //1 对年龄进行校验-不通过校验
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        //2 校验通过处理
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());

        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 根据id查找girl
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
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
    @PutMapping("/girls/{id}")
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
    @DeleteMapping("/girls/{id}")
    public void deleteGirlById(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询girl列表
     * @param age
     * @return
     */
    @GetMapping("/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    /**
     * 插入2个Girl-事务
     */
    @PostMapping("/girls/two")
    public void insertTwo(){
        girlService.insertTwo();
    }

    /**
     * 当抛出异常时，返回的数据结构不是Result类型，因此使用ExceptionHandle处理
     * @param id
     * @throws Exception
     */
    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }

}
