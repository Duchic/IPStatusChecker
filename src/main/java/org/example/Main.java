package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String APP_TOKEN = args[0];
        final String USER_TOKEN = args[1];
        readIPFromFile();
    }

    private static void readIPFromFile() {
        try {
            String filePath = "ip.txt";
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()){
                String ipAddress = scanner.nextLine();
                boolean isReachable = ping(ipAddress);
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