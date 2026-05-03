package com.narxoz.rpg.guild;

public class Captain extends GuildMember {

    public Captain() { super("Капитан"); }

    @Override
    public void receive(String topic, String message, String senderRole) {
        switch (topic) {
            case "ALERT" ->
                    System.out.printf("    ⚔  Капитан: поднимаю отряд по тревоге от %s!%n", senderRole);
            case "CAMPAIGN" ->
                    System.out.printf("    ⚔  Капитан: формирую боевой порядок.%n");
            default ->
                    System.out.printf("    ⚔  Капитан: принято от %s [%s].%n", senderRole, topic);
        }
    }
}