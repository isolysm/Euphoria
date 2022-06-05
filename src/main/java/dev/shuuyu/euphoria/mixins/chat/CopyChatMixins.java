package dev.shuuyu.euphoria.mixins.chat;

import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(value = ChatHud.class, priority = 1001)
public abstract class CopyChatMixins {
    @Unique
    private void euphoria$copyChatMethodsByText(Text text) {

    }
}
