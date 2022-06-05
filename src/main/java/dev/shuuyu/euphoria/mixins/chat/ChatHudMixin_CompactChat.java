package dev.shuuyu.euphoria.mixins.chat;

import dev.shuuyu.euphoria.config.EuphoriaConfig;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ChatHud.class)
public class ChatHudMixin_CompactChat {

    @Inject(method = "addMessage(Lnet/minecraft/text/Text;)V", at = @At("HEAD"))
    private void euphoria$newChatLine(Text message, CallbackInfo ci) {
        EuphoriaConfig.INSTANCE.getEnableChatCompression();
    }

    @Inject(method = "addMessage(Lnet/minecraft/text/Text;)V", at=@At("TAIL"))
    private void euphoria$resetChatLine(Text message, CallbackInfo ci) {

    }
}
