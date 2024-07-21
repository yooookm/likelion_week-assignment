package study.likelionbeweekly.week2.object;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Student {
    private final int number;
    private final String name;

    public void getInfo(){
        System.out.println("my name is " + name + ", and my number is " + number);
    }

    public void goToSchool(){
        System.out.println("I don't like school");
    }

}
