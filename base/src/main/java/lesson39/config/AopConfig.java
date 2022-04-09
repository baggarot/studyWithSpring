package lesson39.config;

import lesson39.dao.CarDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AopConfig {

    public Pointcut simpleLoggingAspectPointcut() {
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return clazz -> clazz.equals(CarDaoImpl.class);
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return MethodMatcher.TRUE;
            }
        };
    }

    MethodBeforeAdvice simpleLoggingAspectBeforeAdvice() {
        return (method, objects, o) -> log.info("Вызов метода : " + method.getName());
    }

    @Bean
    public DefaultPointcutAdvisor personDaoSimpleLoggingAspectAdvisor() {
        return new DefaultPointcutAdvisor(simpleLoggingAspectPointcut(), simpleLoggingAspectBeforeAdvice());
    }
}
