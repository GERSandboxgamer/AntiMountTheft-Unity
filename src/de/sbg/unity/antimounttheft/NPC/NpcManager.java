package de.sbg.unity.antimounttheft.NPC;

import java.util.HashMap;
import net.risingworld.api.objects.Npc;
import net.risingworld.api.objects.Player;


public class NpcManager {
    
    private final HashMap<Long, AmtNpc> npcList;
    
    public NpcManager() {
        this.npcList = new HashMap<>();
    }

    public HashMap<Long, AmtNpc> getNpcList() {
        return npcList;
    }
    
    public boolean addNpc(Npc npc, Player owner) {
        return addNpc(npc.getGlobalID(), owner.getUID());
    }
    
    public boolean addNpc(long id, String ownerUID) {
        if (!isAmtNpc(id)) {
            AmtNpc npc = new AmtNpc(id, ownerUID);
            npcList.put(id, npc);
            return true;
        }
        return false;
    }
    
    public boolean removeNpc(Npc npc) {
        return removeNpc(npc.getGlobalID());
    }
    
    public boolean removeNpc(long npcID) {
        if (isAmtNpc(npcID)) {
            npcList.remove(npcID);
            return true;
        }
        return false;
    }
    
    public boolean isAmtNpc(Npc npc){
        return isAmtNpc(npc.getGlobalID());
    }
    
    public boolean isAmtNpc(long id) {
        return npcList.containsKey(id);
    }
}
