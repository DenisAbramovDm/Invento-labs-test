package com.denisabramov;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Tendency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n (values more than 5000 may cause very long calculating time)\n");
        int n = scanner.nextInt();
     //   System.out.println("Enter number of decimal places");
      //  int scale = scanner.nextInt();
        int scale = 10;
        System.out.println(un(n, scale));
    }

    private static BigDecimal un(int n, int scale) {
        BigDecimal result;
        result = (BigDecimal.ONE.divide(new BigDecimal(getFactorial(n)), 999999, RoundingMode.HALF_UP))
                .multiply(new BigDecimal(getFactorialsSumm(n)));
        return result.setScale(scale, RoundingMode.HALF_UP);
    }

    private static BigInteger getFactorial(long n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    private static BigInteger getFactorialsSumm(long n) {
        BigInteger summ = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            summ = summ.add(getFactorial(i));
        }
        return summ;
    }
}
