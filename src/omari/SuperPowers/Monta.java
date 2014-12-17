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
	final SuperPowers mvp;
	final BukkitScheduler scheduler;
	final Player hateTheGame;
	private static Material[] foodList = new Material[7];
	
	public Monta(SuperPowers sp, Player p) {
		// TODO Auto-generated constructor stub
		mvp = sp;
		scheduler = Bukkit.getServer().getScheduler();
		hateTheGame = p;
		foodList[0] = Material.COOKED_BEEF;
		foodList[1] = Material.COOKED_CHICKEN;
		foodList[2] = Material.BAKED_POTATO;
		foodList[3] = Material.BREAD;
		foodList[4] = Material.COOKED_FISH;
		foodList[5] = Material.EGG;
		foodList[6] = Material.COOKIE;
	}

	int counter = 0;
    
	@Override
    public void run() {
		int james = hateTheGame.getLocation().getBlockX();
		int morgan = hateTheGame.getLocation().getBlockZ();
		int ahmad = hateTheGame.getLocation().getBlockY();
		Location loc = hateTheGame.getLocation();
    	if (counter > 5) {
    		SuperPowers.kazaaming = false;
    		this.cancel();
    	} else {
    	for (int i = 0; i < 10; i++) {
    	calcRandomDrop(loc, james, morgan, ahmad);
    	}
    	counter++;
    	scheduler.scheduleAsyncDelayedTask(mvp, this, 20);
    	}
    }
	
	void calcRandomDrop(Location loc, int james, int morgan, int ahmad) {
		loc.setX(james + randInt(-10, 10));
    	loc.setZ(morgan + randInt(-10, 10));
    	loc.setY(ahmad + 10);
    	hateTheGame.getWorld().dropItemNaturally(loc, new ItemStack(foodList[randInt(0, 6)]));
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
