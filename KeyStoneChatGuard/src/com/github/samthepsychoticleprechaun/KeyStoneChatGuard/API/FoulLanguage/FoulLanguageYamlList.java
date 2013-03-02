package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.API.FoulLanguage;

import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.KeyStoneChatGuard;
import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.Storage.SpamValues;
import com.github.samthepsychoticleprechaun.KeyStoneCore.API.General.TimeParser;

public class FoulLanguageYamlList {
	
	KeyStoneChatGuard plugin = KeyStoneChatGuard.plugin;
	
	public void createPlayerField(String name) {
		
		if(!SpamValues.playerName.contains(name)) {
			
			SpamValues.playerName.add(name);
			SpamValues.offenceCount.add(0);
			SpamValues.latestRemovalCount.add(TimeParser.getSystDate());
			
		}
		
	}
	
	public void changeCount(String name, int countIncr) {
		
		//Get position of player in list
		int pos = SpamValues.playerName.indexOf(name);
		
		//Change spam count of player
		int curCount = SpamValues.offenceCount.get(pos);
		int count = curCount + countIncr;
		SpamValues.offenceCount.set(pos, count);		
		
	}
	
	public void changeLatestRemovalCount(String name, String latestRemovalCount) {
		
		//Get position of player in list
		int pos = SpamValues.playerName.indexOf(name);
				
		//Change latestRemovalCount of player
		SpamValues.latestRemovalCount.set(pos, latestRemovalCount);
		
	}
	

}
