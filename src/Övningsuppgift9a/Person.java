package Övningsuppgift9a;

public class Person {
        String name;
        String adress;
        int age;
        int weight;
        int length;

        public Person(String name, String adress, int age, int wight, int length){
            this.name = name;
            this.adress = adress;
            this.age = age;
            this.weight = wight;
            this.length = length;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getAdress() {
        return adress;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    @Override
        public String toString() {
            return String.format(
                    "%s, %s\nÅlder: %d, Vikt: %d, Längd: %d\n",
                    name, adress, age, weight, length);
        }
}