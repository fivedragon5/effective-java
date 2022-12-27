package me.fivedragons.chapter01.item01;

import me.whiteship.chapter01.item01.Order;
import me.whiteship.chapter01.item01.OrderStatus;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Map<OrderStatus, Integer> map = new EnumMap<>(OrderStatus.class);

        EnumSet<OrderStatus> enumSet = EnumSet.allOf(OrderStatus.class);
        System.out.println(enumSet.toString());

        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(0);
        list.add(-2);
        list.add(88);

        Comparator<Integer> desc = (n1, n2) -> n2 - n1;

        list.sort(desc);

        System.out.println(list.toString());

        list.sort(desc.reversed());

        System.out.println(list.toString());

    }

}
