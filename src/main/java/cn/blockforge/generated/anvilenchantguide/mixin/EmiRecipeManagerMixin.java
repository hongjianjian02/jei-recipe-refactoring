package cn.blockforge.generated.anvilenchantguide.mixin;

import java.util.List;

import cn.blockforge.generated.anvilenchantguide.emi.EmiFocusedQueryManager;
import cn.blockforge.generated.anvilenchantguide.emi.FocusedEmiRecipes;
import dev.emi.emi.api.EmiApi;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.stack.EmiStack;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.Mixin;

/** Adds one focused guide page while preserving the manager's other recipe results. */
@Mixin(targets = "dev.emi.emi.registry.EmiRecipes$Manager", remap = false)
public abstract class EmiRecipeManagerMixin implements EmiFocusedQueryManager {
    @Inject(
            method = "getRecipesByInput(Ldev/emi/emi/api/stack/EmiStack;)Ljava/util/List;",
            at = @At("RETURN"), cancellable = true, remap = false, require = 1)
    private void anvilEnchantGuide$addUses(EmiStack stack,
            CallbackInfoReturnable<List<EmiRecipe>> callback) {
        // A cached manager from a previous reload must not acquire current-world pages.
        if ((Object) this == EmiApi.getRecipeManager()) {
            callback.setReturnValue(FocusedEmiRecipes.merge(stack, callback.getReturnValue(), true));
        }
    }

    @Inject(
            method = "getRecipesByOutput(Ldev/emi/emi/api/stack/EmiStack;)Ljava/util/List;",
            at = @At("RETURN"), cancellable = true, remap = false, require = 1)
    private void anvilEnchantGuide$addRecipes(EmiStack stack,
            CallbackInfoReturnable<List<EmiRecipe>> callback) {
        if ((Object) this == EmiApi.getRecipeManager()) {
            callback.setReturnValue(FocusedEmiRecipes.merge(stack, callback.getReturnValue(), false));
        }
    }
}
