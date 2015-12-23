package alien.gaming.kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import alien.gaming.utils.ArraysAPI;

public class HulkHab
  implements Listener
{
  public static HashMap<String, Long> cooldown = new HashMap<String, Long>();

  @SuppressWarnings("deprecation")
@EventHandler
  public void pegar(PlayerInteractEntityEvent e) {
    Player p = e.getPlayer();
    if ((e.getRightClicked() instanceof Player))
    {
      Player r = (Player)e.getRightClicked();
      if (ArraysAPI.hulk.contains(p))
        if ((!cooldown.containsKey(p.getName())) || (((Long)cooldown.get(p.getName())).longValue() <= System.currentTimeMillis()))
        {
          if (p.getItemInHand().getType() == Material.AIR)
          {
            e.setCancelled(true);
            p.updateInventory();
            p.setPassenger(r);
            cooldown.put(p.getName(), Long.valueOf(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L)));
            p.sendMessage("§a§l >> Voce pegou o player: " + ChatColor.GOLD + r.getName());
            r.sendMessage("§c§l >> Voce foi pego pelo Hulk, use shift para se largar!");
          }
        }
        else
          p.sendMessage("§a§l >>Faltam §3" + TimeUnit.MILLISECONDS.toSeconds(((Long)cooldown.get(p.getName())).longValue() - 
        		  System.currentTimeMillis()) + " segundos para sair do cooldown");
    }
  }
}