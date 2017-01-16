package github.quarnstrom.minecraftgods.block;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

/**
 * Created by eisenhorn on 1/14/2017.
 */
public class ClientBlockInit {
    public static void preInit(){
        for(Block block : CommonBlockInit.blockList){
            ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(
                    Reference.MODID + ":" + block.getUnlocalizedName().substring(5)
                    , "inventory");
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, itemModelResourceLocation);
        }
    }

    public static void init(){

    }

    public static void postInit(){

    }

}
