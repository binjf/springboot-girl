package com.binjf.demo.service;

import com.binjf.demo.entity.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * GirlService测试类。可以通过选择某个要测试的方法--go to 直接自动生成测试类
 *
 * @author Sky
 * @create 2018-08-05 下午9:36
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void testindGirlById(){
        Girl girl = girlService.findGirlById(1);
        //使用断言
        Assert.assertEquals(new Integer(3), girl.getAge());
    }

}
