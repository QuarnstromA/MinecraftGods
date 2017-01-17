package github.quarnstrom.minecraftgods.items.talismans.impl;

import github.quarnstrom.minecraftgods.items.talismans.interfaces.BaseTalisman;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemTalismanMata extends BaseTalisman
{

    public ItemTalismanMata() {
        super();
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.MISC);
        setUnlocalizedName("talisman_mata");
    }

    @Override
    public void registerRecipe() {
        GameRegistry.addRecipe(new ItemStack(this, 1),
        " A ",
                 "ABA",
                 " A ",
            'A', Items.STICK, 'B', Items.APPLE);
    }

}
