package org.rjgroup.commanders;

import org.rjgroup.info.CharacterInfo;

public class CharacterEditorCommander extends BasicCommander {

    protected final String COMMANDER_NAME = "Character Editor";
    protected final int[] DIE_LIST = {4, 6, 8, 10, 12, 20};
    private CharacterInfo character;

    public CharacterEditorCommander() {
        super();
        other_commands = "\nprint - print the character info"
                + "\n-p - print the character info"
                + "\nname <name> - change the name with the new name"
                + "\nstatus <alive/dead> - change the status"
                + "\nmaxhp <value> - change the max HP to the new value"
                + "\nhp <value> - change the max HP to the new value"
                + "\nstr <value> - set strength value"
                + "\ndex <value> - set dexterity value"
                + "\nint <value> - set intelligence value"
                + "\ndie <option> <value> - set a die value for attack or damage, for more info use -h or help"
        ;
        character = new CharacterInfo();
    }

    public CharacterEditorCommander(CharacterInfo character) {
        super();
        setCharacter(character);
        other_commands = "\nprint - print the character info"
            + "\n-p - print the character info"
            + "\nname <name> - change the name with the new name"
            + "\nmaxhp <value> - change the max HP to the new value"
            + "\nhp <value> - change the max HP to the new value"
            + "\nstr<value> - set strength value"
            + "\ndex <value> - set dexterity value"
            + "\nint <value> - set intelligence value"
            + "\ndie <option> <value> - set a die value for attack or damage, for more info use -h or help"
        ;
    }

    public CharacterInfo getCharacter() {
        return character;
    }

    public void setCharacter(CharacterInfo characterInfo) {
        character = characterInfo;
    }

    public void otherCommandList(String[] commandList) {

        int input;

        switch(commandList[0]) {
            case "-p":
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
                    setStatus(commandList[1]);
                } else {
                    System.out.print("Set status(alive/dead):");
                    String newStatus = scanner.nextLine();
                    setStatus(newStatus);
                }
                break;
            case "maxhp":
                input = checkIfIsInteger(commandList, 1);
                character.setMaxHP(input);
                break;
            case "hp":
                input = checkIfIsInteger(commandList, 1);
                if(checkHP(input)) {
                    character.setHP(input);
                } else {
                    System.out.println("Invalid hit points should not be greater then max hit points.");
                }
                break;
            case "str":
                input = checkIfIsInteger(commandList, 1);
                character.setStrength(input);

                character.setAC(character.getDexterity() + (character.getStrength()/2));
                break;
            case "dex":
                input = checkIfIsInteger(commandList, 1);
                character.setDexterity(input);

                character.setAC(character.getDexterity() + (character.getStrength()/2));
                break;
            case "int":
                input = checkIfIsInteger(commandList, 1);
                character.setIntelligence(input);
                break;
            case "die":
                setDieCommand(commandList);
                break;
            default:
                System.out.println("Warning! " + commandList[0] + " is invalid use 'help' command to see list of commands!");
                break;
        }
    }

    private void setStatus(String status) {

        if("alive".equals(status)) {
            character.setStatus(true);
        } else if ("dead".equals(status)) {
            character.setStatus(false);
        } else {
            System.out.println("Status bust have value of alive/dead.");
        }
    }

    private int checkIfIsInteger(String[] commandLine, int valueIndex) {

        int integerValue = 0;
        String stringValue;
        while (integerValue <= 0) {
            try{
                stringValue = commandLine[valueIndex];
            } catch (Exception e) {
                System.out.print("Input numerical value: ");
                stringValue = scanner.nextLine();
            }

            try{
                integerValue = Integer.parseInt(stringValue);
            } catch (Exception e) {
                System.out.println("Value input not a number!");
            }
        }

        return integerValue;
    }

    private void setDieCommand(String[] commandLine) {

        try{

            int input;
            switch (commandLine[1]) {
                case "-h":
                case "help":
                    System.out.print("die <options> <value> - set the die type where, where <options> is contained in"
                            + "\n[-a, attack, -d, damage, -h, help] with <-a/attack> for the attack die, <-d/damage> for"
                            + "\nthe damage die and <-h/help> to display help."
                    );
                    break;
                case "-a":
                case "attack":
                    input = checkIfIsInteger(commandLine, 2);
                    if (checkIfDie(input)) {
                        character.setAttackDie(input);
                    } else {
                        System.out.println("Incorrect die input it has to be a value of [4,6,8,10,12,20]!");
                    }
                    break;
                case "-d":
                case "damage":
                    input = checkIfIsInteger(commandLine, 2);
                    if (checkIfDie(input)) {
                        character.setDamageDie(input);
                    } else {
                        System.out.println("Incorrect die input it has to be a value of [4,6,8,10,12,20]!");
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Select an option for die <option> command, for help use -h, or help option!");
        }

    }

    private boolean checkIfDie(int dieInput) {

        boolean isDie = false;
        for (int die : DIE_LIST) {
            if (die == dieInput) {
                isDie = true;
            }
        }

        return isDie;
    }

    private boolean checkHP(int newHP) {

        return (newHP <= character.getMaxHP());
    }

    public void printCharacter() {

        System.out.println("------------------------");
        System.out.println("Name: " + character.getName());
        System.out.println("Status: " + ((character.isStatus())? "alive": "dead"));
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
