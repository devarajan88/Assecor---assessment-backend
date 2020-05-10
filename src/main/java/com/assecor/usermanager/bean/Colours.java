package com.assecor.usermanager.bean;

import java.util.HashMap;
import java.util.Map;

public class Colours {
    
    Map<Integer, String> colours;
    
    public Colours(){
        colours = new HashMap<>();
        colours.put(1, "blue");
        colours.put(2, "green");
        colours.put(3, "violet");
        colours.put(4, "red");
        colours.put(5, "yellow");
        colours.put(6, "turquoise");
        colours.put(7, "White");
    }
    
    public String getColour(int colour){
        return colours.get(colour);
    }
}
