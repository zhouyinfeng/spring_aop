package proxy;

public class Test {


    public static void main(String[] args) {

        //代理对象
//		ProxyObject po = new ProxyObject();

//		//设置代理类的代理的目标类  代理相亲业务
//
//		SHYGril  shy=new  SHYGril();
//		po.setObject(shy);
//
//		/**
//		 * 1.代理对象
//		 * 2.目标类对象
//		 *
//		 *
//		 */
//
//		//动态产生代理对象
////		IGril  g=(IGril)Proxy.newProxyInstance(po.getClass().getClassLoader(),
////				shy.getClass().getInterfaces(), po);
//
//		IGril  g=(IGril)po.bindObject();
//
//		g.talk("欢迎大家来到相亲的现场........");


        //2.代理买书
        //目标类
        AlibabaBook  albook = new AlibabaBook();

        //代理类
        ProxyObjectTwo  poOne =new ProxyObjectTwo();

        //代理类设置目标类和切面类
        poOne.setObject(albook, new UserInterceptor());

//
        IBook  book=(IBook)poOne.bindObject();
        book.buyBook();
    }
}
