package alien.gaming.gadgets;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;

public class Efeito implements CommandExecutor {
	static ArrayList<String> eff = new ArrayList<>();
	static ArrayList<String> st = new ArrayList<>();
	static ArrayList<String> pot = new ArrayList<>();
	static ArrayList<String> reds = new ArrayList<>();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§a§l Voce nao é um player!");
			return true;
		}
		Player p = (Player) sender;
		if (!p.hasPermission("alien.eff")) {
			p.sendMessage("§a§l >> Tu nao tens permissao para isto!");
			return true;
		}
		if (label.equalsIgnoreCase("efeito")) {
			if (eff.contains(p.getName())) {
				p.sendMessage("§c§l >> Ja tens um efeito, digite /deleff, para remover o efeito!");
				return true;
			}
			if (!ArraysAPI.modoSpawn.contains(p)) {
				p.sendMessage("§c§l >> Voce nao pode pegar um efeito estando em modo pvp!");
				return true;
			}
			if (ArraysAPI.habilidade.contains(p)) {
				p.sendMessage("§a§l >> Voce nao pode pegar um efeito no modo pvp");
				return true;
			}
			if (args.length != 1) {
				p.sendMessage("§c§l >> Erro de digito, tente /efeito ( stone / pot / redstone / agua )");
				return true;
			} else {
				if (args[0].equalsIgnoreCase("stone")) {
					eff.add(p.getName());
					st.add(p.getName());
					Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
						public void run() {
							if (eff.contains(p.getName()) && st.contains(p.getName())) {
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.STEP_SOUND, Material.STONE,
										10000000);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.STEP_SOUND, Material.STONE, 200);
								return;
							}
						}
					}, 0L, 10L);
					return true;
				}

				if (args[0].equalsIgnoreCase("pot")) {
					eff.add(p.getName());
					pot.add(p.getName());
					Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
						public void run() {
							if (eff.contains(p.getName()) && pot.contains(p.getName())) {
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 0.5D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								p.getWorld().playEffect(p.getPlayer().getLocation().add(0.0D, 1.1D, 0.0D),
										Effect.POTION_BREAK, 200, 200);
								return;
							}
						}
					}, 0L, 10L);
				}
			}
		}
		if (label.equalsIgnoreCase("deleff")) {
			if (!eff.contains(p.getName())) {
				p.sendMessage("§c§l >> Voce nao tem um efeito para poder removelo!");
				return true;
			}
			removeEff(p);
			p.sendMessage("§a§l >> Efeito " + "removido!");
		}
		return false;
	}

	static void removeEff(Player p) {
		eff.remove(p.getName());
		pot.remove(p.getName());
		st.remove(p.getName());
		reds.remove(p.getName());

		eff.clear();
		pot.clear();
		st.clear();
		reds.clear();
	}
}
