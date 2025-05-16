package ua.tox8729.vmotd.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import ua.tox8729.vmotd.utils.ConfigUtil;
import ua.tox8729.vmotd.utils.HexUtil;

public class ServerListListener implements Listener {
    private final ConfigUtil configUtil;

    public ServerListListener(ConfigUtil configUtil) {
        this.configUtil = configUtil;
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        String line1 = HexUtil.translate(configUtil.getMotdLine1());
        String line2 = HexUtil.translate(configUtil.getMotdLine2());
        event.setMotd(line1 + "\n" + line2);
    }
}