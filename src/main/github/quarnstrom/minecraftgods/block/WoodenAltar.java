package github.quarnstrom.minecraftgods.block;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.player.capabilities.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.provider.PietyProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

/**
 * Created by eisenhorn on 1/13/2017.
 */
public class WoodenAltar extends Block {

    public WoodenAltar()
    {
        super(Material.WOOD);
        setUnlocalizedName("wooden_altar");
        setRegistryName(new ResourceLocation(Reference.MODID, getUnlocalizedName().substring(5)));
        this.setCreativeTab(CreativeTabs.MISC);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY)
    {
        if(!worldIn.isRemote) {
            playerIn.addChatMessage(new TextComponentString("You have clicked me."));
        }
            IPietyCapability piety = playerIn.getCapability(PietyProvider.PIETY_CAP, null);
            piety.setGod(GodsEnum.SKORME);
            piety.setPietyLevel(1000);
            return true;

    }
}
