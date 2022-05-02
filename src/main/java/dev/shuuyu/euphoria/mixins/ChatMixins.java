package dev.shuuyu.euphoria.mixins;

import net.minecraft.client.gui.hud.ChatHudLine;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.List;


@Mixin(ChatMixins.class)
    public abstract class ChatMixins {

    /*
    This part was taken from Connor because
     */
    @Final
    private static List<ChatHudLine<Text>> getMessages;


    @Unique
    private static void removeDuplicateMessages(Text text) {

    }
}
