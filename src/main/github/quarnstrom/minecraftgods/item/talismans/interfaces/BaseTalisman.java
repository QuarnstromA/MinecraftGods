package github.quarnstrom.minecraftgods.item.talismans.interfaces;

import github.quarnstrom.minecraftgods.Reference;
import github.quarnstrom.minecraftgods.item.interfaces.ModItemInterface;
import github.quarnstrom.minecraftgods.item.talismans.PrayHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public abstract class BaseTalisman extends Item implements ModItemInterface
{

    @Override
    public int getMaxItemUseDuration(ItemStack stack){
        final int DURATION = 2;
        return Reference.TICKS_PER_SECOND*DURATION;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack){
        return EnumAction.BLOCK;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World itemStackIn, EntityPlayer worldIn, EnumHand playerIn)
    {
        worldIn.setActiveHand(playerIn);
        return new ActionResult(EnumActionResult.SUCCESS, worldIn.getHeldItem((playerIn)));
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase player){
        PrayHandler.pray((EntityPlayer)player);
        return stack;
    }
}
