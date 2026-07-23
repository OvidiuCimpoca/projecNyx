package org.rjgroup.info;

public class CharacterInfo {

    private String name;
    private boolean status;
    private int maxHp;
    private int hp;
    private int ac;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int attackDie;
    private int damageDie;

    public CharacterInfo() {
        setStatus(true);
    }

    CharacterInfo(String setName) {
        setName(setName);
    }

    public CharacterInfo(CharacterInfo character) {
        setName(character.getName());
        setMaxHP(character.getMaxHP());
        setHP(character.getHP());
        setAC(character.getAC());
        setStrength(character.getStrength());
        setDexterity(character.getDexterity());
        setIntelligence(character.getIntelligence());
        setAttackDie(character.getAttackDie());
        setDamageDie(character.getDamageDie());
        setStatus(character.status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHp;
    }

    public void setMaxHP(int maxHP) {
        this.maxHp = maxHP;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int HP) {
        this.hp = HP;
    }

    public int getAC() {
        return ac;
    }

    public void setAC(int AC) {
        this.ac = AC;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
