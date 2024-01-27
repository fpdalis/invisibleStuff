package net.fpdalis.invisiblestuff.datagen;

import net.fpdalis.invisiblestuff.InvisibleStuff;
import net.fpdalis.invisiblestuff.block.ModBlocks;
import net.fpdalis.invisiblestuff.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,ExistingFileHelper existingFileHelper) {
        super(output, InvisibleStuff.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        blockWitCustomItemTexture(ModBlocks.INVISIBLE_BUTTON);
        blockWitCustomItemTexture(ModBlocks.INVISIBLE_PRESSUREPLATE);
        blockWitCustomItemTexture(ModBlocks.INVISIBLE_FENCE);
        blockWitCustomItemTexture(ModBlocks.INVISIBLE_BLOCK);
        blockWitCustomItemTexture(ModBlocks.INVISIBLE_LEVER);
        blockWitCustomItemTexture(ModBlocks.INVISIBLE_DOOR);
        itemWithVanillaTexture(ModItems.MAGIC_WAND);

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(InvisibleStuff.MODID, "item/" + item.getId().getPath()));
    }
    private ItemModelBuilder itemWithVanillaTexture(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation( "item/stick"));
    }

    public void blockWitCustomItemTexture(RegistryObject<Block> block){

        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(InvisibleStuff.MODID, "item/" + block.getId().getPath()));
    }
}
