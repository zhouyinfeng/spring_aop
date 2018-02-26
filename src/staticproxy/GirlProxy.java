package staticproxy;

public class GirlProxy  implements  IGirl{
    private IGirl girl;
    //代理对象的构造函数，指向代理的真实类
    public GirlProxy(IGirl gril){
        this.girl=gril;
    }
    @Override
    public void talk() {

        //前置通知
        this.before();
        this.girl.talk();
        this.after();
    }

    private void after() {
        System.out.println("------after------");
    }

    private void before() {
        System.out.println("------before------");
    }
}
