package gr8pefish.elytrabauble.common.registry;

import gr8pefish.elytrabauble.common.item.ItemElytraBauble;
import gr8pefish.elytrabauble.common.lib.ModInfo;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {

    public static ItemElytraBauble itemElytraBauble;

    public static void registerItems(){
        itemElytraBauble = (ItemElytraBauble) registerItem(new ItemElytraBauble(), ModInfo.ITEM_ELYTRA_BAUBLE_NAME);
    }

    public static void registerRenders(){
        itemRender(itemElytraBauble, 0, ModInfo.ITEM_ELYTRA_BAUBLE_NAME);
    }

    //Helper methods for registration
    private static Item registerItem(Item item, String name) {
        item.setRegistryName(name);
        GameRegistry.register(item);
        return item;
    }

    private static void itemRender(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ModInfo.DOMAIN + name, "inventory"));
    }

}
