package me.spacety.standalonebeheading.enchantment;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber
public class LootModificationHandler {

    private static final Random random = new Random();

    @SubscribeEvent
    public static void onMobKill(LivingDeathEvent event) {
        LivingEntity entity = event.getEntityLiving();
        AxisAlignedBB area = new AxisAlignedBB(entity.getPosX() - 100, entity.getPosY() - 100, entity.getPosZ() - 100,
                entity.getPosX() + 100, entity.getPosY() + 100, entity.getPosZ() + 100);
        List<PlayerEntity> players = entity.world.getEntitiesWithinAABB(PlayerEntity.class, area);
        for (PlayerEntity player : players) {
            ItemStack weapon = player.getHeldItemMainhand();
            int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(ModEnchantments.BEHEADING_ENCHANT, weapon);
            float randomint = random.nextFloat();
            if (enchantmentLevel > 0 && randomint < 0.1 * enchantmentLevel) {
                ItemStack droppedHead = getMobHead(entity);
                if (!droppedHead.isEmpty()) {
                    entity.entityDropItem(droppedHead, 0.0F);
                }
            }
        }
    }


    private static ItemStack getMobHead(LivingEntity entity) {
        ResourceLocation entityType = entity.getType().getRegistryName();
        if (entityType != null) {
            String entityTypePath = entityType.getPath();
            if (entityTypePath.contains("wither")) {
                return new ItemStack(Items.WITHER_SKELETON_SKULL);
            }
            switch (entityTypePath) {
                case "zombie":
                    return new ItemStack(Items.ZOMBIE_HEAD);
                case "skeleton":
                    return new ItemStack(Items.SKELETON_SKULL);
                case "creeper":
                    return new ItemStack(Items.CREEPER_HEAD);
                case "player":
                    return new ItemStack(Items.PLAYER_HEAD);
                case "ender_dragon":
                    return new ItemStack(Items.DRAGON_HEAD);
                default:
                    return ItemStack.EMPTY;
            }
        }
        return ItemStack.EMPTY;
    }
}
