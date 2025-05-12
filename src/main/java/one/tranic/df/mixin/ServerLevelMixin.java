package one.tranic.df.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.biome.Biome;
import one.tranic.df.DF;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {
    @Redirect(method = "tickPrecipitation", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/Biome;shouldFreeze(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)Z"))
    private boolean redirectCanSetIce(Biome instance, LevelReader level, BlockPos pos) {
        var w = ((ServerLevel) level);
        if (w.getGameRules().getBoolean(DF.SHOULD_FREEZE_NATURALLY)) {
            return instance.shouldFreeze(level, pos);
        }
        return false;
    }
}
