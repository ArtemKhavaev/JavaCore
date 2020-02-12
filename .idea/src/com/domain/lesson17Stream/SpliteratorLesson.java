package com.domain.lesson17Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorLesson {
    public static void main(String[] args) {
        List<String> stringArrayList = Arrays.asList("a", "b", "c", "d", "f");
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.CONCURRENT));//false
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.SORTED));//false
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.NONNULL));//false
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.DISTINCT));//false
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.ORDERED));//true
        System.out.println(stringArrayList.spliterator().hasCharacteristics(Spliterator.SUBSIZED));//true

        //stringArrayList.spliterator().getComparator(); //вернет компаратор если он есть


        Spliterator<String>stringSpliterator = stringArrayList.spliterator();
        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown());

        stringSpliterator.trySplit();
        stringSpliterator.forEachRemaining(System.out::println);

        System.out.println(stringSpliterator.estimateSize());
        System.out.println(stringSpliterator.getExactSizeIfKnown());

        Spliterator<String> spliterator1 = stringArrayList.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        spliterator1.forEachRemaining(System.out::println);
        System.out.println("==");
        spliterator2.forEachRemaining(System.out::println);

    }
}
