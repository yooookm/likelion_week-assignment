package study.likelionbeweekly.week2.object;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Student student = new Student(i,"yoo");

            System.out.println("student = " + student);
            log.info("생성된 객체는 {} ",student);

            student.getInfo();
            student.goToSchool();
        }
    }
}
