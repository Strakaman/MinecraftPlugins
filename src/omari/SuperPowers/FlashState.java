package omari.SuperPowers;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FlashState {

	public static void flashPoint(Player p, boolean turnOn)
	{
		if (turnOn)
		{
			p.setWalkSpeed(SuperPowers.defWalkSpeed*5);
			p.sendMessage(p.getName() + " is the fastest player alive!");
		}
		else
		{
			p.setWalkSpeed(SuperPowers.defWalkSpeed);
		}
	}
}
