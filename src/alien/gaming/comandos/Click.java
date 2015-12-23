package alien.gaming.comandos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import alien.gaming.principal.Main;
import alien.gaming.utils.ArraysAPI;
import alien.gaming.utils.Metodos;

public class Click implements Listener, CommandExecutor {
	public static ArrayList<String> Macro = new ArrayList<String>();
	public static Map<Player, Integer> macro = new HashMap<Player, Integer>();

	@SuppressWarnings("unused")
	@EventHandler
	public void attk2(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (Macro.contains(p.getName())) {
			if (!(e.getPlayer() instanceof Player)) {
				return;
			}
			if ((!e.getAction().name().contains("LEFT")) && (macro.containsKey(p.getName()))) {
				return;
			}
			if (macro.containsKey(p)) {
				macro.put(p, Integer.valueOf(Integer.valueOf(((Integer) macro.get(p)).intValue()).intValue() + 1));
			} else {
				macro.put(p, Integer.valueOf(1));
			}
			p.setLevel(Integer.valueOf(Integer.valueOf(((Integer) macro.get(p)).intValue()).intValue() + 1).intValue());
			int mortes = Main.getPlugin().getConfig().getInt("status." + p.getName().toLowerCase() + ".clicks");
			Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".clicks", Integer.valueOf(
					Integer.valueOf(Integer.valueOf(((Integer) macro.get(p)).intValue()).intValue() + 1).intValue()));
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("click")) {
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				@SuppressWarnings("unused")
				public void run() {
					int streak1 = Main.getPlugin().getConfig()
							.getInt("status." + p.getName().toLowerCase() + ".clicks");
					Main.getPlugin().getConfig().set("status." + p.getName().toLowerCase() + ".clicks",
							Integer.valueOf(0));
					p.sendMessage(ArraysAPI.nomeDoServer + "§aIniciando em 1... ");
					ArraysAPI.removeTudo(p);
				}
			}, 10L);

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage(ArraysAPI.nomeDoServer +  "§aIniciando em 2... ");
				}
			}, 20L);

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage( ArraysAPI.nomeDoServer + "§aIniciando em 3... ");
				}
			}, 30L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage("§aIniciado Comece.");
					Click.macro.put(p, Integer.valueOf(0));
					Click.macro.put(p, Integer.valueOf(0));
					Click.macro.put(p, Integer.valueOf(0));
					Click.macro.put(p, Integer.valueOf(0));

					p.getInventory().clear();
					ArraysAPI.adicionaModoSpawn(p);
					Click.Macro.add(p.getName());
				}
			}, 40L);

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
				public void run() {
					p.sendMessage("                                                          ");
					p.sendMessage("                                                          ");
					p.sendMessage( ArraysAPI.nomeDoServer +  "§a§lVocê fez em 10 segundos  " + p.getLevel() + " Clicks");
					p.sendMessage( ArraysAPI.nomeDoServer + "§a§lVocê fez em Media " + p.getLevel() / 10 + " Cliks por segundo.");

					p.getInventory().clear();

					p.setLevel(0);
					p.setExhaustion(20.0F);
					p.setMaxHealth(20.0D);
					p.setFoodLevel(20);
					p.setGameMode(GameMode.SURVIVAL);

					

					Click.Macro.remove(p.getName());
					Click.macro.put(p, Integer.valueOf(0));
					Click.macro.put(p, Integer.valueOf(0));
					Click.macro.put(p, Integer.valueOf(0));
					Click.macro.put(p, Integer.valueOf(0));
					
					Metodos.seletores(p);
				}
			}, 200L);
		}

		return false;
	}
}