package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//jdk动态代理提供的代理父接口
public class ProxyObject implements InvocationHandler {

    // 代理的目标对象
    private Object targetObject;

    // public ProxyObject(Object targetObject) {
    // this.targetObject = targetObject;
    // }

    public void setObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object bindObject() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub

        // 调用前置
        this.before();

        System.out.println("代理的目标对象-->" + targetObject.getClass());
        System.out.println("代理的目标方法-->" + method.getName());

        //System.out.println("目标方法的参数为-->" + args[0]);

        // 执行目标方法
        Object obj = method.invoke(targetObject, args);


        // 调用后置
        this.after();

        return obj;
    }

    // 切面的方法
    public void before() {
        System.out.println("前置通知..................");

    }

    public void after() {

        System.out.println("后置通知.....................");

    }

}
