package baguchan.onlylooking.mixin;

import baguchan.onlylooking.LookUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}

	@Inject(at = @At("HEAD"), method = "hasLineOfSight", cancellable = true)
	public void isLookingAtMe(Entity entity, CallbackInfoReturnable<Boolean> cir) {
		LivingEntity livingEntity = (LivingEntity) ((Object) this);
		if (entity.level == this.level && entity instanceof LivingEntity && !LookUtils.isLookingAtYou(livingEntity, (LivingEntity) entity)) {
			cir.setReturnValue(false);
		}
	}
}