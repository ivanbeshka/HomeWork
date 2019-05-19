package Lesson_5;

public class Sotrudnik {
    String FIO;
    String position;
    String email;
    int phone;
    int zarplata;
    int age;

    public Sotrudnik(String FIO, String position, String email, int phone, int zarplata, int age) {
        this.FIO = FIO;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.zarplata = zarplata;
        this.age = age;
    }

    public void info (){
        System.out.println(FIO + "\n" + position + "\n" + email
                + "\n" + phone + "\n" + zarplata +"\n" + age);
    }
}
