package study.likelionbeweekly.week2.singleton;

public class SynchronizedSingletone {

    private volatile static SynchronizedSingletone instance = null;

    private SynchronizedSingletone() {
    }

    // 방법 1 synchronized 메소드 선언
    /*
    private static SynchronizedSingletone instance = null;

    public static synchronized SynchronizedSingletone getInstance1() {
        if (instance == null) {
            instance = new SynchronizedSingletone();
        }
        return instance;
    }
     */

    // 방법 2 DCL(Double Checked Locking) 방식
    /*
    public static synchronized SynchronizedSingletone getInstance2() {
        if (instance == null) {
            synchronized (SynchronizedSingletone.class) {
                if (instance == null) {
                    instance = new SynchronizedSingletone();
                }
            }
        }
        return instance;
    }
     */

    // 방법 3 DCL 방식에 volatile 키워드 사용
    /* 앞서 volatile 키워드 붙여서 멤버변수 선언 */
    public static synchronized SynchronizedSingletone getInstance2() {
        if (instance == null) {
            synchronized (SynchronizedSingletone.class) {
                if (instance == null) {
                    instance = new SynchronizedSingletone();
                }
            }
        }
        return instance;
    }
}
