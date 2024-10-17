package Övningsuppgift9a;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

/*       måste först sortera vid första ","
         sedan är nästa info adressen, som tar slut vid "\n"
         sedan är det 3 st int, separerade med ","
         tar slut med "\n"*/ // skiss

        List<Person> persons = new ArrayList<>();

        File personuppgifter = new File("src/Övningsuppgift9a/Personuppgifter.txt");

        if (!personuppgifter.exists()) {
            System.out.println("Filen du angett hittas ej.");
            return;
        }
        try {
            Scanner sc = new Scanner(personuppgifter);
            while (sc.hasNextLine()) {
                if (sc.hasNextLine()) {

                    String nameAndAdress = sc.nextLine();
                    String ageWeightHeight = sc.nextLine();

                    String[] splitData = ageWeightHeight.split(",\\s*");
                    String[] nameAdressParts = nameAndAdress.split(",\\s+", 2);

                    // variablerna tilldelas värden
                    String name = nameAdressParts[0];
                    String adress = nameAdressParts[1];

                        // måste parse pga vi läser in string.
                    int age = Integer.parseInt(splitData[0]);
                    int weight = Integer.parseInt(splitData[1]);
                    int height = Integer.parseInt(splitData[2]);

                    // lägger in nytt personobjekt i persons-listan
                    persons.add(new Person(name, adress, age, weight, height));

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            return;
        } catch (Exception e) {
            System.out.println("Allmänt fel");
            return;
        }

//        Sorter sorter = new Sorter();
//         persons.forEach(System.out::println);

        // Skapa en dialogruta för att välja sortering
        Object[] options = {"Name","Height"};
        int choice = JOptionPane.showOptionDialog(null,
                "Sort by:",
                "Sorting options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

/*        switch (choice) {
            case 0:
                sorter.sortByName(persons);
                break;
            case 1:
                sorter.sortByHeight(persons);
                break;
            case 2:
                sorter.sortByWeight(persons);
                break;
            case 3:
                sorter.sortByAge(persons);
                break;
            case 4:
                sorter.sortByAdress(persons);
                break;
            default:
                System.out.println("Inget val gjort.");
        }*/ // Switch sort för fler alternativ

        // Sortera persons-listan
        boolean sortByName = (choice == 0);
        // Ternery
        persons.sort(sortByName ? Comparator.comparing(Person::getName) : Comparator.comparingInt(Person::getLength));

        for (Person person : persons) {
            System.out.println(person.getName() +": " +person.getLength() +"cm");
        }

        List<Person> personOver2m = new ArrayList<>();
        for (Person person : persons) {
            if (person.length >= 200){
                personOver2m.add(person);
            }
        }

        personOver2m.sort(sortByName ? Comparator.comparing(Person::getName) : Comparator.comparingInt(Person::getLength));

        System.out.println("\nPersoner över 2m: " + personOver2m.size() +"st");
        for (Person person : personOver2m) {
            System.out.println(person.name +": " +person.length +"cm");
        }

        BufferedWriter writer = Files.newBufferedWriter(
                Path.of("src/Övningsuppgift9a/PersonuppgifterPO2m.txt"), StandardCharsets.UTF_8);

        for (Person person : personOver2m) {
            writer.write(person + "\n");
            writer.flush();
        }
    }
}