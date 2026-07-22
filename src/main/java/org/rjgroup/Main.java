package org.rjgroup;

import org.rjgroup.commanders.CharacterCommander;
import org.rjgroup.info.CharacterInfo;
import org.rjgroup.info.GoblinCharacterInfo;
import org.rjgroup.info.PlayerCharacterInfo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        CharacterCommander com = new CharacterCommander();
        List<CharacterInfo> characterInfoList = new ArrayList<>();

        characterInfoList.add(new PlayerCharacterInfo("Player"));
        characterInfoList.add(new GoblinCharacterInfo("Gob1"));
        characterInfoList.add(new GoblinCharacterInfo("Gob2"));

        com.run(characterInfoList);
    }
}
