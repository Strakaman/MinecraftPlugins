package omari.SuperPowers;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Debug {

	public static void debugStuff(CommandSender s)
	{
		Player p = (Player) s;
		s.sendMessage("Exhaustion: " + p.getExhaustion());
		s.sendMessage("Saturation: " + p.getSaturation());
		s.sendMessage("FoodLevel: " + p.getFoodLevel());
		s.sendMessage("Fly Speed: " + p.getFlySpeed());
		
	}
}