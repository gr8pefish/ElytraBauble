package gr8pefish.elytrabauble.common.lib;

/**
 * All the basic information about the mod (that shouldn't ever change)
 */
public class ModInfo {

    public static final String VERSION = "@VERSION@";
    public static final String MODID = "elytrabauble";
    public static final String MOD_NAME = "Elytra Bauble";
    public static final String ACCEPTABLE_REMOTE_VERSION = "*"; //all, allows client to connect to server if they do or do not have it installed

    public static final String COMMON_PROXY = "gr8pefish.elytrabauble.common.proxy.CommonProxy";
    public static final String CLIENT_PROXY = "gr8pefish.elytrabauble.client.proxy.ClientProxy";

    public static final String NETWORK_CHANNEL = "elbbl";

}
