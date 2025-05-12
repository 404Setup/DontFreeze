package one.tranic.df;

import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(DF.MODID)
public class DF {
    public static final String MODID = "dont_freeze";

    public static final GameRules.Key<GameRules.BooleanValue> SHOULD_FREEZE_NATURALLY =
            GameRules.register("shouldFreezeNaturally", GameRules.Category.UPDATES, GameRules.BooleanValue.create(true));

    public DF(IEventBus modEventBus, ModContainer modContainer) {
    }
}
