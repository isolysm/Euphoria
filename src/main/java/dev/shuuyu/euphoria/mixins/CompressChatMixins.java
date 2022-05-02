package dev.shuuyu.euphoria.mixins;

import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(CompressChatMixins.class)
public abstract class CompressChatMixins {
    /*
    Removes a duplicated message if there is another message of the same
    type detected.
     */
    @Unique
    private void compressChat$removeMessageByText(Text text) {

    }
}
