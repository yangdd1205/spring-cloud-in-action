package org.yangdongdong.springcloud.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    // 方法：需要进行重试[远程调动服务失败的情况，再次进行调用]
    @Retryable(value = { RemoteAccessException.class }, // value：什么样的异常进行重试策略的执行
            maxAttempts = 4, // maxAttempts：重试次数 包含首次调用失败 默认值：3
            backoff = @Backoff(delay = 2000, multiplier = 2)) // delay：间隔 multiplier：递增倍数（即下次间隔是上次的多少倍）
    public void call() throws Exception {
        System.err.println("时间：" + (System.currentTimeMillis() / 1000) + " 调用了 call 方法执行。。。。");
        throw new RemoteAccessException("RPC 调用异常");
    }

    @Recover
    public void revocer(RemoteAccessException e) {
        System.err.println("------ 最终处理 ------：" + e.getMessage());
    }
}
