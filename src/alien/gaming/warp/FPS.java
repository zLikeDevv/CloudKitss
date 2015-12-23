package alien.gaming.warp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alien.gaming.principal.Main;

public class FPS implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("setFPS")) && ((sender instanceof Player))) {
			if (!sender.hasPermission("Alien.setFPS")) {
				Player p1 = (Player) sender;
				p1.sendMessage("§a§l >> Tu nao tens permissao! ");
			}
			if (sender.hasPermission("Outside.setwarp")) {
				Player p1 = (Player) sender;
				Main.plugin.getConfig().set("Fps.x", Double.valueOf(p1.getLocation().getX()));
				Main.plugin.getConfig().set("Fps.y", Double.valueOf(p1.getLocation().getY()));
				Main.plugin.getConfig().set("Fps.z", Double.valueOf(p1.getLocation().getZ()));
				Main.plugin.getConfig().set("Fps.pitch", Float.valueOf(p1.getLocation().getPitch()));
				Main.plugin.getConfig().set("Fps.yaw", Float.valueOf(p1.getLocation().getYaw()));
				Main.plugin.getConfig().set("Fps.world", p1.getLocation().getWorld().getName());
				Main.plugin.saveConfig();
				p1.sendMessage("§a§l >> Warp fps setada!");
				p1.getWorld().setSpawnLocation(p1.getLocation().getBlockX(), p1.getLocation().getBlockY(),
						p1.getLocation().getBlockZ());
			}
			return false;
		}
		return false;
	}

}
