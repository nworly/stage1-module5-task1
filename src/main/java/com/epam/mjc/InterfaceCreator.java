package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> {
            Predicate<String> isUpperCase = v -> Character.isUpperCase(v.charAt(0));
            for (String s : x) {
                if (!isUpperCase.test(s)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> evenValues = new ArrayList<>();
            for (int i : x) {
                if (i % 2 == 0) {
                    evenValues.add(i);
                }
            }
            x.addAll(evenValues);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> values.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .filter(s -> s.endsWith("."))
                .filter(s -> s.split(" ").length > 3)
                .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
    }
}
