package aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * 纯java实现切面
 */
public class TestAop {
    @Test
    public void demo1() {
        //需要被代理的对象
        Person p = new Person();
        ProxyFactory proxyFactory = new ProxyFactory();//代理工厂
        proxyFactory.setTarget(p);//给代理工厂一个对象
        //构造切面
        //切面=切点+通知

        //切点
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern(".*run.*");//此处可以放一个正则表达式或者是需要被代理对象的路径
        //通知
        Advice advice = new MethodInterceptor() {
            public Object invoke(MethodInvocation methodInvocation) throws Throwable {
                System.out.println("拦在前面");
                Object obj = methodInvocation.proceed();
                System.out.println("拦在后面");
                return obj;
            }
        };

        Advisor advisor = new DefaultPointcutAdvisor(pointcut,advice);
        proxyFactory.addAdvisor(advisor);
        Person p2 = (Person) proxyFactory.getProxy();//给代理工厂一个切面
        p2.run();
        p2.song();
        p2.run(11);


    }

}
