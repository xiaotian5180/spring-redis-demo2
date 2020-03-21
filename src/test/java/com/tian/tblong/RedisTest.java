package com.tian.tblong;

import com.tian.tblong.init.InitConfiguretion;
import com.tian.tblong.service.RedisService;
import org.junit.Test;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Copyright: Copyright (c) 2019 XXX有限公司
 *
 * @ClassName: com.tian.tblong.RedisTest
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: tblong
 * @date: 2020/3/8 13:09
 * <p>
 * Modification History:
 * Date            Author          Version         Description
 * -------------------------------------------------------------*
 * 2020/3/8     tblong           v1.0.0            新建
 */
public class RedisTest {

    @Test
    public void startRedis(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(InitConfiguretion.class);

        RedisService redisService = (RedisService) applicationContext.getBean("redisService");
        if(redisService != null){
            redisService.set("EFG", "987654");
            System.out.println("----->" + redisService.get("EFG"));
        }
    }

    @Test
    public void testExpired(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(InitConfiguretion.class);

        RedisService redisService = (RedisService) applicationContext.getBean("redisService");
        if(redisService != null){
            String info = redisService.getInfo();
            System.out.println(info);
            //第二次是从缓存中获取的，可以看到getInfo方法内的日志没有输出
            String info2 = redisService.getInfo();
            System.out.println(info2);
        }

    }

}
