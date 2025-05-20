package de.sbg.unity.antimounttheft.NPC;

import de.sbg.unity.antimounttheft.AntiMountTheft;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.risingworld.api.World;
import net.risingworld.api.objects.Npc;
import net.risingworld.api.objects.Player;

public class AmtNpcs {
    
    private final AntiMountTheft plugin;
    private final HashMap<Long, AmtNpc> NpcList;
    
    public AmtNpcs(AntiMountTheft plugin) {
        this.plugin = plugin;
        this.NpcList = new HashMap<>();
    }
    
    public class AmtNpc {
        
        private final Npc npc;
        private String OwnerUID;
        private final List<String> MembersUID;
        private SpezialTyp spezialTyp;
        
        public AmtNpc(long npcID, String ownerUID, SpezialTyp typ) {
            this.npc = World.getNpc(npcID);
            this.OwnerUID = ownerUID;
            this.spezialTyp = typ;
            this.MembersUID = new ArrayList<>();
        }
        
        public AmtNpc(Npc npc, String ownerUID, SpezialTyp typ) {
            this.npc = npc;
            this.OwnerUID = ownerUID;
            this.spezialTyp = typ;
            this.MembersUID = new ArrayList<>();
        }
        
        public AmtNpc(Npc npc, Player player) {
            this.npc = npc;
            this.OwnerUID = player.getUID();
            this.MembersUID = new ArrayList<>();
            this.spezialTyp = SpezialTyp.None;
        }

        public List<String> getMembersUID() {
            return MembersUID;
        }

        public String getOwnerUID() {
            return OwnerUID;
        }

        public SpezialTyp getSpezialTyp() {
            return spezialTyp;
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

        public void setSpezialTyp(SpezialTyp spezialTyp) {
            this.spezialTyp = spezialTyp;
        }
        
    }
    
    public enum SpezialTyp {
        None,
        SavePos,
        Public,
        Taxi;
    }
}
