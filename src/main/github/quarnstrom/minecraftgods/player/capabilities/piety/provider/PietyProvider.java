package github.quarnstrom.minecraftgods.player.capabilities.piety.provider;
import github.quarnstrom.minecraftgods.player.capabilities.piety.interfaces.IPietyCapability;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PietyProvider implements ICapabilitySerializable<NBTBase>, ICapabilityProvider
{
    @CapabilityInject(IPietyCapability.class)
    public static final Capability<IPietyCapability> PIETY_CAP = null;

    private IPietyCapability instance = PIETY_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability==PIETY_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
    {
        return capability == PIETY_CAP ? PIETY_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT()
    {
        return PIETY_CAP.getStorage().writeNBT(PIETY_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt)
    {
        PIETY_CAP.getStorage().readNBT(PIETY_CAP, this.instance, null, nbt);
    }
}
