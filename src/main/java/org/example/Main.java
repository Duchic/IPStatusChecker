package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main { //TODO pushover api
    public static void main(String[] args) {
        final String APP_TOKEN = args[0]; //for pusover api
        final String USER_TOKEN = args[1]; //for pushover api
        readIPFromFile();
    }

    private static void readIPFromFile() {
        try {
            String filePath = "ip.txt";
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            String [] input = scanner.nextLine().split(";");
            String ipAddress = input[0];
            String alias = input[1];

            while (scanner.hasNextLine()){
                ipAddress = scanner.nextLine();
                boolean isReachable = ping(ipAddress);
                if (isReachable){
                    //is online
                } else {
                    //is offline
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean ping(String ipAddress) {
        try {
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            return inetAddress.isReachable(3000);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}