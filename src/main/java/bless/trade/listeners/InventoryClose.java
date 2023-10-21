package bless.trade.listeners;

import bless.trade.Trade;
import bless.trade.commands.TradeComand;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import static bless.trade.Trade.p1;
import static bless.trade.Trade.p2;
import static bless.trade.commands.TradeComand.inven1;
import static bless.trade.commands.TradeComand.inven2;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

public class InventoryClose implements Listener {
    @EventHandler
    public void invClose(InventoryCloseEvent event) throws InterruptedException {
        if(event.getInventory() == inven1 && Trade.p2.getOpenInventory().getTitle().equals(ChatColor.GRAY + "You                   " + Trade.p1.getDisplayName())){
            if(Trade.close) {
                Trade.close = Boolean.FALSE;
                System.out.println(Trade.p2.getOpenInventory().getTitle());
                p2.closeInventory();
                event.getPlayer().sendMessage(ChatColor.RED + "You cancelled the trade");
                p2.sendMessage(Trade.p1.getDisplayName() + ChatColor.RED + " Cancelled the trade");
            }
        }
        if(event.getInventory() == inven2 && Trade.p1.getOpenInventory().getTitle().equals(ChatColor.GRAY + "You                   " + Trade.p2.getDisplayName())){
            if(Trade.close) {
                Trade.close = Boolean.FALSE;
                System.out.println(Trade.p1.getOpenInventory().getTitle());
                p1.closeInventory();
                event.getPlayer().sendMessage(ChatColor.RED + "You cancelled the trade");
                p1.sendMessage(Trade.p2.getDisplayName() + ChatColor.RED + " Cancelled the trade");
            }
        }
    }
}
