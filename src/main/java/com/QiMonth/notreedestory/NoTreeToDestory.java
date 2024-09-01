package com.qimonth.notreedestory;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(NoTreeToDestory.MODID)
public class NoTreeToDestory {
    public static final String MODID = "notreedestory";

    public NoTreeToDestory() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerDig(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Block block = event.getLevel().getBlockState(event.getPos()).getBlock();
        ItemStack heldItem = player.getMainHandItem();

        // 判断方块方块是否为木头或木板
        if ((block.defaultBlockState().is(BlockTags.LOGS)
                || block.defaultBlockState().is(BlockTags.PLANKS))
                // 如果玩家没有使用斧头，则取消破坏方块(并且有添加创造模式判断)
                && (!player.getAbilities().instabuild) && !(heldItem.getItem() instanceof AxeItem)) {
            event.setCanceled(true);
        }
    }
}