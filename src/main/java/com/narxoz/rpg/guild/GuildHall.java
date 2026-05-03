package com.narxoz.rpg.guild;

import java.util.ArrayList;
import java.util.List;

public class GuildHall implements GuildMediator {
    private final List<GuildMember> members = new ArrayList<>();

    @Override
    public void register(GuildMember member) {
        members.add(member);
    }

    @Override
    public void send(String topic, String message, GuildMember sender) {
        System.out.printf("%n  📢 [%s] %s → \"%s\"%n",
                topic, sender.getRole(), message);
        for (GuildMember member : members) {
            if (member != sender) {          // не отправляем отправителю
                member.receive(topic, message, sender.getRole());
            }
        }
    }
}