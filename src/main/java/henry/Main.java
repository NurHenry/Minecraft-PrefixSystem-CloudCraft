package henry;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

public class Main extends JavaPlugin implements Listener {
    Scoreboard sb;

    public void onEnable() {
        System.out.println("Prefix System Funktioniert!");
        getServer().getPluginManager().registerEvents(this, (Plugin)this);
        this.sb = Bukkit.getScoreboardManager().getNewScoreboard();

        this.sb.registerNewTeam("0001Owner");
        this.sb.registerNewTeam("0002Admin");
        this.sb.registerNewTeam("0003SrDev");
        this.sb.registerNewTeam("0004Dev");
        this.sb.registerNewTeam("0005SrMod");
        this.sb.registerNewTeam("0006SrBuilder");
        this.sb.registerNewTeam("0007Mod");
        this.sb.registerNewTeam("0008JrMod");
        this.sb.registerNewTeam("0009Builder");
        this.sb.registerNewTeam("0010Supporter");
        this.sb.registerNewTeam("0011Marketing");
        this.sb.registerNewTeam("0012TestBuilder");
        this.sb.registerNewTeam("0013Testsupp");
        this.sb.registerNewTeam("0014YTplus");
        this.sb.registerNewTeam("0015YT");
        this.sb.registerNewTeam("0016Lord");
        this.sb.registerNewTeam("0017Platin");
        this.sb.registerNewTeam("0018Emerald");
        this.sb.registerNewTeam("0019Premiumplus");
        this.sb.registerNewTeam("0020Premium");
        this.sb.registerNewTeam("0021Spieler");

        //Prefixes comming soon

        this.sb.getTeam("0001Owner").setPrefix("");
        this.sb.getTeam("0002Admin").setPrefix("");
        this.sb.getTeam("0003SrDev").setPrefix("");
        this.sb.getTeam("0004Dev").setPrefix("");
        this.sb.getTeam("0005SrMod").setPrefix("");
        this.sb.getTeam("0006SrBuilder").setPrefix("");
        this.sb.getTeam("0007Mod").setPrefix("");
        this.sb.getTeam("0008JrMod").setPrefix("");
        this.sb.getTeam("0009Builder").setPrefix("");
        this.sb.getTeam("0010Supporter").setPrefix("");
        this.sb.getTeam("0011Marketing").setPrefix("");
        this.sb.getTeam("0012Testbuilder").setPrefix("");
        this.sb.getTeam("0013Testsupp").setPrefix("");
        this.sb.getTeam("0014YTplus").setPrefix("");
        this.sb.getTeam("0015YT").setPrefix("");
        this.sb.getTeam("0016Lord").setPrefix("");
        this.sb.getTeam("0017Platin").setPrefix("");
        this.sb.getTeam("0018Emerald").setPrefix("");
        this.sb.getTeam("0019Premiumplus").setPrefix("");
        this.sb.getTeam("0020Premium").setPrefix("");
        this.sb.getTeam("0021Spieler").setPrefix("");
    }

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        (new BukkitRunnable() {
            public void run() {
                Main.this.setPrefix(e.getPlayer());
            }
        }).runTaskLaterAsynchronously((Plugin)this, 1L);
    }

    public void setPrefix(Player p) {
        String team = "";
        if (p.hasPermission("system.group.owner")) {
            team = "0001Owner";
        } else if (p.hasPermission("system.group.admin")) {
            team = "0002Admin";
        } else if (p.hasPermission("system.group.srdev")) {
            team = "0003SrDev";
        } else if (p.hasPermission("system.group.dev")) {
            team = "0004Dev";
        } else if (p.hasPermission("system.group.srmod")) {
            team = "0005SrMod";
        } else if (p.hasPermission("system.group.srbuilder")) {
            team = "0006SrBuilder";
        } else if (p.hasPermission("system.group.mod")) {
            team = "0007Mod";
        } else if (p.hasPermission("system.group.jrmod")) {
            team = "0008JrMod";
        } else if (p.hasPermission("system.group.builder")) {
            team = "0009Buidler";
        } else if (p.hasPermission("system.group.supporter")) {
            team = "0010Supporter";
        } else if (p.hasPermission("system.group.marketing")) {
            team = "0011Marketing";
        } else if (p.hasPermission("system.group.tbuilder")) {
            team = "0012Testbuilder";
        } else if (p.hasPermission("system.group.testsupp")) {
            team = "0013Testsupp";
        } else if (p.hasPermission("system.group.ytplus")) {
            team = "0014YTplus";
        } else if (p.hasPermission("system.group.yt")) {
            team = "0015YT";
        } else if (p.hasPermission("system.group.lord")) {
            team = "0016Lord";
        } else if (p.hasPermission("system.group.platin")) {
            team = "0017Platin";
        } else if (p.hasPermission("system.group.emerald")) {
            team = "0018Emerald";
        } else if (p.hasPermission("system.group.premiumplus")) {
            team = "0019Premiumplus";
        } else if (p.hasPermission("system.group.premium")) {
            team = "0020Premium";
        } else {
            team = "0021Spieler";
        }
        this.sb.getTeam(team).addPlayer((OfflinePlayer)p);
        p.setDisplayName(String.valueOf(this.sb.getTeam(team).getPrefix()) + p.getName());
        for (Player all : Bukkit.getOnlinePlayers())
            all.setScoreboard(this.sb);
    }
}
