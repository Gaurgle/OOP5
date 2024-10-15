package Temperaturer;

import java.io.BufferedReader;
import java.io.FileReader;

class Main {
    public static void main(String[] args) {
        String tempLine;

        double minTemp = Double.MAX_VALUE;
        double maxTemp = Double.MIN_VALUE;
        double avgTemp = 0;
        double totalTemp = 0;
        int tempCount = 0;
        String avgTempFormated = "";


        try (BufferedReader br = new BufferedReader(new FileReader(
                "src/temperaturer.txt"))) {
            while ((tempLine = br.readLine()) != null) {
                try {
                    tempLine = tempLine.trim().replace(",", ".");
                    double temp = Double.parseDouble(tempLine);
                    if (temp > maxTemp) {
                        maxTemp = temp;
                    }
                    if (temp < minTemp) {
                        minTemp = temp;
                    }

                    totalTemp += temp;
                    tempCount++;

                } catch (NumberFormatException e) {
                    System.out.println(" felaktigt format på temperaturer " + tempLine);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("File not found");
            return;
        }
        if (tempCount > 0) {
            avgTemp = totalTemp / tempCount;
            avgTempFormated = String.format("%.2f", avgTemp);
        }

        String message =
                "Högsta temp: " +maxTemp + "°\n" +
                "Lägsta temp: " +minTemp + "°\n" +
                "Medeltemp icke formaterad: " + avgTemp +"\n" +
                "Medeltemperatur: " +avgTempFormated +"°";
        System.out.println(message);
    }
}