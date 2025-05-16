package ua.tox8729.vmotd;

import org.bukkit.plugin.java.JavaPlugin;
import ua.tox8729.vmotd.commands.VmotdCommand;
import ua.tox8729.vmotd.listeners.ServerListListener;
import ua.tox8729.vmotd.utils.ConfigUtil;

public class VMotd extends JavaPlugin {
    @Override
    public void onEnable() {
        ConfigUtil configUtil = new ConfigUtil(this);
        getServer().getPluginManager().registerEvents(new ServerListListener(configUtil), this);
        getCommand("vmotd").setExecutor(new VmotdCommand(configUtil));
        getLogger().info("VMotd успешно включён!");
    }

    @Override
    public void onDisable() {
        getLogger().info("VMotd выключен!");
    }
}