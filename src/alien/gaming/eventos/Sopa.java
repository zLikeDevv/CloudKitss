package alien.gaming.eventos;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Sopa
  implements Listener
{
  @EventHandler
  public void onSoup(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if (p.getItemInHand().getType() != Material.MUSHROOM_SOUP) {
      return;
    }
    Damageable d = p;
    if (d.getHealth() == d.getMaxHealth()) {
      return;
    }
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      if (d.getHealth() > d.getMaxHealth() - 7.0D)
        d.setHealth(d.getMaxHealth());
      else {
        d.setHealth(d.getHealth() + 7.0D);
      }
      p.getItemInHand().setAmount(1);
      p.getItemInHand().setType(Material.BOWL);
      p.playSound(p.getLocation(), Sound.BURP, 1.0F, 1.0F);
    }
  }
}