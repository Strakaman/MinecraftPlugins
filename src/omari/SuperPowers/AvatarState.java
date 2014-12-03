package omari.SuperPowers;


import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class AvatarState extends JavaPlugin {
	private static double initialY;
	private static double initialX;
	private static double initialZ;

	public static void catAttack(CommandSender sender) {
		sender.sendMessage("WORK YOU PIECE OF AVATAR!");
	}
	
	public static void airBend(Player p) {
		p.setAllowFlight(true);
	}
	
	public static void fireBend(Player p) {
		p.getInventory().setItemInHand(new ItemStack(Material.FIREBALL,1));
	}

	public static void lavaBend(Player p) {
		Location loc = p.getLocation();
		double james = loc.getX();
		double morgan = loc.getZ();
		double ahmad = loc.getY();
		
		loc.setX(james + 5);
		Block bl = loc.getBlock();
		bl.setType(Material.LAVA);
		loc.setX(james-5); 
		bl = loc.getBlock();
		bl.setType(Material.LAVA);
		loc.setX(james); //revert x to default
		
		loc.setZ(morgan + 5);
		bl = loc.getBlock();
		bl.setType(Material.LAVA);
		loc.setZ(morgan-5); 
		bl = loc.getBlock();
		bl.setType(Material.LAVA);
		p.getInventory().setItemInHand(new ItemStack(Material.LAVA_BUCKET,1));
	}
	
	public static void metalBend(Player p) {

//		Location loc = p.getPlayer().getLocation();
//		loc.setY(loc.getY() + height);
//		Block b = loc.getBlock();
//		b.setType(Material.WATER);
		Location loc = p.getLocation();
		double initialY = loc.getY() - 1;
		loc.setY(initialY);
		loc.setX(loc.getX() + 1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		loc.setY(initialY);
		loc.setZ(loc.getZ() + 1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		loc.setY(initialY);
		loc.setX(loc.getX() - 1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		loc.setY(initialY);
		loc.setX(loc.getX() - 1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		loc.setY(initialY);
		loc.setZ(loc.getZ() -1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		loc.setY(initialY);
		loc.setZ(loc.getZ() -1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		loc.setY(initialY);
		loc.setX(loc.getX() + 1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		loc.setY(initialY);
		loc.setX(loc.getX() + 1);
		makeYBlocks(loc, 5, Material.IRON_BLOCK);
		p.getInventory().setItemInHand(new ItemStack(Material.IRON_PICKAXE,1));
		p.getPlayer().getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
		p.getPlayer().getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		p.getPlayer().getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		p.getPlayer().getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
	}
	
	public static void waterBend(Player p) {
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
		p.getInventory().setItemInHand(new ItemStack(Material.WATER_BUCKET,1));
	}
	
	public static void earthBend(Player p) {
		Location loc = p.getLocation();
		setInitialCoord(p);
		resetCoord(loc);
		earthPosZDomino(loc, 3, -2, 3, 0, 0, 2, p);
		resetCoord(loc);
		earthPosZDomino(loc, 3, -2, -3, 0, 0, -2, p);
		p.getInventory().setItemInHand(new ItemStack(Material.DIRT,1));
	}
	
	public static void earthPosZDomino(Location loc, double wallSize, double x, double z, double y, double xGap, double zGap, Player p) {
		setInitialCoord(p);
		earthWall(loc, wallSize, x, z, y);
		resetCoord(loc);
		
		earthWall(loc, wallSize, x + xGap, z + zGap, y);
		earthWall(loc, wallSize, x - 1, 0, 1);
		resetCoord(loc);
		
		earthWall(loc, wallSize, x + xGap * 2, z + zGap * 2, y);
		earthWall(loc, wallSize, -wallSize, 0, 1);
		earthWall(loc, wallSize, -wallSize, 0, 1);
		resetCoord(loc);
		
		earthWall(loc, wallSize, x + xGap * 3, z + zGap * 3, y);
		earthWall(loc, wallSize, -wallSize, 0, 1);
		earthWall(loc, wallSize, -wallSize, 0, 1);
		earthWall(loc, wallSize, -wallSize, 0, 1);
		resetCoord(loc);
	}
	
	public static void earthWall(Location loc, double wallSize, double xOffSet, double zOffSet, double yOffSet) {
		double x = loc.getX();
		double z = loc.getZ();
		double y = loc.getY();
		
		loc.setX(x + xOffSet);
		loc.setZ(z + zOffSet);
		loc.setY(y + yOffSet);
		makeXBlocks(loc, wallSize, Material.DIRT);
	}
	
	public static void resetCoord(Location loc) {
		loc.setX(initialX);
		loc.setY(initialY);
		loc.setZ(initialZ);
	}
	
	public static void setInitialCoord(Player p) {
		Location loc = p.getLocation();
		initialY = loc.getY();
		initialX = loc.getX();
		initialZ = loc.getZ();
	}
	
	public static void makeYBlocks(Location loc, double length, Material mat) {
		for (int i = 0; i < length; i++) {
			loc.setY(loc.getY() + 1);
			
			Block bl = loc.getBlock();
			bl.setType(mat);
		}
	}
	
	public static void makeXBlocks(Location loc, double length, Material mat) {
		for (int i = 0; i < length; i++) {
			loc.setX(loc.getX() + 1);
			
			Block bl = loc.getBlock();
			bl.setType(mat);
		}
	}
	
	public static void makeZBlocks(Location loc, double length, Material mat) {
		for (int i = 0; i < length; i++) {
			loc.setX(loc.getX() + 1);
			
			Block bl = loc.getBlock();
			bl.setType(mat);
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
