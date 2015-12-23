package alien.gaming.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import alien.gaming.utils.ArraysAPI;
import alien.gaming.utils.Metodos;
import alien.gaming.utils.ScoreB;

public class Entrada implements Listener {

	@EventHandler // Anotaçao Para Evento
	public void aoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String Kit = "Nenhum";
		ScoreB.setScoreBoard(p, Kit);
		e.setJoinMessage("§7[§a+§7]" + p.getName());
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		ArraysAPI.removeTudo(p);
		ArraysAPI.adicionaModoSpawn(p);
		Metodos.seletores(p);
		p.teleport(p.getWorld().getSpawnLocation());
	}
}
