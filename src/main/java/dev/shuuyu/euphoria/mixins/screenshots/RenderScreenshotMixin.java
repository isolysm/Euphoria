package dev.shuuyu.euphoria.mixins.screenshots;

import dev.shuuyu.euphoria.Euphoria;
import dev.shuuyu.euphoria.config.EuphoriaConfig;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.util.ScreenshotRecorder;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.util.function.Consumer;

@Mixin(ScreenshotRecorder.class)
public abstract class RenderScreenshotMixin {

    @Shadow
    private File file;

    @Inject(method = "method_1661", at = @At(value = "INVOKE", target = "Lnet/minecraft/text/LiteralText;<init>(Ljava/lang/String;)V"))
    private static void euphoria$prerenderScreenshots(NativeImage nativeImage, File file, Consumer consumer, CallbackInfo ci) {
        EuphoriaConfig.INSTANCE.getEnablePreviewScreenshot();
    }
}
