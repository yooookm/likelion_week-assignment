package study.likelionbeweekly.week2.singleton;

public class SingletonTest {

    public static void main(String[] args) {
        // 스레드 100개로 동시에 싱글톤 생성
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SynchronizedSingleton instance = SynchronizedSingleton.getInstance();
                    System.out.println("인스턴스 해시코드: " + instance.hashCode());
                }
            }).start();
        }
    }
}
