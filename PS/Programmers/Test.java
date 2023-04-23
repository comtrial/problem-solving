package Programmers;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

    // sum 의 재귀를 활용한 분할 정복
    public static int sumByRecur(int[] arr) {
        if (arr.length == 1) return arr[0];
        return arr[0] + sumByRecur(IntStream.range(1, arr.length).map(num -> arr[num]).toArray());
    }

    public static int findMaxNum(int[] arr) {

        // 기본 단계: 배열이 2개일 경우 비교 해주면 된다.
        if (arr.length == 2) return (arr[0] > arr[1]) ? arr[0] : arr[1];

        int subMax = findMaxNum(IntStream.range(1, arr.length).map(n -> arr[n]).toArray());
        return (arr[0] > subMax) ? arr[0] : subMax;
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // 분할 정복 법 관점으로 생각해보면
        // 1. 기본 단계를 해결
        // 2. 기본 단계가 되도록 문제를 변경
//        if (arr.length == 1 || arr.length == 0) return arr;
        if (arr.size() <= 1) return arr;

        List<Integer> pivotList = new LinkedList<>();
        List<Integer> leftList = new LinkedList<>();
        List<Integer> rightList = new LinkedList<>();

        int pivotInt = arr.get(0);
        for (int num: arr) {
            if (num < pivotInt) leftList.add(num);
            else if (num > pivotInt) rightList.add(num);
            else pivotList.add(num);
        }

        // 3 개 이상의 list concat
        return Stream.of(quickSort(leftList), pivotList, quickSort(rightList))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 8, 2 ,3, 4};

        List<Integer> result = quickSort(Arrays.asList(arr));

        System.out.println("======sorted arr");
        for (int num : result) System.out.println(num);
        System.out.println("result = " + result);
    }
}
