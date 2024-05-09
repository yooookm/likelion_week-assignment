package study.likelionbeweekly.week2.singleton;

public class Singleton {
//  방법 1.
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }

//   방법 2.
//    public static Singleton getInstance() {
//        if(INSTANCE == null) {
//            INSTANCE = new Singleton();
//        }
//        return INSTANCE;
//    }

}
