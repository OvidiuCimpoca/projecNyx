package org.rjgroup;

import org.rjgroup.commanders.MainMenuStateCommander;

/*
* The main Entry point of the Project loads Command Line Prompt
* */
// TODO: Introduce States, Local Movement State, Global Movement State and the Menu States
public class Main {
    static void main() {

        MainMenuStateCommander mainCommander = new MainMenuStateCommander();

        mainCommander.run();
    }
}
