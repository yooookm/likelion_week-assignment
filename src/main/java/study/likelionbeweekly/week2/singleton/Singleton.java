package study.likelionbeweekly.week2.singleton;

public class Singleton {
//  방법 1.
    private static final Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

//   방법 2.
//    private static final Singleton INSTANCE
//    public static Singleton getInstance() {
//        if(instance == null) {
//            INSTANCE = new Singleton();
//        }
//        return INSTANCE;
//    }
}
