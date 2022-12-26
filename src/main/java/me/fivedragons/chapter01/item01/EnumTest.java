package me.fivedragons.chapter01.item01;

import java.util.*;

public class EnumTest {
    public static void main(String[] args) {

        Arrays.stream(Level.values()).forEach(System.out::println);

        System.out.println(PayType.TOSS.getType());
        System.out.println(PayType.NAVER_PAY.getNumber());

        EnumSet<PayType> enumSet1 = EnumSet.allOf(PayType.class);
        System.out.println(enumSet1);

        EnumSet<PayType> enumSet2 = EnumSet.of(PayType.NAVER_PAY, PayType.KAKAO_PAY);
        System.out.println(enumSet2);

        EnumSet<PayType> enumSet3 = EnumSet.range(PayType.TOSS,PayType.NAVER_PAY);
        System.out.println(enumSet3);


    }
}

enum Level {
    EASY,
    NORMAL,
    HARD;
}

enum PayType {
    KAKAO_PAY("카카오페이", 1),
    TOSS("토스", 2),
    NAVER_PAY("네이버페이", 3);

    private String type;
    private int number;

    PayType(String type, int number) {
        this.type = type;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
}
