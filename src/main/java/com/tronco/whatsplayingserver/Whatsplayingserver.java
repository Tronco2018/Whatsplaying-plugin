package com.tronco.whatsplayingserver;

import org.bukkit.plugin.java.JavaPlugin;

public final class Whatsplayingserver extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            getCommand("whatsplaying").setExecutor(new Whatsplayingcommand());
        } catch (NullPointerException e){
            getLogger().severe("Can't find that command");
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
