package com.denisabramov.service;

public class Converter {
    public int convertIpFromStringToInt(String ipString) {
        int[] ipIntSeparated = new int[4];
        String[] ipStringSeparated = ipString.split("\\.");
        for (int i = 0; i < 4; i++) {
            ipIntSeparated[i] = Integer.parseInt(ipStringSeparated[i]);
        }
        int ipInt = 0;
        for (int i = 0; i < 4; i++) {
            ipInt += ipIntSeparated[i] << (24 - (8 * i));
        }
        return ipInt;
    }

    public String convertIpFromIntToString(int ipInt) {
        return String.format("%d.%d.%d.%d",
                (ipInt >> 24 & 0xff),
                (ipInt >> 16 & 0xff),
                (ipInt >> 8 & 0xff),
                (ipInt & 0xff));


    }
}
