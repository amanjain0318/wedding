package com.wedding.WeddingVenuePlanning.service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {
        String str  =  "tree";

                LinkedHashMap<Character, Long> mp  =
                        str.chars().mapToObj(data -> (char) data)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting())
                ).entrySet()
                        .stream()
                        .sorted(Map.Entry.<Character,Long>comparingByValue().reversed())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new
                        ));


                StringBuilder sb  =  new StringBuilder();
                for(Map.Entry<Character, Long> m: mp.entrySet())
                {
                    for(int i=0;i<m.getValue();i++)
                    {
                        sb.append(m.getKey());
                    }
                }

                System.out.println(sb.toString());
    }
}
