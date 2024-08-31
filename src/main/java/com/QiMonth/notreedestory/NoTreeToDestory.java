package com.QiMonth.notreedestory;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(NoTreeToDestory.MODID)
public class NoTreeToDestory {
    public static final String MODID = "notreedestory";

    @SubscribeEvent
    public void onPlayerDig(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getEntity();
        Block block = event.getLevel().getBlockState(event.getPos()).getBlock();
        ItemStack heldItem = player.getMainHandItem();

        if ((block.defaultBlockState().is(BlockTags.LOGS) || block.defaultBlockState().is(BlockTags.PLANKS))
                && !(heldItem.getItem() instanceof AxeItem)) {
            event.setCanceled(true);
        }
    }
}
