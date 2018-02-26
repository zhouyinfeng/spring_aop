package staticproxy;

public class Test {
    public static void main(String[] args){
    IGirl g = new GirlProxy(new SHYGirl());
        g.talk();
    }
}
