package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.council.CouncilEngine;
import com.narxoz.rpg.council.CouncilRunResult;
import com.narxoz.rpg.quest.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║  ⚔  ГИЛЬДИЯ АВАНТЮРИСТОВ  ⚔     ║");
        System.out.println("╚══════════════════════════════════╝");

        Hero hero = new Hero("Гарет", 0);
        CouncilEngine engine = new CouncilEngine();

        QuestLog log = new QuestLog();
        log.add(new Quest("Убить крыс в таверне",     QuestPriority.LOW,      20));
        log.add(new Quest("Найти пропавший груз",     QuestPriority.MEDIUM,   50));
        log.add(new Quest("Разведать форт врагов",    QuestPriority.HIGH,    100));
        log.add(new Quest("Остановить ритуал Тьмы",  QuestPriority.CRITICAL, 300));
        log.add(new Quest("Сопроводить торговца",     QuestPriority.LOW,      30));
        log.add(new Quest("Зачистить шахту от нежити",QuestPriority.HIGH,    150));

        System.out.println("\n  Квестов в журнале: " + log.size());

        int total = 0;
        total += engine.walkOrdered(log, hero);
        total += engine.walkReverse(log);
        total += engine.walkByPriority(log, QuestPriority.HIGH);

        System.out.println("\n  Герой после квестов: " + hero);

        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║       ВОЕННЫЙ СОВЕТ              ║");
        System.out.println("╚══════════════════════════════════╝");

        engine.captainSendsAlert("Враги замечены у восточных ворот!");
        engine.scoutReportsRecon("Завершил разведку — путь на север свободен.");
        engine.quartermasterRequestsSupplies("Нужны рационы на 10 дней похода.");
        engine.healerRequestsMedical("Заканчиваются бинты и зелья.");
        engine.launchCampaign("Выступаем на рассвете! Все по местам!");

        CouncilRunResult result = new CouncilRunResult(
                total,
                engine.getMessagesRouted(),
                hero.getGold()
        );
        System.out.println(result);
    }
}