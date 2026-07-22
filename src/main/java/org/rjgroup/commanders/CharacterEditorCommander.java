package org.rjgroup.commanders;

import org.rjgroup.info.CharacterInfo;

public class CharacterEditorCommander extends BasicCommander {

    protected final String COMMANDER_NAME = "Character Edit Commander";
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

    public void otherCommandList(String[] command) {
        switch(command[0]) {
            case "print":
                printCharacter();
                break;
            case "name":
                if(command.length == 2) {
                    character.setName(command[1]);
                } else {
                    System.out.print("New name:");
                    character.setName(scanner.nextLine());
                }
                break;
            case "status":
                if(command.length == 2) {
                    if("alive".equals(command[1])) {
                        character.setAlive(true);
                    } else if ("dead".equals(command[1])) {
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
                if(command.length == 2) {
                    character.setMaxHP(Integer.parseInt(command[1]));
                } else {
                    System.out.print("New max hit points:");
                    character.setMaxHP(Integer.parseInt(scanner.nextLine()));
                }
                break;
                // TODO: HP can't be larger then maxHP
            case "hp":
                if(command.length == 2) {
                    character.setHP(Integer.parseInt(command[1]));
                } else {
                    System.out.print("New hit points:");
                    character.setHP(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case "strength":
                if(command.length == 2) {
                    character.setStrength(Integer.parseInt(command[1]));
                } else {
                    System.out.print("Set Strength:");
                    character.setStrength(Integer.parseInt(scanner.nextLine()));
                }
                character.setAC(character.getDexterity() + (character.getStrength()/2));
                break;
            case "dexterity":
                if(command.length == 2) {
                    character.setDexterity(Integer.parseInt(command[1]));
                } else {
                    System.out.print("Set Dexterity:");
                    character.setDexterity(Integer.parseInt(scanner.nextLine()));
                }
                character.setAC(character.getDexterity() + (character.getStrength()/2));
                break;
            case "intelligence":
                if(command.length == 2) {
                    character.setIntelligence(Integer.parseInt(command[1]));
                } else {
                    System.out.print("Set Intelligence:");
                    character.setIntelligence(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case "attackDie":
                if(command.length == 2) {
                    character.setAttackDie(Integer.parseInt(command[1]));
                } else {
                    System.out.print("Set Attack Die:");
                    character.setAttackDie(Integer.parseInt(scanner.nextLine()));
                }
                break;
            case "hitDie":
                if(command.length == 2) {
                    character.setDamageDie(Integer.parseInt(command[1]));
                } else {
                    System.out.print("Set Damage Die:");
                    character.setDamageDie(Integer.parseInt(scanner.nextLine()));
                }
                break;
        }
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
}
