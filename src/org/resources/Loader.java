/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.resources;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import org.resource.ImageResource;

/**
 *
 * @author ASUS
 */
public class Loader {
    private static Hashtable<String, List<ImageResource>> textures = new Hashtable();
    
    public static void load(String key, String path){
        List list;
        list = textures.get(key);
        if(list == null){
            list = new ArrayList();
        }
        list.add(new ImageResource(path));
        textures.put(key, list);
        
    }
    public static void load(String key, String[] paths){
        List list;
        list = textures.get(key);
        if(list == null){
            list = new ArrayList();
        }
        for(String path : paths){
            list.add(new ImageResource(path));
        }
        
        textures.put(key, list);
        
    }
    public static List getImages(String key){
        List list;
        list = textures.get(key);
        if(list == null){
            list = new ArrayList();
        }
        return list;
    }
}
