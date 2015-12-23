package alien.gaming.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import alien.gaming.utils.ArraysAPI;
import alien.gaming.utils.Metodos;
import alien.gaming.utils.ScoreB;
import me.confuser.barapi.BarAPI;

public class Thor implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§7Tu nao es um player!");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("alien.thor")) {
			p.sendMessage("§a§l >>  Tu nao tens permissão para este kit!");
			return true;
		}
		if (comando.equalsIgnoreCase("thor")) {
			if (ArraysAPI.habilidade.contains(p)) {
				p.sendMessage("§a§l >> Ja tens uma habilidade");
				return true;
			}

			ItemStack sopa = Metodos.criarItem(ChatColor.GRAY, "Sopa", Material.MUSHROOM_SOUP);
			ItemStack phantom = Metodos.criarItem(ChatColor.GRAY, "Machado de Thor", Material.STONE_AXE);

			p.getInventory().clear();
			for (int i = 0; i < p.getInventory().getSize(); i++) {
				while (p.getInventory().getItem(i) == null) {
					p.getInventory().addItem(sopa);
				}
			}
			BarAPI.setMessage(p, "§a>> Pegas-te o kit Thor");
			p.sendMessage("§a§l >> Voce perdeu a proteçao spawn ao pegar um kit!");
			p.getInventory().setItem(0, phantom);
			String Kit = "Thor";
			ScoreB.setScoreBoard(p, Kit);
			ArraysAPI.removeModos(p);
			ArraysAPI.habilidade.add(p);
			ArraysAPI.thor.add(p);

		}
		return false;
	}

}
