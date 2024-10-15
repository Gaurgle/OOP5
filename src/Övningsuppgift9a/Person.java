package Övningsuppgift9a;

public class Person {
        String name = "";
        String adress = "";
        int age = 0;
        int weight = 0;
        int length = 0;

        public Person(String name, String adress, int age, int wight, int length){
            this.name = name;
            this.adress = adress;
            this.age = age;
            this.weight = wight;
            this.length = length;
        }

        @Override
        public String toString() {
            return String.format(
                    "%s, %s\nÅlder: %d, Vikt: %d, Längd: %d\n",
                    name, adress, age, weight, length);
        }
}