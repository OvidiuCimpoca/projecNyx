package org.rjgroup;

import org.rjgroup.commanders.menu.MainMenuStateCommander;

/*
* The main Entry point of the Project loads Command Line Prompt
* */
// TODO: Introduce States
// TODO: Map State
// TODO: In Game Menu State
public class Main {
    static void main() {

        MainMenuStateCommander mainCommander = new MainMenuStateCommander();

        mainCommander.run();
    }
}
