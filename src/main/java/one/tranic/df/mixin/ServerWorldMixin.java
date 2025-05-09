package one.tranic.df.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;
import one.tranic.df.DF;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerWorld.class)
public class ServerWorldMixin {
    @Redirect(method = "tickIceAndSnow", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/Biome;canSetIce(Lnet/minecraft/world/WorldView;Lnet/minecraft/util/math/BlockPos;)Z"))
    private boolean redirectCanSetIce(Biome instance, WorldView world, BlockPos blockPos) {
        var w = ((ServerWorld) world);
        if (w.getGameRules().getBoolean(DF.SHOULD_FREEZE_NATURALLY)) {
            return instance.canSetIce(world, blockPos);
        }
        return false;
    }
}
