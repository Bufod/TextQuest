package com.company;

// =======история=======
public class Story {

    private Situation start_story;
    public Situation current_situation;

    Story() {
        start_story = new Situation(
                "первая сделка (Windows)",
                "Только вы начали работать и тут же удача! Вы нашли клиента и продаете ему "
                        + "партию ПО MS Windows. Ему в принципе достаточно взять 100 коробок версии HOME.\n"
                        + "(1)у клиента денег много, а у меня нет - вы выпишете ему счет на 120 коробок ULTIMATE по 50тр\n"
                        + "(2)чуть дороже сделаем, кто там заметит - вы выпишете ему счет на 100 коробок PRO по 10тр\n"
                        + "(3)как надо так и сделаем - вы выпишете ему счет на 100 коробок HOME по 5тр ",
                0, 0, 0);
        start_story.direction.add(new Situation(
                "корпоратив",
                "Неудачное начало, ну что ж, сегодня в конторе корпоратив! "
                        + "Познакомлюсь с коллегами, людей так сказать посмотрю, себя покажу",
                0, -10, -10));
        start_story.direction.add(new Situation(
                "совещание, босс доволен",
                "Сегодня будет совещание, меня неожиданно вызвали,"
                        + "есть сведения что \n босс доволен сегодняшней сделкой.",
                1, 100, 0));
        start_story.direction.add(new Situation(
                "мой первый лояльный клиент",
                "Мой первый клиент доволен скоростью и качеством "
                        + "моей работы. Сейчас мне звонил лично \nдиректор компании,  сообщил что скоро состоится еще более крупная сделка"
                        + " и он хотел, чтобы по ней работал именно я!", 0,
                50, 1));
        current_situation = start_story;
    }

    public void go(int num) {
        if (num <= current_situation.direction.size())
            current_situation = current_situation.direction.get(num - 1);
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.size() + " вариантов");
    }
    public void addStory(Situation other){
        current_situation.text += "\n("+ (current_situation.direction.size()+1) + ") " + other.subject;
        current_situation.direction.add(other);
    }

    public boolean isEnd() {
        return current_situation.direction.size() == 0;
    }
}
