package alien.gaming.comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

import alien.gaming.utils.ArraysAPI;
import alien.gaming.utils.Metodos;

public class Admin implements CommandExecutor, Listener {
	public static ArrayList<Player> admin = new ArrayList<Player>();

	@EventHandler
	public void admin(PlayerInteractEntityEvent e) {
		if (!(e.getRightClicked() instanceof Player)) {
			return;
		}
		if ((e.getRightClicked() instanceof Player)) {
			Player r = (Player) e.getRightClicked();
			Player p = e.getPlayer();
			if (admin.contains(p)) {
				Inventory inv = r.getInventory();
				if (p.getItemInHand().getType() == Material.AIR)
					p.openInventory(inv);
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Comando para players!");
				return true;
			}
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Voce nao pode usa admin!");
				return true;
			}
			if (cmd.getName().equalsIgnoreCase("admin")) {
				Player p = (Player) sender;
				if (p.hasPermission("alien.admin")) {
					if (admin.contains(p)) {
						admin.remove(p);
						p.getInventory().clear();
						ArraysAPI.removeTudo(p);
						Metodos.seletores(p);
						p.sendMessage("§c[!] §7Voce saiu do modo §6administrador");
						p.setGameMode(GameMode.SURVIVAL);
						for (Player on : Bukkit.getServer().getOnlinePlayers()) {
							on.showPlayer(p);
						}

					} else {
						admin.add(p);
						p.setGameMode(GameMode.CREATIVE);
						p.getInventory().clear();
						Metodos.kitAdmin(p);
						p.sendMessage("§c[!] §7Voce entrou no modo §6administrador");
						for (Player on : Bukkit.getServer().getOnlinePlayers())
							on.hidePlayer(p);
					}
				} else {
					p.sendMessage("§c§lERRO: §cVoce nao pode usar esse comando!");
					return true;
				}
			}
		}
		return false;

	}
}