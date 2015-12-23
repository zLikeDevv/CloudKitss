package alien.gaming.eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import alien.gaming.utils.ArraysAPI;
import alien.gaming.utils.Metodos;
import me.confuser.barapi.BarAPI;

public class Respawn implements Listener{
	
	@EventHandler
	public void aoRespawnar(PlayerRespawnEvent e){
		Player p = e.getPlayer();
		
		p.getInventory().clear();
		ArraysAPI.removeTudo(p);
		ArraysAPI.adicionaModoSpawn(p);
		Metodos.seletores(p);
		BarAPI.removeBar(p);
	}

}
