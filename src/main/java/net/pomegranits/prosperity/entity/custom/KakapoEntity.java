package net.pomegranits.prosperity.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import net.minecraft.world.entity.animal.horse.ZombieHorse;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;
import net.pomegranits.prosperity.sounds.ModSounds;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class KakapoEntity extends Animal implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public KakapoEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8.0D)
                .add(Attributes.MOVEMENT_SPEED,0.25f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new PanicGoal(this,1.25D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Zombie.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Drowned.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Husk.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Skeleton.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Stray.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, SkeletonHorse.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, WitherBoss.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, WitherSkeleton.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Zoglin.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombieHorse.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombieVillager.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, ZombifiedPiglin.class, 16F, 1.6D, 1.4D ));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(7, (new HurtByTargetGoal(this)).setAlertOthers());
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return null;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kakapo.walk", true));
            return PlayState.CONTINUE;

        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.kakapo.idle", true));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }


    protected void playStepSound(BlockPos pos, BlockState blockIn) {
    }
    protected SoundEvent getAmbientSound() {
        return ModSounds.KAKAPO_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSounds.KAKAPO_HURT.get();
    }

    public SoundEvent getDeathSound() {
        return ModSounds.KAKAPO_DEATH.get();
    }


    protected float getSoundVolume() {
        return 0.2F;
    }
}
