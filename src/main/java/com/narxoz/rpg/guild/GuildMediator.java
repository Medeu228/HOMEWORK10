package com.narxoz.rpg.guild;

public interface GuildMediator {
    void register(GuildMember member);
    void send(String topic, String message, GuildMember sender);
}