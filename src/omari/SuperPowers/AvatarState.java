package omari.SuperPowers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AvatarState extends JavaPlugin {
	private static int height = 5;
	private static double initialHeight;

	public static void catAttack(CommandSender sender) {
		sender.sendMessage("WORK YOU PIECE OF AVATAR!");
	}
	
	public static void rainMaker(Player p) {

//		Location loc = p.getPlayer().getLocation();
//		loc.setY(loc.getY() + height);
//		Block b = loc.getBlock();
//		b.setType(Material.WATER);
		
		Location loc = p.getLocation();
		initialHeight = loc.getY();
		
		
		loc.setX(loc.getX() + 1);
		makeVerticleBlocks(loc);
		loc.setZ(loc.getZ() + 1);
		makeVerticleBlocks(loc);
		loc.setX(loc.getX() - 1);
		makeVerticleBlocks(loc);
		loc.setX(loc.getX() - 1);
		makeVerticleBlocks(loc);
		loc.setZ(loc.getZ() -1);
		makeVerticleBlocks(loc);
		loc.setZ(loc.getZ() -1);
		makeVerticleBlocks(loc);
		loc.setX(loc.getX() + 1);
		makeVerticleBlocks(loc);
		loc.setZ(loc.getX() + 1);
		makeVerticleBlocks(loc);
	}
	
	public static void makeVerticleBlocks(Location loc) {
		loc.setY(initialHeight);
		for (int i = 0; i < height; i++) {
			loc.setY(loc.getY() + 1);
			
			Block bl = loc.getBlock();
			bl.setType(Material.GLASS);
		}
	}
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();
	}


}
