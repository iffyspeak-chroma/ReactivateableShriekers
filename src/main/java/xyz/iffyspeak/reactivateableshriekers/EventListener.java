package xyz.iffyspeak.reactivateableshriekers;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.SculkShrieker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;


public class EventListener implements Listener {

    @EventHandler
    public void onInteractBlock(PlayerInteractEvent _e)
    {
        org.bukkit.block.SculkShrieker shriekerBlock;
        org.bukkit.block.data.type.SculkShrieker shriekerData;

        if (!_e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;

        if (!(_e.getClickedBlock().getState() instanceof SculkShrieker)) return;

        shriekerBlock = (SculkShrieker) _e.getClickedBlock().getState();
        shriekerData = (org.bukkit.block.data.type.SculkShrieker) shriekerBlock.getBlockData();

        if (_e.getItem() != null && _e.getItem().getType().equals(Material.BLAZE_POWDER))
        {
            if (!shriekerData.isCanSummon())
            {
                _e.getItem().setAmount(_e.getItem().getAmount() - 1);
                shriekerData.setCanSummon(true);
                //shriekerBlock.setBlockData(shriekerData);

                _e.getClickedBlock().setBlockData(shriekerData);

                for (Player p : Bukkit.getOnlinePlayers())
                {
                    p.sendMessage(MiniMessage.miniMessage().deserialize("<color:#ff6f00><b>ATTENTION PLAYERS:</b>\nThe player <yellow>" + _e.getPlayer().getName() + "</yellow> activated a sculk shrieker.\nBe weary if you see them nearby.</color>"));
                }

                _e.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("\n<color:#00246b>Sculk Shrieker activated</color>\n" + Toolkit.FunnyMessage.getRandomActivateMessage()));
            } else
            {
                _e.getPlayer().sendMessage(MiniMessage.miniMessage().deserialize("<red>You mad man. It's already activated. Quit playing with your life.</red>"));
            }
        }
    }

}
