package aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

import java.lang.reflect.Method;

public class TestSpringAop {
    @Test
    public void demo2() {
        final ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new Person());

        final JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*run.*");

        Advice beforeAdvice = new MethodBeforeAdvice() {
            public void before(Method method, Object[] objects, Object o) throws Throwable {
                System.out.println("前有狼");
            }
        };

        Advice afterReturningAdvice = new AfterReturningAdvice() {
            public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
                System.out.println("后有虎");
            }
        };

        Advice interAdvice = new MethodInterceptor() {
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("前进");
                Object value = methodInvocation.proceed();
                System.out.println("后退");
                return value;
            }
        };
        Advisor beforeAdvisor = new DefaultPointcutAdvisor(pointcut, beforeAdvice);
        Advisor afterAdvisor = new DefaultPointcutAdvisor(pointcut,afterReturningAdvice);
        Advisor interAdvisor = new DefaultPointcutAdvisor(pointcut,interAdvice);

        factory.addAdvisors(interAdvisor,beforeAdvisor,afterAdvisor);

        Person p2 = (Person) factory.getProxy();
        p2.run();
        p2.run(1);
        p2.song();


    }
}
