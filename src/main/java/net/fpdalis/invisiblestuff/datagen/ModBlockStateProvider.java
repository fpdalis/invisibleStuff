package net.fpdalis.invisiblestuff.datagen;

import net.fpdalis.invisiblestuff.InvisibleStuff;
import net.fpdalis.invisiblestuff.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, InvisibleStuff.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

       simpleBlock(ModBlocks.INVISIBLE_BLOCK.get(),
               new ModelFile.UncheckedModelFile(modLoc("block/invisible_block")));
        buttonBlock((ButtonBlock) ModBlocks.INVISIBLE_BUTTON.get(), new ModelFile.UncheckedModelFile(modLoc("block/invisible_button")),new ModelFile.UncheckedModelFile(modLoc("block/invisible_button")));

        pressurePlateBlock((PressurePlateBlock) ModBlocks.INVISIBLE_PRESSUREPLATE.get(),new ModelFile.UncheckedModelFile(modLoc("block/invisible_button")),new ModelFile.UncheckedModelFile(modLoc("block/invisible_button")));

        fenceBlockWithRenderType((FenceBlock) ModBlocks.INVISIBLE_FENCE.get(), modLoc("block/invisible_fence"), "minecraft:cutout");

        simpleBlock((LeverBlock) ModBlocks.INVISIBLE_LEVER.get(), new ModelFile.UncheckedModelFile(modLoc("block/invisible_lever")));
        doorBlockWithRenderType((DoorBlock) ModBlocks.INVISIBLE_DOOR.get(), modLoc("block/invisible_door"),modLoc("block/invisible_door"), "minecraft:cutout");
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
