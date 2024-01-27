package net.fpdalis.invisiblestuff.datagen;

import net.fpdalis.invisiblestuff.block.ModBlocks;
import net.fpdalis.invisiblestuff.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.MAGIC_WAND.get())
                .pattern("GGG")
                .pattern("GSG")
                .pattern("GGG")
                .define('G', Items.GLASS)
                .define('S', Items.STICK)
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVISIBLE_BUTTON.get())
                .requires(ItemTags.BUTTONS)
                .requires(Items.GLASS)
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVISIBLE_DOOR.get())
                .requires(ItemTags.DOORS)
                .requires(Items.GLASS)
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVISIBLE_FENCE.get())
                .requires(ItemTags.FENCES)
                .requires(Items.GLASS)
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVISIBLE_PRESSUREPLATE.get())
                .requires(ItemTags.WOODEN_PRESSURE_PLATES)
                .requires(Items.GLASS)
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INVISIBLE_LEVER.get())
                .requires(Items.LEVER)
                .requires(Items.GLASS)
                .unlockedBy(getHasName(Blocks.GLASS), has(Blocks.GLASS))
                .save(consumer);
    }
}
