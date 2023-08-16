package com.ruoyi.event;


import com.ruoyi.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *实现redis过期key的监听 重写KeyspaceEventMessageListener 的onMessage方法
 */
@Slf4j
@Component
public class RedisMessageListener extends KeyExpirationEventMessageListener {
    @Resource
    private RedisUtils redisUtils;


    public RedisMessageListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern){
        log.info("expire key message | {}",message);
        /**
         * 如果redis是主从复制的情况下。或者是集群的模式下 会出现过期的key发送多次事件给订阅者
         * 因此在实现接受到事件时。需要对当前或者的key进行加锁 保证这个key不会被其他的服务或者线程消费
         * 当对应的业务处理完成以后一定进行释放key的锁
         * 具体案例可以参考
         * https://blog.csdn.net/m0_46652188/article/details/130394856?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522169217005416800186585165%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=169217005416800186585165&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-2-130394856-null-null.142^v92^control&utm_term=redis%E8%BF%87%E6%9C%9F%E6%80%8E%E4%B9%88%E9%80%9A%E7%9F%A5%E8%AE%A2%E9%98%85%E8%80%85&spm=1018.2226.3001.4187
         */

    }
}
