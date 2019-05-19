package Lesson_5;

public class Main {
    public static void main(String[] args) {
        Sotrudnik[] Sotrudnik = new Sotrudnik[5];
        Sotrudnik[0] = new Sotrudnik("Vasilyi","director","vasya@mail.com",
                898984632,300000, 40);
        Sotrudnik[1] = new Sotrudnik("Evgeniy","doctor","evg@mail.com",
                898986732,100000, 60);
        Sotrudnik[2] = new Sotrudnik("Misha","yborshik","misha@mail.com",
                877984632,30000, 20);
        Sotrudnik[3] = new Sotrudnik("Ivan","driver","ivan@mail.com",
                898984000,40000, 41);
        Sotrudnik[4] = new Sotrudnik("Andrew","promouter","&rew@mail.com",
                898990632,5000, 18);

        for (int i = 0; i < Sotrudnik.length; i++) {
            if(Sotrudnik[i].age > 40){
                Sotrudnik[i].info();
                System.out.println();
            }
        }
    }
}
