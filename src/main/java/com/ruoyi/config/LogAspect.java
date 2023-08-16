package com.ruoyi.config;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.dao.model.SystemLogDto;
import com.ruoyi.service.SystemLogService;
import com.ruoyi.util.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Slf4j
@Aspect
@Component("saveLogAspect")
public class LogAspect {

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private SystemLogService systemLogService;

    private static final String CHARACTERS = "ZXCVBNMASDFGHJKLQWERTYUIOP";
    private static final int STRING_LENGTH = 16;


    // 第一个*代表返回类型不限
    // 第二个*代表所有类
    // 第三个*代表所有方法
    // (..) 代表参数不限
    @Before(value = "execution(* com.ruoyi.controller.*.*(..))")
    public void beforeUserMethod(JoinPoint joinPoint){
       try {
           ServletRequestAttributes requestAttributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
           HttpServletRequest request = requestAttributes.getRequest();
           String randomStr = generateRandomString();
           String requestUidKey = "thredRequestId_" + System.currentTimeMillis();
           log.info("redis key  | {}",requestUidKey);
           redisUtils.set(requestUidKey,randomStr, NumberUtils.LONG_ONE);
           request.setAttribute("requestId",requestUidKey);
           String remoteHost = request.getRemoteHost();
           String remoteUser = request.getRemoteUser();
           String requestIp = getRequestIp(request);
           String requestURI = request.getRequestURI();
           Object[] requestParam = joinPoint.getArgs();

           String methodName = joinPoint.getSignature().getName();
           Object arg = requestParam[0];
           String methodParams = JSONObject.toJSONString(arg);
           SystemLogDto build = SystemLogDto.builder()
                   .func(methodName)
                   .param(methodParams)
                   .loginIp(requestIp)
                   .serviceName(remoteHost)
                   .requestUId(randomStr)
                   .loginId(ObjectUtil.isEmpty(remoteUser) ? 0L : Long.parseLong(remoteUser))
                   .describe(requestUidKey)
                   .build();
           systemLogService.add(build);
           System.out.println("before.......");
       }catch (RuntimeException e){
           log.error("exception |{}",e.getMessage(),e);
           e.printStackTrace();
       }

    }

    public String getRequestIp(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        if( "0:0:0:0:0:0:0:1".equals(ip) ){
            return "127.0.0.1";
        }else {
            return ip;
        }
    }

    /**
     * 随机生成16位
     * @return
     */
    public static String generateRandomString() {
        StringBuilder stringBuilder = new StringBuilder(STRING_LENGTH);
        Random random = new Random();

        for (int i = 0; i < STRING_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }
        log.info("generateRandomString uuid | {}",stringBuilder.toString());
        return stringBuilder.toString();
    }
}
