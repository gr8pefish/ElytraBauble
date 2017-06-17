package gr8pefish.elytrabauble.common.item;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import gr8pefish.elytrabauble.common.ElytraBauble;
import gr8pefish.elytrabauble.common.lib.ModInfo;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;

import static gr8pefish.elytrabauble.common.lib.ModInfo.MODID;

public class ItemElytraBauble extends ItemElytra implements IBauble {

    public ItemElytraBauble() {
        super();
        setCreativeTab(ElytraBauble.creativeTab);
        setUnlocalizedName(MODID +":" + ModInfo.ITEM_ELYTRA_BAUBLE_NAME);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemStack) {
        return null;
    }

}
