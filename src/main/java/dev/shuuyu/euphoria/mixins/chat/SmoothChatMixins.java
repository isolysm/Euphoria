package dev.shuuyu.euphoria.mixins.chat;

import org.spongepowered.asm.mixin.Mixin;


@Mixin(SmoothChatMixins.class)
public abstract class SmoothChatMixins {
    private float percentComplete;
    private int newLines;

}
