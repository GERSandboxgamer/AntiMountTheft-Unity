
package de.sbg.unity.antimounttheft.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public enum SpezialNpc {
    
    NONE,
    TAXI,
    SAVE_POS;
    
    public static List<String> getAllSpezialNpcAsString(){
        return Arrays.stream(SpezialNpc.values()).map(Enum::name).collect(Collectors.toList());
    }
}
