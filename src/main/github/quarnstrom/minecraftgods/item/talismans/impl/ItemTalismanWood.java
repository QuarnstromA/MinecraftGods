package github.quarnstrom.minecraftgods.item.talismans.impl;

import github.quarnstrom.minecraftgods.item.talismans.interfaces.BaseTalisman;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTalismanWood extends BaseTalisman
{

    public ItemTalismanWood(){
        super();
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.MISC);
        setUnlocalizedName("talisman_wood");
    }

    @Override
    public void registerRecipe() {
        GameRegistry.addRecipe(new ItemStack(this, 1),
        " A ",
                 "ABA",
                 " A ",
                'A', Items.STICK, 'B', Blocks.LOG);
    }
}
