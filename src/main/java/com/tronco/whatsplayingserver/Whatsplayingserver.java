package com.tronco.whatsplayingserver;

import org.bukkit.plugin.java.JavaPlugin;

public final class Whatsplayingserver extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("whatsplaying").setExecutor(new Whatsplayingcommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
