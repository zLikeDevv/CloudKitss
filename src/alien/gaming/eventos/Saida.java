package alien.gaming.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import alien.gaming.utils.ArraysAPI;
import ca.wacos.nametagedit.NametagAPI;

public class Saida implements Listener {

	@EventHandler // Anotaçao
	public void aoEntrar(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§7[§4-§7]" + p.getDisplayName());
		ArraysAPI.removeTudo(p);
		NametagAPI.resetNametag(p.getName());
	}

}
