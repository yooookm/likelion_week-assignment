package study.likelionbeweekly.week2.singleton;

public class SynchronizedSingleton {

    private volatile static SynchronizedSingleton instance = null;

    private SynchronizedSingleton() {
    }

    // 방법 1 synchronized 메소드 선언
    // private static SynchronizedSingleton instance = null;
    public static synchronized SynchronizedSingleton getInstance1() {
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }


    // 방법 2 DCL(Double Checked Locking) 방식
    public static synchronized SynchronizedSingleton getInstance2() {
        if (instance == null) {
            synchronized (SynchronizedSingleton.class) {
                if (instance == null) {
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }


    // 방법 3 DCL 방식에 volatile 키워드 사용
    /* 앞서 volatile 키워드 붙여서 멤버변수 선언 */
    public static synchronized SynchronizedSingleton getInstance() {
        if (instance == null) {
            synchronized (SynchronizedSingleton.class) {
                if (instance == null) {
                    instance = new SynchronizedSingleton();
                }
            }
        }
        return instance;
    }
}
