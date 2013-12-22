package com.huskehhh.tahgasfriendly.util;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    private static YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/TahgAsFriendly/config.yml"));

    public static boolean friendlyCheck(Player damager, Player damagee) {
        return config.getStringList(damager.getName() + ".friendly").contains(damagee.getName());
    }

    public static void addFriendly(Player original, Player add) {
        config.getStringList(original.getName() + ".friendly").add(add.getName());
        try {
            config.save(new File("plugins/TahgAsFriendly/config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeFriendly(Player original, Player remove) {

        List<String> iteration = config.getStringList(original.getName() + ".friendly");

        for (int i = 0; i < iteration.size(); i++) {

            String check = iteration.get(i);

            if (check.equals(remove.getName())) iteration.remove(i);

        }

    }

    public static void giveData(Player original) {

        List<String> falseData = new ArrayList<String>();

        if (config.getStringList(original.getName() + ".friendly") == null) {
            config.set(original.getName() + ".friendly", falseData);
            try {
                config.save(new File("plugins/TahgAsFriendly/config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (config.getStringList(original.getName() + ".pending") == null) {
            config.set(original.getName() + ".pending", falseData);
            try {
                config.save(new File("plugins/TahgAsFriendly/config.yml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void addPending(Player original, Player add) {
        config.getStringList(original.getName() + ".pending").add(add.getName());
        try {
            config.save(new File("plugins/TahgAsFriendly/config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removePending(Player original, Player remove) {

        List<String> iteration = config.getStringList(original.getName() + ".pending");

        for (int i = 0; i < iteration.size(); i++) {

            String check = iteration.get(i);

            if (check.equals(remove.getName())) iteration.remove(i);

        }

    }

    public static boolean pendingCheck(Player original, Player check) {
        return config.getStringList(original.getName() + ".pending").contains(check.getName());
    }


}
