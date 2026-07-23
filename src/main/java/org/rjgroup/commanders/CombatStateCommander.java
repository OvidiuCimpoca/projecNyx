package org.rjgroup.commanders;

import org.rjgroup.info.CharacterInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CombatStateCommander extends BasicCommander{

    protected final String COMMANDER_NAME = "Combat Demo";
    private List<CharacterInfo> characterInfos = new ArrayList<>();;

    public CombatStateCommander() {
        super();
        other_commands =
                "\nattack <attacker name> <target name>- attack a target"
                +"\n-a <attacker name> <target name>- attack a target"
                + "\nlist - list the names of the characters"
                + "\n-l - list the names of the characters"
                + "\ninfo <list character names>- show character info"
                + "\n-i <list character names>- show character info"
        ;
    }

    public CombatStateCommander(List<CharacterInfo> characterInfos) {
        super();
        other_commands =
                "\nattack <attacker name> <target name>- attack a target"
                +"\n-a <attacker name> <target name>- attack a target"
                + "\nlist - list the names of the characters"
                + "\n-l - list the names of the characters"
                + "\ninfo <list character names>- show character info"
                + "\n-i <list character names>- show character info"
        ;

        setCharacterInfos(characterInfos);
    }

    public void setCharacterInfos(List<CharacterInfo> characterInfoList) {
        this.characterInfos.addAll(characterInfoList);
    }

    protected void otherCommandList(String[] commandList) {
        switch (commandList[0]) {
            case "attack":
            case "-a":
                attack(commandList, characterInfos);
                break;
            case "list":
            case "-l":
                listCharacterNames(characterInfos);
                break;
            case "info":
            case "-i":
                showCharacterInfo(commandList, characterInfos);
                break;
            default:
                System.out.println("Warning! " + commandList[0] + " is invalid use 'help' command to see list of commands!");
                break;
        }
    }

    private void attack(String[] commandList, List<CharacterInfo> characterInfos) {

        String attackerName = "";
        String targetName = "";

        CharacterInfo attacker = new CharacterInfo();

        switch (commandList.length) {
            case 1:
                System.out.print("Attacker: ");
                attackerName = scanner.nextLine().split(" ")[0];
                System.out.print("Target: ");
                targetName = scanner.nextLine().split(" ")[0];
                break;
            case 2:
                System.out.print("Target: ");
                targetName = scanner.nextLine().split(" ")[0];
                break;
            case 3:
                attackerName = commandList[1];
                targetName = commandList[2];
                break;
        }

        for (CharacterInfo characterInfo : characterInfos) {
            if (attackerName.equals(characterInfo.getName())) {
                attacker = characterInfo;
            }
        }

        for (CharacterInfo characterInfo : characterInfos) {
            if (targetName.equals(characterInfo.getName())) {
                System.out.println(attackerName + " attacks " + targetName + "!");
                checkAttack(attacker, characterInfo);
            }
        }
    }

    private void checkAttack(CharacterInfo attacker, CharacterInfo target) {

        int toHitRoll = attacker.getToHit();


        System.out.println("To hit with roll " + toHitRoll + " + " + attacker.getDexterity() + "!");
        if(toHitRoll + attacker.getDexterity() >= target.getAC()) {

            int damageRoll = attacker.getDamage();
            System.out.println("Success! For " + damageRoll + " + " + attacker.getStrength() + " damage!");
            int newHP = target.getHP() - (damageRoll + attacker.getStrength());
            if (newHP >= 0 ) {
                target.setHP(newHP);
            } else {
                target.setHP(0);
                target.setStatus(false);
            }
        } else {
            System.out.println("Missed!");
        }
    }

    private void listCharacterNames(List<CharacterInfo> characterInfos) {

        characterInfos.forEach(characterInfo -> {
            System.out.println(characterInfo.getName());
        });
    }

    private void showCharacterInfo(String[] commandList, List<CharacterInfo> characters) {

        List<String> names = new ArrayList<>();
        if(commandList.length >= 2) {
            names.addAll(Arrays.asList(commandList).subList(1, commandList.length));
        } else {
            System.out.print("Character(s) to list: ");
            names.addAll(List.of(scanner.nextLine().split(" ")));
        }
        characters.forEach(characterInfo -> {

            if(names.contains(characterInfo.getName())) {
                System.out.println("------------------------");
                System.out.println("Character: " + characterInfo.getName());
                System.out.println("Status: " + characterInfo.isStatus());
                System.out.println("Hit Points:" + characterInfo.getHP() + "/" + characterInfo.getMaxHP());
                System.out.println("Armor Class: " + characterInfo.getAC());
                System.out.println("Strength: " + characterInfo.getStrength());
                System.out.println("Dexterity: " + characterInfo.getDexterity());
                System.out.println("Intelligence: " + characterInfo.getIntelligence());
            }
        });
    }

    protected void exitCommand() {

        System.out.println("Exiting " + COMMANDER_NAME + "!");
    }
}
