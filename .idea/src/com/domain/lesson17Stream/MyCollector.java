package com.domain.lesson17Stream;

import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class MyCollector implements Collector<String, TreeSet<String>, String> {

// лямбда, оперделющая создание контейнеа для хранения промежуточных результатов
    @Override
    public Supplier<TreeSet<String>> supplier() {
        return TreeSet::new;
    }
// добавление промежуточного значения в контейнер
    @Override
    public BiConsumer<TreeSet<String>, String> accumulator() {
        return TreeSet::add;
    }
    // объединение нескольких контейнеров если stream будет парраллельным
    // описывает как собирает результаты из нескю потоков в один
    @Override
    public BinaryOperator<TreeSet<String>> combiner() {
        return (treeset, strings)-> {
            treeset.addAll(strings);
            return treeset;
        };
    }

    // финальное проебразование элементов контейнера
    @Override
    public Function<TreeSet<String>, String> finisher() {
        return strings -> strings.stream()
                .skip(1)
                .sorted()
                .findFirst()
                .orElse("default");
    }
// set  с характеристиками контейнера
    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }

    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("f", "e", "z", "x");
        System.out.println(stringStream.collect(new MyCollector()));
    }
}
