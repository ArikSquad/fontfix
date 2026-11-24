package eu.mikart.fontfix.mixin;

import static org.lwjgl.util.freetype.FreeType.FT_LOAD_NO_AUTOHINT;
import static org.lwjgl.util.freetype.FreeType.FT_LOAD_NO_HINTING;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(targets = {
        "net.minecraft.class_395",
        "net.minecraft.class_1011"
}, remap = false)
abstract class IntermediaryGlyphLoadingMixin {
    @ModifyArg(method = "*", at = @At(value = "INVOKE",
            target = "Lorg/lwjgl/util/freetype/FreeType;FT_Load_Glyph(Lorg/lwjgl/util/freetype/FT_Face;II)I"),
            index = 2, allow = 1, remap = false)
    private static int fontshield$disableBytecodeHinting(int flags) {
        return flags | FT_LOAD_NO_HINTING | FT_LOAD_NO_AUTOHINT;
    }
}
