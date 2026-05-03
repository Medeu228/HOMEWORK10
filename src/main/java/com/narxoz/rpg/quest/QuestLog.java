package com.narxoz.rpg.quest;

import java.util.ArrayList;
import java.util.List;

public class QuestLog {
    private final List<Quest> quests = new ArrayList<>();

    public void add(Quest quest) { quests.add(quest); }

    public int size() { return quests.size(); }

    public QuestIterator orderedIterator() {
        return new OrderedQuestIterator(quests);
    }

    public QuestIterator reverseIterator() {
        return new ReverseQuestIterator(quests);
    }

    public QuestIterator priorityIterator(QuestPriority minPriority) {
        return new PriorityQuestIterator(quests, minPriority);
    }
}