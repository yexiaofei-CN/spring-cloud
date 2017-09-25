package com.springcloud.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by yxf on 2017/9/11.
 */
@Service
public class IndexService {

     @Retryable(value = {RemoteAccessException.class}, //value 意思什么样得异常重试策略得执行
     maxAttempts = 3, //重试次数
     backoff = @Backoff(delay = 5000,multiplier = 5)) //delay间隔 multiplier线程数
     public void call()throws  Exception{
         System.err.println("调用call 方法...");
         throw  new RemoteAccessException("RPC调用异常");
     }

     @Recover //做最终失败得补偿
    public void recover(RemoteAccessException e){
         System.err.println("-------------最终处理--------------message"+ e.getMessage());
     }
}
