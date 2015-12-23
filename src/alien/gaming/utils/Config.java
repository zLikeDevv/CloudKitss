package alien.gaming.utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import alien.gaming.principal.Main;

public class Config implements Listener {
	@EventHandler
	void aoEntrar(PlayerJoinEvent evento) {
		Player jogador = evento.getPlayer();
		if (Main.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null) {
			Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", Integer.valueOf(0));
			Main.plugin.saveConfig();
		}
		if (Main.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".mortes") == null) {
			Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", Integer.valueOf(0));
			Main.plugin.saveConfig();
		}
	}

	@EventHandler
	void AoMatar(PlayerDeathEvent evento) {
		if ((evento.getEntity().getKiller() instanceof Player)) {
			Player jogador = evento.getEntity().getKiller();

			int kills = Main.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".kills");
			Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills",
					Integer.valueOf(kills + 1));
			Main.plugin.saveConfig();
		}
	}

	@EventHandler
	void AoMorrer(PlayerDeathEvent evento) {
		if ((evento.getEntity() instanceof Player)) {
			Player jogador = evento.getEntity();

			int mortes = Main.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".mortes");
			Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes",
					Integer.valueOf(mortes + 1));
			Main.plugin.saveConfig();
		}
	}

}
