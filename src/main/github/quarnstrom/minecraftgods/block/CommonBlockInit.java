package github.quarnstrom.minecraftgods.block;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.item.talismans.interfaces.ItemModelProvider;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by eisenhorn on 1/13/2017.
 */
public class CommonBlockInit {

    static List<Block> blockList;

    public static void preInit(){
        initBlocks();
        for(Block block : blockList){
            register(block);
        }
    }

    public static void init(){

    }

    public static void postInit(){
    }

    private static void initBlocks()
    {
        blockList = new LinkedList<Block>();
        blockList.add(new WoodenAltar());
    }


    private static <T extends Block> T register(T block) {
        //GameRegistry.register(block, new ResourceLocation(Reference.MODID, block.getUnlocalizedName().substring(5)));
        //block.setRegistryName(Reference.MODID, block.getUnlocalizedName().substring(5));
        GameRegistry.register(block);
        ItemBlock itemBlock = new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        GameRegistry.register(itemBlock);
        return block;
    }
}
