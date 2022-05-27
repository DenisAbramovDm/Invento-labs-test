package com.denisabramov;

import com.denisabramov.service.Converter;

import java.util.Scanner;

public class IpConverter {
    private static final Converter converter = new Converter();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ip address as String in format x.x.x.x\n");
        String stringIpAddress = scanner.nextLine();
        System.out.println("Int interpretation of ip Address is: " + converter.convertIpFromStringToInt(stringIpAddress));
        System.out.println("Enter int value of ip address");
        int intIpAddress = scanner.nextInt();
        System.out.println("String interpretation of ip address is: " + converter.convertIpFromIntToString(intIpAddress));
    }
}
