package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyObjectTwo implements InvocationHandler {

    // 代理的目标对象
    private Object targetObject;

    // 切面类
    private Object interceptorObject;

    public void setObject(Object targetObject, Object interceptorObject) {
        this.targetObject = targetObject;
        this.interceptorObject = interceptorObject;
    }

    public Object bindObject() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub

        // 执行目标方法
        //面向对象编程的局限
        //interceptorObject.before();

        Method bm = this.interceptorObject.getClass().
                getDeclaredMethod("before", null);

        bm.invoke(interceptorObject, null);
        // 执行目标方法
        Object obj = method.invoke(targetObject, args);

        Method am = this.interceptorObject.getClass().getDeclaredMethod("after", null);

        am.invoke(interceptorObject,  null);
        return obj;
    }

}