package proxy;

import proxy.UserInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyObjectOne implements InvocationHandler {

    // 代理的目标对象
    private Object targetObject;

    //切面类
    private  UserInterceptor  interceptorObject;


    public void setObject(Object targetObject, UserInterceptor interceptorObject) {
        this.targetObject = targetObject;
        this.interceptorObject=interceptorObject;
    }

    public Object bindObject() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub


        interceptorObject.before();

        // 执行目标方法
        Object obj = method.invoke(targetObject, args);

        interceptorObject.after();

        return obj;
    }



}
