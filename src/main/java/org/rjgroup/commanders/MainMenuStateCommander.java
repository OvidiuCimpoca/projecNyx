package org.rjgroup.commanders;

import org.rjgroup.info.CharacterInfo;
import org.rjgroup.info.GoblinCharacterInfo;
import org.rjgroup.info.PlayerCharacterInfo;

import java.util.ArrayList;
import java.util.List;

public class MainMenuStateCommander extends BasicCommander {

    protected final String COMMANDER_NAME = "Main Menu Commander";

    public MainMenuStateCommander() {
        super();
        other_commands = "\ncombat - Try Combat Tutorial"
            + "\nnewChar - Create and Edit a new Character";
    }

    protected void otherCommandList(String[] commandList) {
        switch (commandList[0]) {
            // Todo: load Player info from a save file
            // Todo: Make save file system
            case "combat":
                List<CharacterInfo> characterInfoList = new ArrayList<>();
                characterInfoList.add(new PlayerCharacterInfo("Player"));
                characterInfoList.add(new GoblinCharacterInfo("Gob1"));
                characterInfoList.add(new GoblinCharacterInfo("Gob2"));
                CombatStateCommander combatCommander = new CombatStateCommander(characterInfoList);

                combatCommander.run();
                break;
            case "newChar":
                CharacterEditorCommander editCharacter = new CharacterEditorCommander();
                editCharacter.run();
                break;
        }
    }
}
