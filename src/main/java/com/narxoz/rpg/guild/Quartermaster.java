package com.narxoz.rpg.guild;

public class Quartermaster extends GuildMember {

    public Quartermaster() { super("Квартирмейстер"); }

    @Override
    public void receive(String topic, String message, String senderRole) {
        switch (topic) {
            case "SUPPLIES" ->
                    System.out.printf("    ⚙  Квартирмейстер: подготовлю запасы по запросу от %s.%n", senderRole);
            case "CAMPAIGN" ->
                    System.out.printf("    ⚙  Квартирмейстер: обновляю инвентарь для похода.%n");
            default ->
                    System.out.printf("    ⚙  Квартирмейстер: принято от %s [%s].%n", senderRole, topic);
        }
    }
}