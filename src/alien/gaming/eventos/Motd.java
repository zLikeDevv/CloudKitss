package alien.gaming.eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import alien.gaming.principal.Main;

public class Motd implements Listener{
	
	@EventHandler
	public void motd(ServerListPingEvent e){
		
		e.setMotd(Main.getPlugin().getConfig().getString("motd").replace("&", "§"));
	}

}
