package ua.tox8729.vmotd.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ua.tox8729.vmotd.utils.ConfigUtil;
import ua.tox8729.vmotd.utils.HexUtil;

public class VmotdCommand implements CommandExecutor {
    private final ConfigUtil configUtil;

    public VmotdCommand(ConfigUtil configUtil) {
        this.configUtil = configUtil;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (!sender.hasPermission("vmotd.reload")) {
                sender.sendMessage(HexUtil.translate(configUtil.getNoPermissionMessage()));
                return true;
            }
            configUtil.reload();
            sender.sendMessage(HexUtil.translate(configUtil.getReloadMessages()));
            return true;
        }
        sender.sendMessage(HexUtil.translate(configUtil.getHelpMessages()));
        return true;
    }
}