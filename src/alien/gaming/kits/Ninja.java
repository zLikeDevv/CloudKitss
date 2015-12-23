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

public class Ninja implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§7Tu nao es um jogador!");
			return true;
		}
		Player p = (Player) sender;

		if (comando.equalsIgnoreCase("ninja")) {
			if(!p.hasPermission("alien.ninja")){
				p.sendMessage("§a§l >> Tu nao tens permissão!");
				return true;
			}
			if (ArraysAPI.habilidade.contains(p)) {
				p.sendMessage("§a§l >> Ja tens uma habilidade");
				return true;
			}
			ItemStack espada = Metodos.criarItem(ChatColor.GREEN, " >> Espada de Pedra << ", Material.WOOD_SWORD,
					Enchantment.DAMAGE_ALL, 1, true);
			ItemStack sopa = Metodos.criarItem(ChatColor.GRAY, "Sopa", Material.MUSHROOM_SOUP);
			p.getInventory().clear();
			for (int i = 0; i < p.getInventory().getSize(); i++) {
				while (p.getInventory().getItem(i) == null) {
					p.getInventory().addItem(sopa);
				}
			}
			BarAPI.setMessage(p, "§a>> Pegas-te o kit Ninja");
			p.sendMessage("§a§l >> Voce perdeu a proteçao spawn ao pegar um kit!");
			p.getInventory().setItem(0, espada);
			String Kit = "Ninja";
			ScoreB.setScoreBoard(p, Kit);
			ArraysAPI.habilidade.add(p);
			ArraysAPI.modoSpawn.remove(p);
			ArraysAPI.ninja.add(p);

		}
		return false;
	}

}
