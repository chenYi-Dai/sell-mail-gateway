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

    }
}
