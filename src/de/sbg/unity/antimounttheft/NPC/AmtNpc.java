package de.sbg.unity.antimounttheft.NPC;

import de.sbg.unity.antimounttheft.Utils.SpezialNpc;
import java.util.ArrayList;
import java.util.List;
import net.risingworld.api.World;
import net.risingworld.api.objects.Npc;
import net.risingworld.api.objects.Player;

public class AmtNpc {
    
    private final Npc npc;
    private String OwnerUID;
    private final List<String> MembersUID;
    private SpezialNpc spezialNpc;
    
    public AmtNpc(long npcID, String ownerUID, SpezialNpc typ) {
        this.npc = World.getNpc(npcID);
        this.OwnerUID = ownerUID;
        this.spezialNpc = typ;
        this.MembersUID = new ArrayList<>();
    }
    
    public AmtNpc(Npc npc, String ownerUID, SpezialNpc typ) {
        this.npc = npc;
        this.OwnerUID = ownerUID;
        this.spezialNpc = typ;
        this.MembersUID = new ArrayList<>();
    }
    
    public AmtNpc(long npc, String player) {
        this.npc = World.getNpc(npc);
        this.OwnerUID = player;
        this.MembersUID = new ArrayList<>();
        this.spezialNpc = SpezialNpc.NONE;
    }
    
    public AmtNpc(Npc npc, Player player) {
        this.npc = npc;
        this.OwnerUID = player.getUID();
        this.MembersUID = new ArrayList<>();
        this.spezialNpc = SpezialNpc.NONE;
    }
    
    public SpezialNpc getSpezialNpc() {
        return spezialNpc;
    }
    
    public void setSpezialNpc(SpezialNpc spezialNpc) {
        this.spezialNpc = spezialNpc;
    }
    
    public List<String> getMembersUID() {
        return MembersUID;
    }
    
    public String getOwnerUID() {
        return OwnerUID;
    }
    
    public Npc getNpc() {
        return npc;
    }
    
    public void addMember(Player player) {
        addMember(player.getUID());
    }
    
    public void addMember(String playerUID) {
        MembersUID.add(playerUID);
    }
    
    public boolean isMember(Player player) {
        return isMember(player.getUID());
    }
    
    public boolean isMember(String playerUID) {
        return MembersUID.contains(playerUID);
    }
    
    public boolean removeMember(Player player) {
        return removeMember(player.getUID());
    }
    
    public boolean removeMember(String playerUID) {
        return MembersUID.remove(playerUID);
    }
    
    public void setImmortal(boolean b) {
        npc.setInvincible(b);
    }
    
    public void setOwnerUID(String OwnerUID) {
        this.OwnerUID = OwnerUID;
    }
    
}
