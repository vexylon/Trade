package bless.trade.commands;

import bless.trade.Trade;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import sun.jvm.hotspot.oops.Metadata;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.Objects;

public class TradeComand implements CommandExecutor {
    public ItemStack item;
    public static Inventory inven1;
    public static Inventory inven2;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p1;

        p1 = (Player) sender;
        if(args.length != 0){
                if(Objects.equals(args[0], "accept")){
                    if(Trade.p1 != null && Trade.p2 != null){
                        Trade.close = Boolean.TRUE;
                        Trade.p1.openInventory(inven1);
                        Trade.p2.openInventory(inven2);
                    }
                }
                else{
                    Trade.p1 = (Player) sender;
                    if(Bukkit.getPlayer(args[0]) != null){
                        Trade.p2 = Bukkit.getPlayer(args[0]);
                        TradeComand.inven1 = Bukkit.createInventory(null,45, ChatColor.GRAY + "You                   " + Trade.p2.getDisplayName());
                        TradeComand.inven2 = Bukkit.createInventory(null,45, ChatColor.GRAY + "You                   " + Trade.p1.getDisplayName());

                        //preset
                        item = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                        ItemStack coin = new ItemStack(Material.PLAYER_HEAD);
                        ItemStack done = new ItemStack(Material.ORANGE_TERRACOTTA);
                        ItemMeta m = item.getItemMeta();
                        item.setItemMeta(m);

                        inven1.setItem(4,item);
                        inven1.setItem(13,item);
                        inven1.setItem(22,item);
                        inven1.setItem(31,item);
                        inven1.setItem(40,item);

                        inven2.setItem(4,item);
                        inven2.setItem(13,item);
                        inven2.setItem(22,item);
                        inven2.setItem(31,item);
                        inven2.setItem(40,item);

                        inven1.setItem(36,coin);
                        inven1.setItem(39,done);
                        inven1.setItem(41,new ItemStack(Material.GRAY_DYE));

                        inven2.setItem(36,coin);
                        inven2.setItem(39,done);
                        inven2.setItem(41,new ItemStack(Material.GRAY_DYE));
                        //preset End

                        Trade.p2.sendMessage(ChatColor.GRAY + Trade.p1.getDisplayName() + ChatColor.GREEN + " has sent you a trade request type /trade accept to accept");
                        Trade.p1.sendMessage(ChatColor.GREEN + "You sent a trade request to " + Trade.p2.getDisplayName());
                    }

                }
        }
        else{
            p1.sendMessage("No Player Specified");
        }

        return false;
    }
}
