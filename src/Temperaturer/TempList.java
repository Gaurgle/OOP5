package Temperaturer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TempList {
    public static void main(String[] args) {
        String tempLine;

        List<Double> temps = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(
                "src/temperaturer.txt"))) {
            while ((tempLine = br.readLine()) != null) {
                try {
                    tempLine = tempLine.replace(",", ".");
                    double temp = Double.parseDouble(tempLine);
                    temps.add(temp);

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

        double maxTemp = Collections.max(temps);
        double minTemp = Collections.min(temps);
        double totalTemp = temps.stream().mapToDouble(Double::doubleValue).sum();
        double avgTemp = totalTemp / temps.size();
        ZonedDateTime stockholmTime = ZonedDateTime.now(ZoneId.of("Europe/Stockholm"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = stockholmTime.format(formatter);
        String zoneName = stockholmTime.getZone().getId();
        String cityName = zoneName.substring(zoneName.indexOf('/') + 1);

        String title = String.format(
                "%s %s %s",
                "Temperaturer i", cityName,
                formattedTime);

        String message = String.format(
                "%-20s %8.2f°\n%-20s %8.2f°\n%-20s %8.2f°",
                "Högsta temp: ", maxTemp,
                "Lägsta temp: ", minTemp,
                "Medeltemp: ", avgTemp);

        System.out.println("\n" +title);
        System.out.println("------------------------------");
        System.out.println(message);
    }
}