package com.narxoz.rpg.guild;

public class Healer extends GuildMember {

    public Healer() { super("Целитель"); }

    @Override
    public void receive(String topic, String message, String senderRole) {
        switch (topic) {
            case "MEDICAL" ->
                    System.out.printf("    💊  Целитель: готовлю зелья по запросу %s.%n", senderRole);
            case "CAMPAIGN" ->
                    System.out.printf("    💊  Целитель: беру медицинские запасы в поход.%n");
            default ->
                    System.out.printf("    💊  Целитель: принято от %s [%s].%n", senderRole, topic);
        }
    }
}