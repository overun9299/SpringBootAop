package soap.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import soap.vo.Car;

import java.lang.reflect.Method;

/**
 * 方法日志切面
 */


//标识这是一个切面
@Aspect
//交给spring容器管理
@Component
public class MethodLogAspect {

    private final static Logger logger = LoggerFactory.getLogger(MethodLogAspect.class);


    @Pointcut("@annotation(soap.aspect.MethodLogAnnotation)")
    public void addAdvice() {

    }

    @Around("addAdvice()")
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;

        /** 入参 **/
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            Car car = (Car) arg;
            System.out.println(car.toString());
            car.setName("我被修改了");
        }


        /** 请求方法,并打印出参 **/
        result = pjp.proceed();
        System.out.println(result);


        /** 获取类的字节码对象，通过字节码对象获取方法信息 **/
        Class<?> targetCls=pjp.getTarget().getClass();
        /** 获取方法签名(通过此签名获取目标方法信息) **/
        MethodSignature ms=(MethodSignature)pjp.getSignature();
        /** 获取目标方法上的注解指定的操作名称 **/
        Method targetMethod= targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
        System.out.println("targetMethod="+targetMethod);

        /** 获取目标方法名(目标类型+方法名) **/
        String targetClsName=targetCls.getName();
        System.out.println(targetClsName);

        /** 获取注解参数 **/
        Method method = ms.getMethod();
        MethodLogAnnotation annotation = method.getAnnotation(MethodLogAnnotation.class);
        System.out.println(annotation.value());

        return result;
    }
}
