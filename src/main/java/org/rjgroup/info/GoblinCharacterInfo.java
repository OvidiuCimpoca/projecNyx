package org.rjgroup.info;

public class GoblinCharacterInfo extends CharacterInfo{

    private final int HIT_DIE = 4;
    private final int HIT_DIE_NR = 2;
    private final int STR = 6;
    private final int DEX = 6;
    private final int INT = 4;

    public GoblinCharacterInfo (String name) {
        super(name);
        int hitPoints = (int)(Math.random() * (HIT_DIE * HIT_DIE_NR - HIT_DIE_NR)) + HIT_DIE_NR;
        setMaxHP(hitPoints);
        setHP(hitPoints);
        setStrength((int)(Math.random() * (STR -1)) + 1);
        setDexterity((int)(Math.random() * (DEX -1)) + 1);
        setIntelligence((int)(Math.random() * (INT -1)) + 1);
        setAC(getDexterity() + (getStrength()/2));

        setAttackDie(4);
        setDamageDie(4);
        setStatus(true);
    }
}
