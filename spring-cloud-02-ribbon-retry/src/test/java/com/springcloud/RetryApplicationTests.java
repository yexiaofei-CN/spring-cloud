package com.springcloud;

import com.springcloud.service.IndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RetryApplicationTests {

    @Autowired
    private IndexService indexService;

    @Test
    public void testRetry() throws Exception {
        indexService.call();
    }

}
