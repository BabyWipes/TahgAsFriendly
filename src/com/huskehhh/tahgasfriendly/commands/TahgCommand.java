package com.huskehhh.tahgasfriendly.commands;

import com.huskehhh.tahgasfriendly.util.Utility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TahgCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {

            Player p = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("tag") && args.length == 1) {

                if (p.hasPermission("tahgasfriendly.tag")) {

                    Player target = Bukkit.getServer().getPlayer(args[0]);

                    if (Utility.pendingCheck(target, p)) {

                        Utility.removePending(target, p);
                        Utility.addFriendly(p, target);
                        Utility.addFriendly(target, p);

                        p.sendMessage(ChatColor.GOLD + "[TahgAsFriendly] " + ChatColor.GREEN + "You're now tagged as friendly to " + target.getName());
                        target.sendMessage(ChatColor.GOLD + "[TahgAsFriendly] " + ChatColor.GREEN + "You're now tagged as friendly to " + p.getName());

                    } else {

                        target.sendMessage(ChatColor.GOLD + "[TahgAsFriendly] " + ChatColor.GREEN + p.getName() + " wants to tag you as friendly");
                        Utility.addPending(p, target);

                    }

                }

                return true;

            } else if (cmd.getName().equalsIgnoreCase("untag") && args.length == 1) {

                if (p.hasPermission("tahgasfriendly.untag")) {

                    Player target = Bukkit.getServer().getPlayer(args[0]);

                    if (Utility.friendlyCheck(p, target) || Utility.friendlyCheck(target, p)) {

                        Utility.removeFriendly(p, target);
                        Utility.removeFriendly(target, p);

                        p.sendMessage(ChatColor.GOLD + "[TahgAsFriendly] " + ChatColor.RED + "You're now un-tagged as friendly to " + target.getName());
                        target.sendMessage(ChatColor.GOLD + "[TahgAsFriendly] " + ChatColor.RED + "You're now un-tagged as friendly to " + p.getName());

                    }

                }

                return true;

            }

            return true;

        }

        return false;
    }
}
