package net.fpdalis.invisiblestuff.item;

import net.fpdalis.invisiblestuff.InvisibleStuff;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InvisibleStuff.MODID);
    public static final RegistryObject<Item> MAGIC_WAND = ITEMS.register("magic_wand",
    () -> new MagicWandItem(new Item.Properties()));
    //methods
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
