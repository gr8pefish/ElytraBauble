package gr8pefish.elytrabauble.common.item;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import gr8pefish.elytrabauble.common.ElytraBauble;
import gr8pefish.elytrabauble.common.lib.ModInfo;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.Iterator;

import static gr8pefish.elytrabauble.common.lib.ModInfo.MODID;

public class ItemElytraBauble extends ItemElytra implements IBauble {

    public ItemElytraBauble() {
        super();
        this.setCreativeTab(ElytraBauble.creativeTab);
        this.setUnlocalizedName(MODID +":" + ModInfo.ITEM_ELYTRA_BAUBLE_NAME);
    }

    //Right click to equip
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if(!world.isRemote) {
            IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);

            for(int i = 0; i < baubles.getSlots(); ++i) {
                if((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty()) && baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) {
                    baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
                    if(!player.capabilities.isCreativeMode) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
                    }

                    this.onEquipped(player.getHeldItem(hand), player);
                    break;
                }
            }
        }

        return new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return BaubleType.BODY;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        //ToDo: Plays sounds sometimes when it shouldn't (e.g. opening Baubles inventory)
        player.playSound(SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.5F, 1.2F);
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
        player.playSound(SoundEvents.ITEM_ARMOR_EQIIP_ELYTRA, 0.5F, 1.2F);
    }


    /**
     * Can equip only if not already wearing an elytra.
     */
    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {

        //ToDo: Gross and hacky, clean this implementation up
        final boolean[] hasElytraOn = new boolean[1];
        hasElytraOn[0] = false;

        player.getArmorInventoryList().forEach(itemStack -> {
            if (itemStack != null && (itemStack.getItem() instanceof ItemElytra || itemStack.getItem().getClass().isAssignableFrom(ItemElytra.class))) {
                hasElytraOn[0] = true;
        }});

        return !hasElytraOn[0];
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
        return false;
    }

}
