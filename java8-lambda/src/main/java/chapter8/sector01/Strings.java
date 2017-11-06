package chapter8.sector01;


import java.time.ZoneId;


public class Strings {

    public static void main(String[] args) {

        String joined = String.join("/", "usr", "local", "bin");    // "usr/local/bin"
        System.out.println(joined);
        String ids = String.join(", ", ZoneId.getAvailableZoneIds());
        System.out.println(ids);

    }

}
