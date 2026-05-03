package com.narxoz.rpg.guild;

public class Scout extends GuildMember {

    public Scout() { super("Разведчик"); }

    @Override
    public void receive(String topic, String message, String senderRole) {
        switch (topic) {
            case "RECON" ->
                    System.out.printf("    🗺  Разведчик: начинаю разведку по приказу %s.%n", senderRole);
            case "CAMPAIGN" ->
                    System.out.printf("    🗺  Разведчик: прокладываю маршрут кампании.%n");
            default ->
                    System.out.printf("    🗺  Разведчик: принято от %s [%s].%n", senderRole, topic);
        }
    }
}