package com.huskehhh.tahgasfriendly;

import com.huskehhh.tahgasfriendly.listeners.TahgListener;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class TahgAsFriendly extends JavaPlugin {

    YamlConfiguration config = YamlConfiguration.loadConfiguration(new File("plugins/TahgAsFriendly/config.yml"));

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TahgListener(), this);
        createConfig();
    }

    public void onDisable() {

    }

    private void createConfig() {

        File f = new File("plugins/WarpSigns/config.yml");

        if (!f.exists()) {

            config.options().header("TahgAsFriendly, made by _Husky_");

            try {
                config.save("plugins/WarpSigns/config.yml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }


}
