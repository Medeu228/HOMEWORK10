package com.narxoz.rpg.council;

public class CouncilRunResult {
    public final int    questsTraversed;
    public final int    messagesRouted;
    public final int    goldEarned;

    public CouncilRunResult(int questsTraversed, int messagesRouted, int goldEarned) {
        this.questsTraversed = questsTraversed;
        this.messagesRouted  = messagesRouted;
        this.goldEarned      = goldEarned;
    }

    @Override
    public String toString() {
        return String.format(
                "\n╔══════════════════════════════╗\n" +
                        "║     ИТОГ ВОЕННОГО СОВЕТА     ║\n" +
                        "╚══════════════════════════════╝\n" +
                        "  Квестов обойдено:   %d\n" +
                        "  Сообщений роутнуто: %d\n" +
                        "  Золото заработано:  %dg",
                questsTraversed, messagesRouted, goldEarned
        );
    }
}