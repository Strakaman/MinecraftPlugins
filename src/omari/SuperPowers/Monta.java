package omari.SuperPowers;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Monta extends BukkitRunnable{
	SuperPowers mvp;
	BukkitScheduler scheduler;
	Player hateTheGame;
	
	public Monta(SuperPowers sp, Player p) {
		// TODO Auto-generated constructor stub
		mvp = sp;
		scheduler = Bukkit.getServer().getScheduler();
		hateTheGame = p;
	}

	int counter = 0;
    
	@Override
    public void run() {
		int james = hateTheGame.getLocation().getBlockX();
		int morgan = hateTheGame.getLocation().getBlockY();
		Location loc = hateTheGame.getLocation();
    	if (counter > 5) {
    		this.cancel();
    	} else {
    	
    	hateTheGame.getWorld().dropItemNaturally(hateTheGame.getLocation(), new ItemStack(Material.BAKED_POTATO));
    	counter++;
    	scheduler.scheduleAsyncDelayedTask(mvp, this, 50);
    	}
    }
	
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
