package org.rjgroup.info;

public class CharacterInfo {

    private String name;
    private int maxHP;
    private int HP;
    private int AC;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int attackDie;
    private int damageDie;
    private boolean isAlive;

    public CharacterInfo() {}

    CharacterInfo(String setName) {
        setName(setName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAttackDie() {
        return attackDie;
    }

    public void setAttackDie(int attackDie) {
        this.attackDie = attackDie;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public void setDamageDie(int damageDie) {
        this.damageDie = damageDie;
    }

    public int getToHit() {

        return (int)(Math.random() * (getAttackDie() - 1)) + 1;
    }

    public int getDamage() {

        return (int)(Math.random() * (getDamageDie() -1)) + 1;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
