package omari.SuperPowers;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class Kazaam {
	private static int foodCount;
	private static Player pp;
	
	public static void rainFood(Player p)
	{
		pp = p;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(new SuperPowers(), new Runnable() {
			
			public void run() {
				if (foodCount >= 20) {
					foodCount = 0;
				}
				foodCount++;
				pp.getWorld().dropItemNaturally(pp.getLocation(), new ItemStack(Material.BAKED_POTATO));
			}
		}, 20, 20);
	}

}
