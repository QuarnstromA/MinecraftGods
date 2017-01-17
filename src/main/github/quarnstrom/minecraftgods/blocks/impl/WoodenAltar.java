package github.quarnstrom.minecraftgods.blocks.impl;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces.IPietyCapability;
import github.quarnstrom.minecraftgods.player.capabilities.piety.provider.PietyProvider;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
            playerIn.addChatMessage(new TextComponentString("You worship " + piety.getCurrentGod().getDisplayName()
                    + " with a piety of " + piety.getCurrentPiety().pietyLevel));
            return true;

    }

    @Override
    public void onLanded(World worldIn, Entity entityIn)
    {
        if(!worldIn.isRemote) {
            entityIn.motionY = 0.0D;
            if (entityIn instanceof EntityItem) {
                Item ent = ((EntityItem) entityIn).getEntityItem().getItem();
                EntityPlayer player = worldIn.getPlayerEntityByName(((EntityItem) entityIn).getThrower());
                if (ent.getUnlocalizedName().equals(Items.WHEAT.getUnlocalizedName())) {
                    IPietyCapability piety = player.getCapability(PietyProvider.PIETY_CAP, null);
                    piety.setGod(GodsEnum.MATA);
                    piety.setPietyLevel(1000);
                } else {
                    IPietyCapability piety = player.getCapability(PietyProvider.PIETY_CAP, null);
                    piety.setGod(GodsEnum.SKORME);
                    piety.setPietyLevel(1000);
                }
                worldIn.removeEntity(entityIn);
            }
        }
    }
}
