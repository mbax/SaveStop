package org.kitteh.simple;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SaveStop extends JavaPlugin {

    @Override
    public void onDisable() {
        this.getLogger().info("v" + this.getDescription().getVersion() + " disabled.");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("v" + this.getDescription().getVersion() + " enabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("savestop.run")) {
            this.getServer().savePlayers();
            for (World world : this.getServer().getWorlds()) {
                if (world != null) {
                    world.save();
                }
            }
            this.getServer().shutdown();
            this.getLogger().info(sender.getName() + " called SaveStop. Shutting down...");
        } else {
            sender.sendMessage("I don't think so.");
        }
        return true;
    }
}