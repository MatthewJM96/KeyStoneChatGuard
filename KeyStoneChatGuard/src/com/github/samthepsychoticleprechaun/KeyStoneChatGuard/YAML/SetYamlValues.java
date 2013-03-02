package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.YAML;

import org.bukkit.configuration.file.FileConfiguration;
import com.github.samthepsychoticleprechaun.KeyStoneCore.KeyStoneCore;

public class SetYamlValues {
	
	public static void setConfigValues(String path, String value) {
		
		FileConfiguration config = KeyStoneCore.config;
		config.set(path, value);
		
	}
	
	public static void setSpamValues(String path, String value) {
		
		FileConfiguration spam = KeyStoneCore.spam;
		spam.set(path, value);
		
	}
	
	public static void setSpamValues(String path, int value) {
		
		FileConfiguration spam = KeyStoneCore.spam;
		spam.set(path, value);
		
	}

}
