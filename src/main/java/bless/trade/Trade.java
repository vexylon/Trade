package bless.trade;

import bless.trade.commands.TradeComand;
import bless.trade.listeners.InventoryClose;
import bless.trade.listeners.MenuListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Trade extends JavaPlugin {

    public static Player p1;
    public static Player p2;

    public static Boolean close = true;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("Trade").setExecutor(new TradeComand());
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClose(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
