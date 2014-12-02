package omari.SuperPowers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AvatarState extends JavaPlugin {
	private static double height = 5;
	private static double initialHeight;
	private static double initialWidth;
	public static double width = 5;

	public static void catAttack(CommandSender sender) {
		sender.sendMessage("WORK YOU PIECE OF AVATAR!");
	}
	
	public static void glassMaker(Player p) {

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
	
	public static void fourColumns(Player p) {
		Location loc = p.getLocation();
		double james = loc.getX();
		double morgan = loc.getZ();
		double ahmad = loc.getY();
		
		loc.setY(ahmad + 5); //initial height
		loc.setX(james + 5);
		Block bl = loc.getBlock();
		bl.setType(Material.WATER);
		loc.setX(james-5); 
		bl = loc.getBlock();
		bl.setType(Material.WATER);
		loc.setX(james); //revert x to default
		
		loc.setZ(morgan + 5);
		bl = loc.getBlock();
		bl.setType(Material.WATER);
		loc.setZ(morgan-5); 
		bl = loc.getBlock();
		bl.setType(Material.WATER);
	}
	
	public static void makeVerticleBlocks(Location loc) {
		loc.setY(initialHeight);
		for (int i = 0; i < height; i++) {
			loc.setY(loc.getY() + 1);
			
			Block bl = loc.getBlock();
			bl.setType(Material.GLASS);
		}
	}
	
	public static void makeHorizantolBlocks(Location loc) {
		loc.setX(initialHeight);
		for (int i = 0; i < width; i++) {
			loc.setX(loc.getX() + 1);
			Block bl = loc.getBlock();
			bl.setType((Material.DIRT));
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
