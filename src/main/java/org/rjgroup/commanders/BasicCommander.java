package org.rjgroup.commanders;

import org.rjgroup.info.CharacterInfo;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BasicCommander {

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

    public void run(List<CharacterInfo> list) {
        boolean run = true;

        while(run) {
            printScene(list);
            System.out.print("run: ");
            String[] commandList = scanner.nextLine().split(" ");

            switch(commandList[0]) {
                case "help":
                    clearScreen();
                    helpCommand();
                    break;
                case "exit":
                    clearScreen();
                    System.out.println("By! By!");
                    run = false;
                    break;
                default:
                    clearScreen();
                    otherCommandList(commandList, list);
            }
        }
    }

    private void printScene(List<CharacterInfo> characterList) {

        characterList.forEach(characterInfo -> {
            String status = (characterInfo.isAlive())? "alive" : "dead";
            System.out.println("Character '" + characterInfo.getName() + "' is " + status + " with HP: "
                    + characterInfo.getHP() + "/" + characterInfo.getMaxHP() + "!" );
        });
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

    protected void otherCommandList(String[] command, List<CharacterInfo> list) {
        switch (command[0]) {
            default:
                System.out.println("Warning! " + command[0] + " is invalid use 'help' command to see list of commands!");
        }
    }
}
