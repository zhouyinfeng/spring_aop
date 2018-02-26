/*
package cglibproxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

public class UserProxy implements MethodInterceptor{

    // cglib使用Enhancer产生代理对象
    private Enhancer en = new Enhancer();

    public Object setObject(Class c) {
        // 设定目标类(需要代理的目标类)
        en.setSuperclass(c);

        //java回调机制   回调intercept方法
        en.setCallback(this);

        // 创建并产生代理对象
        Object obj=en.create();


        return obj;

    }

    private void   before()
    {
        System.out.println("----------前置-----------");
    }

    @Override
    public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
        // TODO Auto-generated method stub

        this.before();

        //调用目标对象
        Object  obj=arg3.invokeSuper(arg0, arg2);

        this.after();
        return obj;
    }

    private void   after()
    {
        System.out.println("----------后置-----------");
    }
}

*/
