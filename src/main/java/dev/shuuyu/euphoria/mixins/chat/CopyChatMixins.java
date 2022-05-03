package dev.shuuyu.euphoria.mixins.chat;

import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.List;

@Mixin(value = CopyChatMixins.class, priority = 1001)
public abstract class CopyChatMixins {
    private List<ChatHudLine<Text>> currentMessages;

    @Unique
    private void euphoria$copyChatMethodsByText(Text text) {

    }
}
