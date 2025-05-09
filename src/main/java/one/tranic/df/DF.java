package one.tranic.df;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DF extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockForm(BlockFormEvent event) {
        if (event.isCancelled()) return;
        var block = event.getBlock().getType();
        var newBlock = event.getNewState().getType();
        if (block.equals(Material.WATER) && newBlock.equals(Material.ICE)) {
            event.setCancelled(true);
        }
    }
}
