package github.quarnstrom.minecraftgods.player.capabilities.storage;

import github.quarnstrom.minecraftgods.gods.enums.GodsEnum;
import github.quarnstrom.minecraftgods.player.capabilities.IPietyCapability;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class PlayerPietyStorage implements Capability.IStorage<IPietyCapability> {

    private static final String GOD_NAME = "godName";
    private static final String PIETY = "piety";

    @Override
    public NBTBase writeNBT(Capability<IPietyCapability> capability, IPietyCapability instance, EnumFacing side) {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString(GOD_NAME, instance.getCurrentGod().getDisplayName());
        tag.setLong(PIETY, instance.getCurrentPiety().pietyLevel);
        System.out.println(instance.getCurrentGod().toString());
        System.out.println(instance.getCurrentPiety().pietyLevel);
        System.out.println(tag.getString(GOD_NAME));
        System.out.println(tag.getLong(PIETY));
        return tag;
    }

    @Override
    public void readNBT(Capability<IPietyCapability> capability, IPietyCapability instance, EnumFacing side, NBTBase nbt) {
        instance.setGod(GodsEnum.toGod(((NBTTagCompound) nbt).getString(GOD_NAME)));
        instance.setPietyLevel(((NBTTagCompound) nbt).getLong(PIETY));
        System.out.println(((NBTTagCompound) nbt).getString(GOD_NAME));
        System.out.println(((NBTTagCompound) nbt).getLong(PIETY));
    }
}
