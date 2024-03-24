package com.example.ek;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceTest {
    public static void main(String[] args) {
        // Test için büyük bir liste oluşturalım
        List<Integer> largeList = new ArrayList<>();
        for (int i = 0; i < 50000000; i++) {
            largeList.add(i);
        }

        // Normal döngü kullanarak listenin elemanlarını işleyelim
        long startTime = System.currentTimeMillis();
        List<Integer> normalResult = new ArrayList<>();
        for (Integer num : largeList) {
            normalResult.add(num * 2); // Her elemanı ikiyle çarpıp yeni liste oluşturuyoruz
        }
        long normalTime = System.currentTimeMillis() - startTime;
        System.out.println("Normal döngü süresi: " + normalTime + " ms");

        // Stream API kullanarak aynı işlemi gerçekleştirelim
        startTime = System.currentTimeMillis();
        List<Integer> streamResult = largeList.stream()
                                              .map(num -> num * 2)
                                              .collect(Collectors.toList());
        long streamTime = System.currentTimeMillis() - startTime;
        System.out.println("Stream API süresi: " + streamTime + " ms");
        
        
        // Normal döngü kullanarak listenin elemanlarını işleyelim
        startTime = System.currentTimeMillis();
        List<Integer> normalResult2 = new ArrayList<>();
        for (int i = 0; i < largeList.size(); i++) {
        	normalResult.add(largeList.get(i) * 2);
		}
        long normalTime2 = System.currentTimeMillis() - startTime;
        System.out.println("Normal döngü süresi: " + normalTime2 + " ms");

    }
}