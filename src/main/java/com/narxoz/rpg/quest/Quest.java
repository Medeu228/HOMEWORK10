package com.narxoz.rpg.quest;

public class Quest {
    private final String        title;
    private final QuestPriority priority;
    private final int           rewardGold;

    public Quest(String title, QuestPriority priority, int rewardGold) {
        this.title      = title;
        this.priority   = priority;
        this.rewardGold = rewardGold;
    }

    public String        getTitle()      { return title; }
    public QuestPriority getPriority()   { return priority; }
    public int           getRewardGold() { return rewardGold; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%dg)", priority, title, rewardGold);
    }
}