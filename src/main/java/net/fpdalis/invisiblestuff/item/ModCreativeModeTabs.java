package net.fpdalis.invisiblestuff.item;

import net.fpdalis.invisiblestuff.InvisibleStuff;
import net.fpdalis.invisiblestuff.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, InvisibleStuff.MODID);

    public static final RegistryObject<CreativeModeTab> INVISIBLE_STUFF = CREATIVE_MODE_TABS.register("invisible_stuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.GLASS))
                    .title(Component.translatable("creativetab.invisible_stuff"))
                    .displayItems((pParameters, pOutput) -> {
                       pOutput.accept(ModBlocks.INVISIBLE_BUTTON.get());
                       pOutput.accept(ModBlocks.INVISIBLE_FENCE.get());
                       pOutput.accept(ModBlocks.INVISIBLE_LEVER.get());
                       pOutput.accept(ModBlocks.INVISIBLE_PRESSUREPLATE.get());
                       pOutput.accept(ModBlocks.INVISIBLE_BLOCK.get());
                       pOutput.accept(ModBlocks.INVISIBLE_DOOR.get());
                       pOutput.accept(ModItems.MAGIC_WAND.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
