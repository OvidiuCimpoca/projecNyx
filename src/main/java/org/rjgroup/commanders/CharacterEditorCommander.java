package org.rjgroup.commanders;

import org.rjgroup.info.CharacterInfo;

public class CharacterEditorCommander extends BasicCommander {

    protected final String COMMANDER_NAME = "Character Editor";
    private CharacterInfo character;

    public CharacterEditorCommander() {
        super();
        other_commands = "\nprint - print the character info"
                + "\nname <name> - change the name with the new name"
                + "\nstatus <alive/dead> - change the status"
                + "\nmaxHp <value> - change the max HP to the new value"
                + "\nhp <value> - change the max HP to the new value"
                + "\nstrength <value> - set strength value"
                + "\ndexterity <value> - set dexterity value"
                + "\nintelligence <value> - set intelligence value"
                + "\nattackDie <value> - set attack die value"
                + "\nhitDie <value> - set hit die value"
        ;
        character = new CharacterInfo();
    }

    public CharacterEditorCommander(CharacterInfo character) {
        super();
        setCharacter(character);
        other_commands = "\nprint - print the character info"
            + "\nname <name> - change the name with the new name"
            + "\nmaxHp <value> - change the max HP to the new value"
            + "\nhp <value> - change the max HP to the new value"
            + "\nstrength <value> - set strength value"
            + "\ndexterity <value> - set dexterity value"
            + "\nintelligence <value> - set intelligence value"
            + "\nattackDie <value> - set attack die value"
            + "\nhitDie <value> - set hit die value"
        ;
    }

    public CharacterInfo getCharacter() {
        return character;
    }

    public void setCharacter(CharacterInfo characterInfo) {
        character = characterInfo;
    }

    public void otherCommandList(String[] commandList) {
        switch(commandList[0]) {
            case "print":
                printCharacter();
                break;
            case "name":
                if(commandList.length == 2) {
                    character.setName(commandList[1]);
                } else {
                    System.out.print("New name:");
                    character.setName(scanner.nextLine());
                }
                break;
            case "status":
                if(commandList.length == 2) {
                    if("alive".equals(commandList[1])) {
                        character.setAlive(true);
                    } else if ("dead".equals(commandList[1])) {
                        character.setAlive(false);
                    }
                } else {
                    System.out.print("Set status(alive/dead):");
                    String newStatus = scanner.nextLine();
                    if("alive".equals(newStatus)) {
                        character.setAlive(true);
                    } else if ("dead".equals(newStatus)) {
                        character.setAlive(false);
                    }
                }
                break;
            case "maxHp":
                if(commandList.length == 2) {
                    character.setMaxHP(Integer.parseInt(commandList[1]));
                } else {
                    System.out.print("New max hit points:");
                    character.setMaxHP(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case "hp":
                if(commandList.length == 2) {
                    if(checkHP(Integer.parseInt(commandList[1]))) {
                        character.setHP(Integer.parseInt(commandList[1]));
                    } else {
                        System.out.println("Invalid hit points should not be greater then max hit points.");
                    }
                } else {
                    System.out.print("New hit points:");
                    int newHP = Integer.parseInt(scanner.nextLine());
                    if(checkHP(newHP)) {
                        character.setHP(newHP);
                    } else {
                        System.out.println("Invalid hit points should not be greater then max hit points.");
                    }
                }
                break;
            case "strength":
                if(commandList.length == 2) {
                    character.setStrength(Integer.parseInt(commandList[1]));
                } else {
                    System.out.print("Set Strength:");
                    character.setStrength(Integer.parseInt(scanner.nextLine()));
                }
                character.setAC(character.getDexterity() + (character.getStrength()/2));
                break;
            case "dexterity":
                if(commandList.length == 2) {
                    character.setDexterity(Integer.parseInt(commandList[1]));
                } else {
                    System.out.print("Set Dexterity:");
                    character.setDexterity(Integer.parseInt(scanner.nextLine()));
                }
                character.setAC(character.getDexterity() + (character.getStrength()/2));
                break;
            case "intelligence":
                if(commandList.length == 2) {
                    character.setIntelligence(Integer.parseInt(commandList[1]));
                } else {
                    System.out.print("Set Intelligence:");
                    character.setIntelligence(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case "attackDie":
                if(commandList.length == 2) {
                    character.setAttackDie(Integer.parseInt(commandList[1]));
                } else {
                    System.out.print("Set Attack Die:");
                    character.setAttackDie(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case "hitDie":
                if(commandList.length == 2) {
                    character.setDamageDie(Integer.parseInt(commandList[1]));
                } else {
                    System.out.print("Set Damage Die:");
                    character.setDamageDie(Integer.parseInt(scanner.nextLine()));
                }
                break;
            default:
                System.out.println("Warning! " + commandList[0] + " is invalid use 'help' command to see list of commands!");
                break;
        }
    }

    private boolean checkHP(int newHP) {

        return (newHP <= character.getMaxHP());
    }

    public void printCharacter() {

        System.out.println("------------------------");
        System.out.println("Name: " + character.getName());
        System.out.println("Status: " + ((character.isAlive())? "alive": "dead"));
        System.out.println("Hit Points:" + character.getHP() + "/" + character.getMaxHP());
        System.out.println("Armor Class: " + character.getAC());
        System.out.println("Strength: " + character.getStrength());
        System.out.println("Dexterity: " + character.getDexterity());
        System.out.println("Intelligence: " + character.getIntelligence());
        System.out.println("Attack Die: " + character.getAttackDie());
        System.out.println("Damage Die: " + character.getDamageDie());
    }

    protected void exitCommand() {

        System.out.println("Exiting " + COMMANDER_NAME + "!");
    }
}
