package omari.SuperPowers;


import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class AvatarState extends JavaPlugin {
	private static double initialY;
	private static double initialX;
	private static double initialZ;
	private static boolean activated;
	
	static ArrayList<Player> playersInAvatarState = new ArrayList<Player>();
	
	public static void avatarOn(CommandSender s)
	{
		Player p = (Player)s;
		if (!playersInAvatarState.contains(p))
				{
			playersInAvatarState.add(p);
					
				}
		p.setAllowFlight(true);
		p.getInventory().setItemInHand(new ItemStack(Material.FIREBALL,1));
		//p.launchProjectile(Fireball.class);	
	}
	
	public static void avatarOff(Player play)
	{
		if (playersInAvatarState.contains(play))
		{
			playersInAvatarState.remove(play);
            play.setAllowFlight(false);
		}
	}
	
//	public static void activateAvatar(Player p, boolean isOn) {
//		if (isOn) {
//			activated = isOn;

//		} else {
//			activated = isOn;
//		}
//	}
	
	public static void commandAvatar(Player p, Command command) {
		if (playersInAvatarState.contains(p)) {
		if (command.getName().equalsIgnoreCase("airBend")) {
			//airBend(p);
		}
		
		if (command.getName().equalsIgnoreCase("earthBend")) {
			earthBend(p);
		}
		
		if (command.getName().equalsIgnoreCase("metalBend")) {
			metalBend(p);
		}
		
		if (command.getName().equalsIgnoreCase("waterBend")) {
			waterBend(p);
		}
		
		if (command.getName().equalsIgnoreCase("fireBend")) {
			fireBend(p, 10);
			fireBend(p, 5);
		}
		
		if (command.getName().equalsIgnoreCase("lavabend")) {
			lavaBend(p);
		}
		}
	}
	
	public static void airBend(Player p) {
		
	}
	
	public static void fireBend(Player p, int length) {
		Location loc = p.getLocation();
		double james = loc.getX();
		double morgan = loc.getZ();
		double ahmad = loc.getY();
		loc.setY(ahmad);
		Block bl = loc.getBlock();
		
		for (int i = 0; i < length; i++) {
			loc.setX(james+i);
			loc.setZ(morgan + length -i);
			bl = loc.getBlock();
			bl.setType(Material.FIRE);
		}
		for (int i = 0; i < length; i++) {
			loc.setX(james-i + length);
			loc.setZ(morgan-i);
			bl = loc.getBlock();
			bl.setType(Material.FIRE);
		}
		for (int i = 0; i < length; i++) {
			loc.setX(james-i);
			loc.setZ(morgan+i-length);
			bl = loc.getBlock();
			bl.setType(Material.FIRE);
		}
		for (int i = 0; i < length; i++) {
			loc.setX(james+i-length);
			loc.setZ(morgan+i);
			bl = loc.getBlock();
			bl.setType(Material.FIRE);
		}
		
		p.getWorld().createExplosion(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), 4f, false, false);
	}
	
	public static void computerDiamond(int length) {

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
		Block bl = loc.getBlock();
		bl.setType(Material.IRON_BLOCK);
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
		earthPosZDomino(loc, 3, -2, 3, 0, 0, 1, p);
		resetCoord(loc);
		earthPosZDomino(loc, 3, -2, -3, 0, 0, -1, p);
		resetCoord(loc);
		earthPosXDomino(loc, 3, 3, -2, 0, 1, 0, p);
		resetCoord(loc);
		earthPosXDomino(loc, 3, -3, -2, 0, -1, 0, p);
		p.getInventory().setItemInHand(new ItemStack(Material.DIRT,64));
		earthPillar(p);
	}
	
	public static void earthPillar(Player p) {
		Location loc = p.getLocation();
		double james = loc.getX();
		double morgan = loc.getZ();
		double ahmad = loc.getY();
		loc.setY(ahmad-1);
		Block bl = loc.getBlock();
		for (int k = -2; k <= 2; k++){
		loc.setZ(morgan+k);
		for (int j = -2; j <= 2; j++) {
		loc.setX(james+j);
		for (int i = 0; i < p.getLocation().getY(); i++) {
			loc.setY(ahmad-i);
			bl = loc.getBlock();
			if (bl.getType().equals(Material.AIR)) {
				bl.setType(Material.DIRT);
			}
		}
		}
		}
	}
	
	public static void earthPosZDomino(Location loc, double wallSize, double x, double z, double y, double xGap, double zGap, Player p) {
		setInitialCoord(p);
		earthXWall(loc, wallSize, x, z, y);
		resetCoord(loc);
		
		earthXWall(loc, wallSize, x + xGap, z + zGap, y);
		earthXWall(loc, wallSize, x - 1, 0, 1);
		resetCoord(loc);
		
		earthXWall(loc, wallSize, x + xGap * 2, z + zGap * 2, y);
		earthXWall(loc, wallSize, -wallSize, 0, 1);
		earthXWall(loc, wallSize, -wallSize, 0, 1);
		resetCoord(loc);
		
		earthXWall(loc, wallSize, x + xGap * 3, z + zGap * 3, y);
		earthXWall(loc, wallSize, -wallSize, 0, 1);
		earthXWall(loc, wallSize, -wallSize, 0, 1);
		earthXWall(loc, wallSize, -wallSize, 0, 1);
		resetCoord(loc);
	}
	
	public static void earthXWall(Location loc, double wallSize, double xOffSet, double zOffSet, double yOffSet) {
		double x = loc.getX();
		double z = loc.getZ();
		double y = loc.getY();
		
		loc.setX(x + xOffSet);
		loc.setZ(z + zOffSet);
		loc.setY(y + yOffSet);
		makeXBlocks(loc, wallSize, Material.DIRT);
	}
	
	public static void earthPosXDomino(Location loc, double wallSize, double x, double z, double y, double xGap, double zGap, Player p) {
		setInitialCoord(p);
		earthZWall(loc, wallSize, x, z, y);
		resetCoord(loc);
		
		earthZWall(loc, wallSize, x + xGap, z + zGap, y);
		earthZWall(loc, wallSize, 0, z-1, 1);
		resetCoord(loc);
		
		earthZWall(loc, wallSize, x + xGap * 2, z + zGap * 2, y);
		earthZWall(loc, wallSize, 0, -wallSize, 1);
		earthZWall(loc, wallSize, 0, -wallSize, 1);
		resetCoord(loc);
		
		earthZWall(loc, wallSize, x + xGap * 3, z + zGap * 3, y);
		earthZWall(loc, wallSize, 0, -wallSize, 1);
		earthZWall(loc, wallSize, 0, -wallSize, 1);
		earthZWall(loc, wallSize, 0, -wallSize, 1);
		resetCoord(loc);
	}
	
	public static void earthZWall(Location loc, double wallSize, double xOffSet, double zOffSet, double yOffSet) {
		double x = loc.getX();
		double z = loc.getZ();
		double y = loc.getY();
		
		loc.setX(x + xOffSet);
		loc.setZ(z + zOffSet);
		loc.setY(y + yOffSet);
		makeZBlocks(loc, wallSize, Material.DIRT);
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
			loc.setZ(loc.getZ() + 1);
			
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

	public static boolean pInState(Player p)
	{
		return playersInAvatarState.contains(p);
	}

}
