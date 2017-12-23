package org.yangdongdong.springcloud.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.yangdongdong.springcloud.RetryApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RetryApplication.class)
public class RetryServiceTest {

    @Autowired
    private RetryService retryservice;

    @Test
    public void testCall() throws Exception{
        retryservice.call();
    }

}
