package com.narxoz.rpg.guild;

public abstract class GuildMember {
    protected GuildMediator mediator;
    private   final String  role;

    public GuildMember(String role) {
        this.role = role;
    }

    public void setMediator(GuildMediator mediator) {
        this.mediator = mediator;
    }

    public String getRole() { return role; }

    public void broadcast(String topic, String message) {
        mediator.send(topic, message, this);
    }

    public abstract void receive(String topic, String message, String senderRole);
}