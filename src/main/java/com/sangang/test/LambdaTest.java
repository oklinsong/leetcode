package com.sangang.test;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        List<Integer> lists = Lists.newArrayList(4, 7, 3, 2);
        lists.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        lists.stream().reduce((e1, e2) -> e1 + e2).ifPresent(System.out::println);
        int sum2 = lists.stream().reduce(2, (e1, e2) -> e1 + e2);
        System.out.println("sum2 ="+sum2);
        System.out.println(lists.stream().filter(i->i>3).count());
    }

}
