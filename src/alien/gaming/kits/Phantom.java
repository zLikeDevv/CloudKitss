package alien.gaming.kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import alien.gaming.utils.ArraysAPI;
import alien.gaming.utils.Metodos;
import alien.gaming.utils.ScoreB;
import me.confuser.barapi.BarAPI;

public class Phantom implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§7Tu nao es um player!");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("alien.phantom")) {
			p.sendMessage("§a§l >>  Tu nao tens permissão para este kit!");
			return true;
		}
		if (comando.equalsIgnoreCase("phantom")) {
			if (ArraysAPI.habilidade.contains(p)) {
				p.sendMessage("§a§l >> Ja tens uma habilidade");
				return true;
			}

			ItemStack espada = Metodos.criarItem(ChatColor.GREEN, " >> Espada de Madeira << ", Material.WOOD_SWORD,
					Enchantment.DAMAGE_ALL, 1, true);
			ItemStack sopa = Metodos.criarItem(ChatColor.GRAY, "Sopa", Material.MUSHROOM_SOUP);
			ItemStack phantom = Metodos.criarItem(ChatColor.GRAY, "Pena", Material.FEATHER);

			p.getInventory().clear();
			for (int i = 0; i < p.getInventory().getSize(); i++) {
				while (p.getInventory().getItem(i) == null) {
					p.getInventory().addItem(sopa);
				}
			}
			BarAPI.setMessage(p, "§a>> Pegas-te o kit Phantom");
			p.sendMessage("§a§l >> Voce perdeu a proteçao spawn ao pegar um kit!");
			p.getInventory().setItem(0, espada);
			p.getInventory().setItem(1, phantom);
			String Kit = "Phantom";
			ScoreB.setScoreBoard(p, Kit);
			ArraysAPI.removeModos(p);
			ArraysAPI.habilidade.add(p);
			ArraysAPI.phantom.add(p);

		}
		return false;
	}

}
