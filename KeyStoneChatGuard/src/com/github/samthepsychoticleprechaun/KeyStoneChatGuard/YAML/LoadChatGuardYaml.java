package com.github.samthepsychoticleprechaun.KeyStoneChatGuard.YAML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;

import com.github.samthepsychoticleprechaun.KeyStoneChatGuard.KeyStoneChatGuard;

public class LoadChatGuardYaml {
	
	private static KeyStoneChatGuard plugin = KeyStoneChatGuard.plugin;
	private static Logger log = KeyStoneChatGuard.log;
	
	/**
	 *  Loads all files from <plugin>.jar file to plugins/<plugin> folder.
	 * 
	 * @return boolean
	 */
	public boolean loadYamls() {
		
		loadConf();
		loadSpam();
		loadFoulLanguage();
		
		return true;
		
	}
	
	/**
	 * Overwrites settings in "config.yml" file in plugins/<plugin> folder with default values.
	 * 
	 * @return boolean
	 */
	public boolean overwriteConf() {
		
		File configFile = KeyStoneChatGuard.configFile;
		FileConfiguration config = KeyStoneChatGuard.config;
		
		configFile.getParentFile().mkdirs();
		copy(plugin.getResource("config.yml"), configFile);
		KeyStoneChatGuard.configFile = configFile;
		
		try {
			config.load(configFile);
		} catch (FileNotFoundException e) {
			log.info("Config file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
		}

		KeyStoneChatGuard.config = config;
		
		return true;
		
	}
	
	/**
	 * Overwrites settings in "spam.yml" file in plugins/<plugin> folder with default values.
	 * 
	 * @return boolean
	 */
	public boolean overwriteSpam() {
		
		File spamFile = KeyStoneChatGuard.spamFile;
		FileConfiguration spam = KeyStoneChatGuard.spam;
		
		spamFile.getParentFile().mkdirs();
		copy(plugin.getResource("spam.yml"), spamFile);
		KeyStoneChatGuard.spamFile = spamFile;
		
		try {
			spam.load(spamFile);
		} catch (FileNotFoundException e) {
			log.info("Spam file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Error loading spam file!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			log.info("Error loading spam file!");
			e.printStackTrace();
		}

		KeyStoneChatGuard.spam = spam;
		
		return true;
		
	}
	
	/**
	 * Overwrites settings in "foullanguage.yml" file in plugins/<plugin> folder with default values.
	 * 
	 * @return boolean
	 */
	public boolean overwritefoulLanguage() {
		
		File foulLanguageFile = KeyStoneChatGuard.foulLanguageFile;
		FileConfiguration foulLanguage = KeyStoneChatGuard.foulLanguage;
		
		foulLanguageFile.getParentFile().mkdirs();
		copy(plugin.getResource("foullanguage.yml"), foulLanguageFile);
		KeyStoneChatGuard.foulLanguageFile = foulLanguageFile;
		
		try {
			foulLanguage.load(foulLanguageFile);
		} catch (FileNotFoundException e) {
			log.info("Foul language file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Error loading foul language file!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			log.info("Error loading foul language file!");
			e.printStackTrace();
		}

		KeyStoneChatGuard.foulLanguage = foulLanguage;
		
		return true;
		
	}
	
	/**
	 * Loads settings in "config.yml" file in plugins/<plugin> folder.
	 * 
	 * @return boolean
	 */
	public boolean loadConf() {
		
		File configFile = KeyStoneChatGuard.configFile;
		FileConfiguration config = KeyStoneChatGuard.config;
		
		try {
			config.load(configFile);
		} catch (FileNotFoundException e) {
			log.info("Config file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			log.info("Error loading config file!");
			e.printStackTrace();
		}

		KeyStoneChatGuard.config = config;
		
		return true;
		
	}
	
	/**
	 * Loads settings in "spam.yml" file in plugins/<plugin> folder.
	 * 
	 * @return boolean
	 */
	public boolean loadSpam() {
		
		File spamFile = KeyStoneChatGuard.spamFile;
		FileConfiguration spam = KeyStoneChatGuard.spam;
		
		try {
			spam.load(spamFile);
		} catch (FileNotFoundException e) {
			log.info("Spam file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Error loading spam file!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			log.info("Error loading spam file!");
			e.printStackTrace();
		}

		KeyStoneChatGuard.spam = spam;
		
		return true;
		
	}
	
	/**
	 * Loads settings in "foulLanguage.yml" file in plugins/<plugin> folder.
	 * 
	 * @return boolean
	 */
	public boolean loadFoulLanguage() {
		
		File foulLanguageFile = KeyStoneChatGuard.foulLanguageFile;
		FileConfiguration foulLanguage = KeyStoneChatGuard.foulLanguage;
		
		try {
			foulLanguage.load(foulLanguageFile);
		} catch (FileNotFoundException e) {
			log.info("Foul language file was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			log.info("Error loading foulLanguage file!");
			e.printStackTrace();
		} catch (InvalidConfigurationException e) {
			log.info("Error loading foulLanguage file!");
			e.printStackTrace();
		}

		KeyStoneChatGuard.foulLanguage = foulLanguage;
		
		return true;
		
	}
	
	
	/**
	 * Copies file from .jar file to plugins.<plugin name> directory
	 * 
	 * @param in
	 * @param file
	 */
	private void copy(InputStream in, File file) {
		
        try {
        	
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int len;
            
            while((len=in.read(buf))>0){
            	
                out.write(buf,0,len);
                
            }
            
            out.close();
            in.close();
            
        } catch (Exception e) {
        	
            e.printStackTrace();
            
        }
        
    }

}
