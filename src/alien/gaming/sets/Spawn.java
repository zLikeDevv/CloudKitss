package alien.gaming.sets;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;

public class Spawn implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String comando, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§7Tu nao es um player!");
			return true;
		}
		Player p = (Player) sender;
		if (comando.equalsIgnoreCase("setspawn")) {
			if (!p.hasPermission("alien.setspawn")) {
				p.sendMessage("§a§l >> Nao tens permissão para isto!");
				return true;
			}
			int x = p.getLocation().getBlockX();
			int y = p.getLocation().getBlockY();
			int z = p.getLocation().getBlockZ();
			p.getWorld().setSpawnLocation(x, y, z);
			p.sendMessage("§a§l >> Novo ponto de spawn setado nas seguintes coordenadas: §7 X: " + x + ", Y: " + y
					+ " Z: " + z);
		}
		if (comando.equalsIgnoreCase("spawn")) {

			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage("§a§l >> Voce será teleportado ao spawn em 5 segundos...");
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
					p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
					ArraysAPI.habilidade.add(p);
				}
			}, 1L * 20L);
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage("§a§l >> Voce será teleportado ao spawn em 4 segundos...");
				}
			}, 2L * 20L);
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage("§a§l >> Voce será teleportado ao spawn em 3 segundos...");
				
				}
			}, 3L * 20L);
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage("§a§l >> Voce será teleportado ao spawn em 2 segundos...");
				
				}
			}, 4L * 20L);
			Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.teleport(p.getWorld().getSpawnLocation());
					p.sendMessage("§a§l >> Voce será teleportado ao spawn em 1 segundos...");
					ArraysAPI.removeTudo(p);
					ArraysAPI.adicionaModoSpawn(p);
					p.removePotionEffect(PotionEffectType.SLOW);
					p.removePotionEffect(PotionEffectType.JUMP);
				}
			}, 5L * 20L);
		}
		return false;
	}
}
