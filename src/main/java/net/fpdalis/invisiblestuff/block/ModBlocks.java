package net.fpdalis.invisiblestuff.block;

import net.fpdalis.invisiblestuff.InvisibleStuff;
import net.fpdalis.invisiblestuff.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, InvisibleStuff.MODID);



    public static final RegistryObject<Block> INVISIBLE_BUTTON = registerBlock("invisible_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> INVISIBLE_PRESSUREPLATE = registerBlock("invisible_pressureplate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS,BlockBehaviour.Properties.copy(Blocks.BIRCH_PRESSURE_PLATE),BlockSetType.STONE));
    public static final RegistryObject<Block> INVISIBLE_LEVER = registerBlock("invisible_lever",
            () -> new LeverBlock(BlockBehaviour.Properties.copy(Blocks.LEVER)));
    public static final RegistryObject<Block> INVISIBLE_FENCE = registerBlock("invisible_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> INVISIBLE_BLOCK = registerBlock("invisible_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GLASS)));
    public static final RegistryObject<Block> INVISIBLE_DOOR = registerBlock("invisible_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).sound(SoundType.GLASS).noOcclusion(),BlockSetType.STONE));

//methods
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
