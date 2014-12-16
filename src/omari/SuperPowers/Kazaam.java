package omari.SuperPowers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;


public class Kazaam extends JavaPlugin {
	private static Player pp;

	public static void rainFood(Player p) {
		pp = p;
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(new Kazaam(), new Runnable() {
            @Override
            public void run() {
                // Do something
            	pp.getWorld().dropItemNaturally(pp.getLocation(), new ItemStack(Material.BAKED_POTATO));
            }
        }, 0L, 20L);
    }

}
