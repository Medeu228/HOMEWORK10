package com.narxoz.rpg.council;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.guild.*;
import com.narxoz.rpg.quest.*;

public class CouncilEngine {
    private final GuildHall hall;
    private final Captain      captain;
    private final Quartermaster quartermaster;
    private final Scout         scout;
    private final Healer        healer;

    private int messagesRouted = 0;

    public CouncilEngine() {
        hall          = new GuildHall();
        captain       = new Captain();
        quartermaster = new Quartermaster();
        scout         = new Scout();
        healer        = new Healer();

        // Регистрируем всех в медиаторе
        for (GuildMember m : new GuildMember[]{captain, quartermaster, scout, healer}) {
            m.setMediator(hall);
            hall.register(m);
        }
    }


    public int walkOrdered(QuestLog log, Hero hero) {
        System.out.println("\n── Обход в порядке добавления (OrderedIterator) ──");
        QuestIterator it = log.orderedIterator();
        int count = 0;
        while (it.hasNext()) {
            Quest q = it.next();
            System.out.println("  » " + q);
            hero.earnGold(q.getRewardGold());
            count++;
        }
        return count;
    }

    public int walkReverse(QuestLog log) {
        System.out.println("\n── Обход в обратном порядке (ReverseIterator) ────");
        QuestIterator it = log.reverseIterator();
        int count = 0;
        while (it.hasNext()) {
            System.out.println("  « " + it.next());
            count++;
        }
        return count;
    }

    public int walkByPriority(QuestLog log, QuestPriority min) {
        System.out.printf("%n── Фильтр: приоритет >= %s (PriorityIterator) ────%n", min);
        QuestIterator it = log.priorityIterator(min);
        int count = 0;
        while (it.hasNext()) {
            System.out.println("  ★ " + it.next());
            count++;
        }
        return count;
    }


    public void captainSendsAlert(String message) {
        captain.broadcast("ALERT", message);
        messagesRouted++;
    }

    public void quartermasterRequestsSupplies(String message) {
        quartermaster.broadcast("SUPPLIES", message);
        messagesRouted++;
    }

    public void scoutReportsRecon(String message) {
        scout.broadcast("RECON", message);
        messagesRouted++;
    }

    public void healerRequestsMedical(String message) {
        healer.broadcast("MEDICAL", message);
        messagesRouted++;
    }

    public void launchCampaign(String message) {
        captain.broadcast("CAMPAIGN", message);
        messagesRouted++;
    }

    public int getMessagesRouted() { return messagesRouted; }
}