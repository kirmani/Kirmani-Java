/*
 * Solution.java
 * Copyright (C) 2015 sean <sean@Seans-MBP.lan>
 *
 * Distributed under terms of the MIT license.
 */

package io.kirmani.interview.dutchsort;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String b = sc.next();
        System.out.println(String.valueOf(dutchSort(b.toCharArray())));
    }

    static char[] dutchSort(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' || arr[i] <= 'z') {
                arr[i] -= 'a';
            }
            char start = 'z' - 'a' + 1;
            if (arr[i] >= 'A' || arr[i] <= 'Z') {
                arr[i] = arr[i] - 'A' + start;
            }
            start <<= 1;
            if (arr[i] >= '0' || arr[i] <= '9') {
                arr[i] = arr[i] - '0' + start;
            }
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + 'a' >= 'a' || arr[i] + 'a' <= 'z') {
                arr[i] += 'a';
            }
            char start = 'z' - 'a' + 1;
            if (arr[i] + 'A' + start >= 'A' || arr[i] + 'A' + start <= 'Z') {
                arr[i] = arr[i] + 'A' - start;
            }
            start <<= 1;
            if (arr[i] + '0' + start >= '0' || arr[i] + '0' + start <= '9') {
                arr[i] = arr[i] + '0' - start;
            }
        }
        return arr;
    }
}
