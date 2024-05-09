package study.likelionbeweekly.week2.object;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Student {
    private int number;
    private String name;

    public void getInfo(){
        System.out.println("my name is " + name + ", and my number is " + number);
    }

    public void goToSchool(){
        System.out.println("I don't like school");
    }

}
