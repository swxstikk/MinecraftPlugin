package me.swastik.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Events extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent e) {
        //Here is the code that wil be executed when the event is triggered.
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GREEN + "You got out of the bed.");
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPermission("Commands.move")) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You do not have sufficient permission to move.");
        }
    }

    @EventHandler
    public void onPlayerEvent(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if(!p.hasPermission("Commands.move")) {
            e.getItemDrop().sendMessage(ChatColor.GREEN + "YOU DROPPED YOUR ITEM!!");
            // getItemDrop() retrieves information about the item in hand and stores it.
            // This method is useful to keep track of dropped items.
        }
    }

}
