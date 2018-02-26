package proxy;

public class UserInterceptor {
    public void before(){
        System.out.println("检查你是否有支付宝");
    }
    public void  after()
    {
        System.out.println("获取你的邮寄地址...........");
    }
}
