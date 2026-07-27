package org.rjgroup.commanders.map;

import org.rjgroup.commanders.BasicCommander;

public class MapCommander extends BasicCommander {

//    Number of tiles on the x-axis (monitor with) and the y-axis (monitor height)
    private int x;
    private int y;

    public MapCommander() {
        super();
        other_commands = "\nset <label> <value> - set the label x/y a given int value"
                + "\nprint - print the values of x and y";
    }

    public MapCommander(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        other_commands = "\nset <label> <value> - set the label x/y a given int value"
                + "\nprint - print the values of x and y";
    }

    public void otherCommandList(String[] commandList) {

        switch (commandList[0]) {
            case "":
                break;
            case "set":
                set(commandList);
                break;
            case "print":
                System.out.println("X value: " + this.x);
                System.out.println("Y value: " + this.y);
                break;
            default:
                System.out.println("Warning! " + commandList[0] + " is invalid use 'help' command to see list of commands!");
                break;
        }
    }

    private void set(String[] commandList) {

        String value;
        int parseValue;
        boolean commandLabelExists = false;

        if(commandList.length >= 2) {
            commandLabelExists = true;
            if(commandList.length >= 3) {
                parseValue = tryParseInt(commandList[2]);
            } else {
                System.out.print("Value: ");
                value = scanner.nextLine();
                parseValue = tryParseInt(value);
            }
            if (parseValue <= 0) {
                System.out.println("Incorrect value input " + parseValue + ", value should be greater then 0!");
            } else {
                set(commandList[1], parseValue);
            }
        }
        if(!commandLabelExists) {
            System.out.println("Incorrect input command add a second command x/y!");
        }
    }

    private int tryParseInt(String parseInt) {

        try {
            return Integer.parseInt(parseInt);
        } catch (NumberFormatException e) {
            System.out.println("Error " + parseInt + " not an integer!");
        }

        return 0;
    }

    private void set(String label, int value) {

        switch (label) {
            case "x":
            case "X":
                this.x = value;
                break;
            case "y":
            case "Y":
                this.y = value;
                break;
            default:
                System.out.println("Invalid input " + label + " please select the maps height or width as x/y.");
                break;
        }
    }

}
