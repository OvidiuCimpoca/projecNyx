package org.rjgroup.info;

public class PlayerCharacterInfo extends CharacterInfo{

    private final int HIT_DIE = 6;
    private final int HIT_DIE_NR = 2;
    private final int STR = 8;
    private final int DEX = 8;
    private final int INT = 6;

    public PlayerCharacterInfo(String name) {
        super(name);
        int hitPoints = (int)(Math.random() * (HIT_DIE * HIT_DIE_NR - HIT_DIE_NR)) + HIT_DIE_NR;
        setMaxHP(hitPoints);
        setHP(hitPoints);
        setStrength((int)(Math.random() * (STR -1)) + 1);
        setDexterity((int)(Math.random() * (DEX -1)) + 1);
        setIntelligence((int)(Math.random() * (INT -1)) + 1);
        setAC(getDexterity() + (getStrength()/2));

        setAttackDie(6);
        setDamageDie(4);
        setStatus(true);
    }
}
