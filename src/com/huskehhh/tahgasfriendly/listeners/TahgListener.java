package com.huskehhh.tahgasfriendly.listeners;

import com.huskehhh.tahgasfriendly.util.Utility;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TahgListener implements Listener {

    @EventHandler
    public void onPvP(EntityDamageByEntityEvent e) {

        Entity damager = e.getDamager();
        Entity damagee = e.getEntity();

        if (damager instanceof Player && damagee instanceof Player) {

            Player pdamager = (Player) damager;
            Player pdamagee = (Player) damagee;

            boolean cancel = Utility.friendlyCheck(pdamagee, pdamager);

            if (cancel) {
                pdamager.sendMessage(ChatColor.GOLD + "[TahgAsFriendly] " + ChatColor.GREEN + "You're tagged as friendly with this player, therefore you cannot deal them damage.");
            }

            e.setCancelled(cancel);
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        Utility.giveData(p);

    }


}
