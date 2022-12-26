package me.fivedragons.chapter01.item01;

import me.whiteship.chapter01.item01.Order;
import me.whiteship.chapter01.item01.OrderStatus;

import java.util.*;

public class Practice {

    public static void main(String[] args) {
        Map<OrderStatus, Integer> map = new EnumMap<>(OrderStatus.class);


        EnumSet<OrderStatus> enumSet = EnumSet.allOf(OrderStatus.class);
        System.out.println(enumSet.toString());




    }

}
