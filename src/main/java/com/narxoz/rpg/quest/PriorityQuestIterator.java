package com.narxoz.rpg.quest;

import java.util.List;

public class PriorityQuestIterator implements QuestIterator {
    private final List<Quest>   quests;
    private final QuestPriority minPriority;
    private int index = 0;

    PriorityQuestIterator(List<Quest> quests, QuestPriority minPriority) {
        this.quests      = quests;
        this.minPriority = minPriority;
        advance();
    }

    @Override
    public boolean hasNext() { return index < quests.size(); }

    @Override
    public Quest next() {
        Quest q = quests.get(index++);
        advance();
        return q;
    }

    private void advance() {
        while (index < quests.size() &&
                quests.get(index).getPriority().ordinal() < minPriority.ordinal()) {
            index++;
        }
    }
}