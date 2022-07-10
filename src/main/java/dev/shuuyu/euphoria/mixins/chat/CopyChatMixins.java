package dev.shuuyu.euphoria.mixins.chat;

import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = ChatHud.class, priority = 1001)
public abstract class CopyChatMixins {

}
