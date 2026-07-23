package org.rjgroup.commanders;

import java.io.IOException;
import java.util.Scanner;

public class BasicCommander {

    protected final String COMMANDER_NAME = "Base Commander";
    protected Scanner scanner;
    protected String other_commands = "";

    public BasicCommander() {
        scanner = new Scanner(System.in);
    }

    private void helpCommand() {

        System.out.println(
                  "help - list of commands"
                + "\nexit - quit terminal"
                + other_commands
        );
    }

    public void run() {
        boolean run = true;

        while(run) {
            System.out.print("run: ");
            String[] commandList = scanner.nextLine().split(" ");

//            clearScreen();
            switch(commandList[0]) {
                case "help":
                    helpCommand();
                    break;
                case "exit":
                    exitCommand();
                    run = false;
                    break;
                default:
                    otherCommandList(commandList);
                    break;
            }
        }
    }

    protected void exitCommand() {

        System.out.println("Exiting " + COMMANDER_NAME + "!");
    }

    private void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void otherCommandList(String[] commandList) {

        System.out.println("Warning! " + commandList[0] + " is invalid use 'help' command to see list of commands!");
    }
}
