package com.company;

import java.util.Scanner;

//=======игра=======
public class Game {

    public static Character manager; //персонаж
    public static Story story; // История

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Вы прошли собеседование и вот-вот станете сотрудником Корпорации. \n "
                + "Осталось уладить формальности - подпись под договором (Введите ваше имя):");
        manager = new Character(in.next()); //Создание персонажа
        story = new Story();
        while (true) {
            manager.A += story.current_situation.dA;
            manager.K += story.current_situation.dK;
            manager.R += story.current_situation.dR;
            System.out.println("=====\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n=====");
            System.out.println("============="
                    + story.current_situation.subject + "==============");
            System.out.println(story.current_situation.text);
            if (story.isEnd()) {
                System.out
                        .println("====================the end!===================");
                return;
            }
            story.go(in.nextInt());
            if (manager.name.equalsIgnoreCase("Admin")){
                System.out.println("Добавить сцену?");
                if (in.next().equalsIgnoreCase("Да")){
                    while (true){
                        System.out.println("Добавьте заголовок");
                        String subject = in.nextLine();
                        in.nextLine();
                        System.out.println("Добавьте текст");
                        String text = in.nextLine();
                        in.nextLine();
                        System.out.println("Добавить изменения параметров");
                        int dk = in.nextInt(), da = in.nextInt(), dr = in.nextInt();
                        story.addStory(new Situation(subject, text, dk, da, dr));
                        System.out.println("Закончить редактирование?");
                        if (in.next().equalsIgnoreCase("Да"))
                            break;
                    }
                }
            }
        }

    }

}