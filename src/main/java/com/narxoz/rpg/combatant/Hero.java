package com.narxoz.rpg.combatant;

public class Hero {
    private final String name;
    private int gold;

    public Hero(String name, int gold) {
        this.name = name;
        this.gold = gold;
    }

    public void earnGold(int amount) { gold += amount; }

    public String getName() { return name; }
    public int    getGold() { return gold; }

    @Override
    public String toString() {
        return String.format("%s [Gold: %d]", name, gold);
    }
}