package alien.gaming.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chat implements Listener, CommandExecutor {
	public static boolean chat = true;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args) {
		if (sender instanceof Player || (!(sender instanceof Player))) {
			Player p = (Player) sender;
			if (!p.hasPermission("alien.chat")) {
				p.sendMessage("§a§l >> Tu nao tens permissão!");
				return true;
			}
			if (comando.equalsIgnoreCase("chat")) {
				if (args.length != 1) {
					p.sendMessage("§c§l Erro de digito! Tente /chat (on / off / clear)");
				} else {
					if (args[0].equalsIgnoreCase("on")) {
						chat = true;

						for (Player s : Bukkit.getOnlinePlayers()) {
							s.sendMessage("§a§l >> O Chat foi aberto novamente!");
						}
					}
					if (args[0].equalsIgnoreCase("off")) {
						chat = false;
						for (Player s : Bukkit.getOnlinePlayers()) {
							s.sendMessage("§a§l >> O Chat foi feichado !");
						}
					}
					if (args[0].equalsIgnoreCase("clear")) {
						for (int i = 0; i < 600; i++) {
							for (Player s : Bukkit.getOnlinePlayers()) {
								s.sendMessage("    ");
							}
						}
						for (Player s : Bukkit.getOnlinePlayers()) {
							s.sendMessage("§a§l >> Chat limpo por: " + p.getDisplayName());
						}
					}
				}
			}
		}
		return false;
	}

	@EventHandler
	public void tentarFalar(AsyncPlayerChatEvent e) {
		if (chat == true) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
}
