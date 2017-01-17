package github.quarnstrom.minecraftgods.items.talismans.init;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.items.talismans.impl.ItemTalismanMata;
import github.quarnstrom.minecraftgods.items.talismans.impl.ItemTalismanWood;
import github.quarnstrom.minecraftgods.items.talismans.impl.ItemTalismanSkorme;
import github.quarnstrom.minecraftgods.items.talismans.interfaces.BaseTalisman;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.LinkedList;
import java.util.List;

public class CommonTalismanInit {

    public static List<BaseTalisman> talismans;

    public static void preInit(){
        initTalismans();
        for(Item talisman : talismans){
            GameRegistry.register(talisman, new ResourceLocation(Reference.MODID, talisman.getUnlocalizedName().substring(5)));
        }
    }

    public static void init(){
        for ( BaseTalisman talisman : talismans){
            talisman.registerRecipe();
        }
    }

    public static void postInit(){

    }

    public static void initTalismans(){
        talismans = new LinkedList<BaseTalisman>();
        talismans.add(new ItemTalismanMata());
        talismans.add(new ItemTalismanSkorme());
        talismans.add(new ItemTalismanWood());
    }
}
