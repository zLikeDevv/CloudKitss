package alien.gaming.principal;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import alien.gaming.comandos.Adm;
import alien.gaming.comandos.Admin;
import alien.gaming.comandos.Ban;
import alien.gaming.comandos.Chat;
import alien.gaming.comandos.Click;
import alien.gaming.comandos.Tags;
import alien.gaming.comandos.TogglePvP;
import alien.gaming.eventos.Death;
import alien.gaming.eventos.Drop;
import alien.gaming.eventos.Entrada;
import alien.gaming.eventos.Motd;
import alien.gaming.eventos.RegenerarBlock;
import alien.gaming.eventos.Respawn;
import alien.gaming.eventos.Saida;
import alien.gaming.eventos.Sopa;
import alien.gaming.gadgets.Efeito;
import alien.gaming.jumps.BlocoDeFerro;
import alien.gaming.kits.Hulk;
import alien.gaming.kits.HulkHab;
import alien.gaming.kits.Kangaroo;
import alien.gaming.kits.KangarooHab;
import alien.gaming.kits.Mago;
import alien.gaming.kits.MagoHab;
import alien.gaming.kits.Ninja;
import alien.gaming.kits.NinjaHab;
import alien.gaming.kits.Phantom;
import alien.gaming.kits.PhantomHab;
import alien.gaming.kits.PvP;
import alien.gaming.kits.Sonic;
import alien.gaming.kits.SonicHab;
import alien.gaming.kits.Thor;
import alien.gaming.kits.ThorHab;
import alien.gaming.menuaceitar.Menus;
import alien.gaming.seletores.KitSelector;
import alien.gaming.seletores.Loja;
import alien.gaming.sets.Spawn;
import alien.gaming.utils.Config;
import alien.gaming.utils.ScoreB;
import alien.gaming.utils.Util;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

public class Main extends JavaPlugin {
	public static Plugin plugin;
	public static net.milkbowl.vault.permission.Permission perm = null;
	public static Permission perms;
	public static Economy econ = null;

	@Override
	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage("§a>> O Plugin foi habilitado! <<");

		registrandoEventos();
		setupEconomy();
		setupPermissions();
		super.onEnable();
		plugin = this;
	}

	@Override
	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage("§a>> O Plugin foi desabilitado! <<");

		super.onDisable();
	}

	public void registrandoEventos() {
		PluginManager manager = getServer().getPluginManager();
		manager.registerEvents(new Entrada(), this);
		manager.registerEvents(new Saida(), this);
		manager.registerEvents(new Sopa(), this);
		manager.registerEvents(new Util(), this);
		manager.registerEvents(new Death(), this);
		manager.registerEvents(new Respawn(), this);
		manager.registerEvents(new PhantomHab(), this);
		manager.registerEvents(new KitSelector(), this);
		manager.registerEvents(new Menus(), this);
		manager.registerEvents(new ScoreB(), this);
		manager.registerEvents(new Config(), this);
		manager.registerEvents(new SonicHab(), this);
		manager.registerEvents(new KangarooHab(), this);
		manager.registerEvents(new MagoHab(), this);
		manager.registerEvents(new Click(), this);
		manager.registerEvents(new Loja(), this);
		manager.registerEvents(new Chat(), this);
		manager.registerEvents(new Admin(), this);
		manager.registerEvents(new Adm(), this);
		manager.registerEvents(new RegenerarBlock(), this);
		manager.registerEvents(new HulkHab(), this);
		manager.registerEvents(new Motd(), this);
		manager.registerEvents(new NinjaHab(), this);
		manager.registerEvents(new BlocoDeFerro(), this);
		manager.registerEvents(new ThorHab(), this);
		manager.registerEvents(new Drop(), this);

		getCommand("pvp").setExecutor(new PvP());
		getCommand("click").setExecutor(new Click());
		getCommand("sonic").setExecutor(new Sonic());
		getCommand("chat").setExecutor(new Chat());
		getCommand("phantom").setExecutor(new Phantom());
		getCommand("Kangaroo").setExecutor(new Kangaroo());
		getCommand("mago").setExecutor(new Mago());
		getCommand("admin").setExecutor(new Admin());
		getCommand("hulk").setExecutor(new Hulk());
		getCommand("setspawn").setExecutor(new Spawn());
		getCommand("spawn").setExecutor(new Spawn());
		getCommand("togglepvp").setExecutor(new TogglePvP());
		getCommand("tag").setExecutor(new Tags());
		getCommand("ninja").setExecutor(new Ninja());
		getCommand("banir").setExecutor(new Ban());
		getCommand("thor").setExecutor(new Thor());
		getCommand("efeito").setExecutor(new Efeito());
		getCommand("deleff").setExecutor(new Efeito());
	}

	public static Plugin getPlugin() {
		return plugin;
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	private boolean setupPermissions() {
		RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager()
				.getRegistration(net.milkbowl.vault.permission.Permission.class);
		if (permissionProvider != null) {
			perms = permissionProvider.getProvider();
		}
		return (perms != null);

	}
}
