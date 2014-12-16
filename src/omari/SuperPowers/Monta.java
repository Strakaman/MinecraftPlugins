package omari.SuperPowers;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

public class Monta extends BukkitRunnable{
	SuperPowers mvp;
	BukkitScheduler scheduler;
	
	public Monta(SuperPowers sp) {
		// TODO Auto-generated constructor stub
		mvp = sp;
		scheduler = Bukkit.getServer().getScheduler();
	}

	int counter = 0;
    
	@Override
    public void run() {
    	if (counter > 5) {
    		this.cancel();
    		//Bukkit.getScheduler().cancelTasks(<>);
    	} else {
        // Do something
    	Bukkit.broadcastMessage("METAL DRAYMOND!");
    	counter++;
    	scheduler.scheduleSyncRepeatingTask(mvp, this, 5, 0);
    	//p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BAKED_POTATO));
    	}
    }

}
