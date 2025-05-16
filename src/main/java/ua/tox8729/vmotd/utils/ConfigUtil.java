package ua.tox8729.vmotd.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigUtil {
    private final JavaPlugin plugin;
    private String motdLine1;
    private String motdLine2;
    private String reloadMessages;
    private String noPermissionMessage;
    private String helpMessages;

    public ConfigUtil(JavaPlugin plugin) {
        this.plugin = plugin;
        reload();
    }

    public void reload() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        FileConfiguration config = plugin.getConfig();

        motdLine1 = config.getString("motd.line1", "Добро пожаловать на сервер!");
        motdLine2 = config.getString("motd.line2", "Версия 1.16.5+");
        helpMessages = config.getString("messages.help-messages", "&cИспользование: /vmotd reload");
        reloadMessages = config.getString("messages.reload-messages", "&aКонфигурация успешно перезагружена!");
        noPermissionMessage = config.getString("messages.no-permission", "&cУ вас нет прав для выполнения этой команды!");

    }

    public String getMotdLine1() {
        return motdLine1;
    }

    public String getMotdLine2() {
        return motdLine2;
    }

    public String getReloadMessages() {
        return reloadMessages;
    }

    public String getNoPermissionMessage() {
        return noPermissionMessage;
    }

    public String getHelpMessages() {
        return helpMessages;
    }
}