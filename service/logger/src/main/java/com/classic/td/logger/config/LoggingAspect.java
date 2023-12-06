package com.classic.td.logger.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void requestMappingLog(JoinPoint jp) {
        String args = argsToString(jp.getArgs());
        log.info("Post Request, path: {}, args: values: {}", extractMappingValue(jp), args);
    }
    private String extractMappingValue(JoinPoint joinPoint) {
        PostMapping postMapping = getPostMappingAnnotation(joinPoint);
        return (postMapping != null) ? postMapping.value()[0] : "";
    }
    private PostMapping getPostMappingAnnotation(JoinPoint joinPoint) {
        try {
            return joinPoint.getTarget()
                    .getClass()
                    .getMethod(joinPoint.getSignature().getName(), ((org.aspectj.lang.reflect.MethodSignature) joinPoint.getSignature()).getParameterTypes())
                    .getAnnotation(PostMapping.class);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
    private String argsToString(Object[] args) {
        if (args == null || args.length == 0) {
            return "No arguments";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Object arg : args) {
            stringBuilder.append(arg.toString()).append(", ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
