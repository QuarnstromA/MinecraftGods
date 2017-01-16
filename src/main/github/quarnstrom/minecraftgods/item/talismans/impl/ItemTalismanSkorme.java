package github.quarnstrom.minecraftgods.item.talismans.impl;

import github.quarnstrom.minecraftgods.item.talismans.interfaces.BaseTalisman;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTalismanSkorme extends BaseTalisman
{

    public ItemTalismanSkorme(){
        super();
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.MISC);
        setUnlocalizedName("talisman_skorme");
    }

    public void registerRecipe(){
        GameRegistry.addRecipe(new ItemStack(this, 1),
           " A ",
                    "ABA",
                    " A ",
                'A', Items.IRON_INGOT, 'B', Items.BEEF);
    }

}
