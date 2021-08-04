package com.chromium.killtracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Contains methods to allow for serialization in provided folders.
 * 
 * @author Chromium
 *
 */
public enum Serializable {
	
	Players(String.format("%s/Players", Main.getInstance().getDataFolder().getAbsolutePath()));
	
	private String dir;
	
	/**
	 * Constructs a Serializable enumerator.
	 * 
	 * @param dir          The directory to output the written file.
	 */
	Serializable(String dir) {
		this.dir = dir;
	}
	
	/**
	 * Writes to/Overrides a unique file containing serialized data of the given object.
	 * 
	 * @param obj          The data to be serialized (Must implement Serializable).
	 * @param uniqueName   The unique files name.
	 * @return             True if written successfully, false otherwise.
	 */
	public boolean writeUniqueFile(Object obj, String uniqueName) {
		try { 
        	File check = new File(this.dir);
        	
        	if(!check.exists()) {
        		check.mkdirs();
        	}
        
            FileOutputStream file = new FileOutputStream(String.format("%s/%s.dat", this.dir, uniqueName)); 
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            out.writeObject(obj);
            out.close(); 
            file.close();
            return true;
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }
	}
	
	/**
	 * Reads a unique files data for the given serializable enumerators directory.
	 * 
	 * @param uniqueName   The name of the file to be read.
	 * @return             The data after its been deserialized (Must be casted to datatype)
	 */
	public Object readUniqueFile(String uniqueName) {
		Object obj = null;
        
        try {
        	File check = new File(this.dir);
        	if(!check.exists()) {
        		check.mkdirs();
        	}
        	
        	String absolutePath = String.format("%s/%s.dat", this.dir, uniqueName);
        	check = new File(absolutePath);
        	if(!check.exists()) {
        		check.createNewFile();
        		return null;
        	}
            FileInputStream file = new FileInputStream(absolutePath);
            ObjectInputStream in = new ObjectInputStream(file); 

            obj = in.readObject(); 
            
            in.close(); 
            file.close();
            
            return obj;
        }
        catch (Exception e) {
        	return obj;
        }
	}
}
