package dev.shuuyu.euphoria.mixins.chat;

import dev.shuuyu.euphoria.config.EuphoriaConfig;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;


@Mixin(ChatHud.class)
public class ChatHudMixin_InfChat {

    @ModifyConstant(method = "addMessage(Lnet/minecraft/text/Text;IIZ)V", constant = @Constant(intValue = 100))
    public int modifyChatLength(int original) {
        return EuphoriaConfig.INSTANCE.getEnableInfChat() ? Integer.MAX_VALUE : original;
    }
}
