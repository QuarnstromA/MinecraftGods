package github.quarnstrom.minecraftgods.proxy;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.blocks.init.ClientBlockInit;
import github.quarnstrom.minecraftgods.items.init.ClientItemInit;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy{
    @Override
    public void preInit( ){
        super.preInit();
        ClientItemInit.preInit();
        ClientBlockInit.preInit();
    }

    @Override
    public void init ( ){
        super.init();
        ClientItemInit.init();
    }

    @Override
    public void postInit(){
        super.postInit();
        ClientItemInit.postInit();
    }

    public static void registerRenders(Item item) {
        ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(
                Reference.MODID + ":" + item.getUnlocalizedName().substring(5)
                , "inventory");
        final int DEFAULT_ITEM_SUBTYPE = 0;
        ModelLoader.setCustomModelResourceLocation(item, DEFAULT_ITEM_SUBTYPE, itemModelResourceLocation);
    }

}
