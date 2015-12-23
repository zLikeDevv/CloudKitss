package alien.gaming.comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class TogglePvP implements CommandExecutor, Listener {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Tu nao es um player!");
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("togglepvp")) && ((p.hasPermission("alien.pvp")) || (p.isOp()))) {
			if (p.getWorld().getPVP()) {
				p.getWorld().setPVP(false);
				for (Player s : Bukkit.getOnlinePlayers()) {
					World wl = s.getWorld();
					Bukkit.getServer().broadcastMessage(
							ChatColor.GRAY + ChatColor.ITALIC.toString() + "PvP Desativado no mundo: " + wl.getName());
					return true;

				}
				return true;
			}
			p.getWorld().setPVP(true);
			for (Player s : Bukkit.getOnlinePlayers()) {
				World wl = s.getWorld();
				Bukkit.getServer().broadcastMessage(
						ChatColor.GRAY + ChatColor.ITALIC.toString() + "PvP Ativado no mundo: " + wl.getName());
				return true;
			}
			return true;
		}

		return true;
	}
}