package dev.shuuyu.euphoria.mixins;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin_ScreenshotRenderer {
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/GameRenderer;render(FJZ)V"))
    public void screenshotRender(boolean tick, CallbackInfo ci) {

    }
}
