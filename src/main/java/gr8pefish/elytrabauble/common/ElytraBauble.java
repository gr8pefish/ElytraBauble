package gr8pefish.elytrabauble.common;

import gr8pefish.elytrabauble.common.lib.ModInfo;
import gr8pefish.elytrabauble.common.proxy.IProxy;
import gr8pefish.elytrabauble.common.registry.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.MODID, name = ModInfo.MOD_NAME, version = ModInfo.VERSION, acceptableRemoteVersions = ModInfo.ACCEPTABLE_REMOTE_VERSION)
public class ElytraBauble {

    //Proxies
    @SidedProxy(clientSide = ModInfo.CLIENT_PROXY, serverSide = ModInfo.COMMON_PROXY)
    public static IProxy proxy;

    //Mod Instance
    @Mod.Instance
    public static ElytraBauble instance;

    //Creative Tab
    public static final CreativeTabs creativeTab = new CreativeTabs(ModInfo.MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemRegistry.itemElytraBauble);
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        //Items
        ItemRegistry.registerItems();

        //Item rendering
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }


    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
