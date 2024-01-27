package net.fpdalis.invisiblestuff.datagen;

import net.fpdalis.invisiblestuff.InvisibleStuff;
import net.fpdalis.invisiblestuff.block.ModBlocks;
import net.fpdalis.invisiblestuff.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, InvisibleStuff.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
       this.tag(BlockTags.FENCES).add(ModBlocks.INVISIBLE_FENCE.get());
       this.tag(ModTags.Blocks.INV).add(ModBlocks.INVISIBLE_FENCE.get());
       this.tag(BlockTags.DOORS).add(ModBlocks.INVISIBLE_DOOR.get());

    }
}
