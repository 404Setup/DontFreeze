package one.tranic.df;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class DF implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> SHOULD_FREEZE_NATURALLY =
            GameRuleRegistry.register("shouldFreezeNaturally", GameRules.Category.UPDATES, GameRuleFactory.createBooleanRule(true));

    @Override
    public void onInitialize() {
    }
}
