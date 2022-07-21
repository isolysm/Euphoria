package dev.shuuyu.euphoria.render

import dev.shuuyu.euphoria.config.EuphoriaConfig
import gg.essential.elementa.UIComponent
import gg.essential.elementa.components.UIImage
import gg.essential.elementa.components.Window
import gg.essential.elementa.constraints.RelativeConstraint
import gg.essential.elementa.constraints.animation.Animations
import gg.essential.elementa.dsl.animate
import gg.essential.elementa.dsl.childOf
import gg.essential.elementa.dsl.constrain
import gg.essential.elementa.dsl.pixels
import java.awt.image.BufferedImage
import java.io.IOException
import java.util.concurrent.CompletableFuture

object ScreenshotRender {
    private var currentWindow: Window? = null

    private fun collapseAnimationPosition(image: BufferedImage) {
        val imageComponent = UIImage(CompletableFuture.completedFuture(image)).constrain {
            x = 0.pixels()
            y = 0.pixels()
            width = RelativeConstraint(1.0F)
            height = RelativeConstraint(1.0F)
        } childOf currentWindow!!

        when (EuphoriaConfig.screenShotPosition) {
            1 -> {
                imageComponent.animate {
                    width = RelativeConstraint()
                    height = RelativeConstraint()
                }
            }

            2 -> {
                imageComponent.animate {

                }
            }

            3 -> {
                imageComponent.animate {

                }
            }

            4 -> {
                imageComponent.animate {

                }
            }

            else -> {
                throw IOException("You shouldn't be seeing this >:( . Please report it to the Euphoria development team!")
            }
        }
    }

    private fun fadeAnimation(container: UIComponent) {
        container.animate {

        }
    }

    private fun slideOutAnimation(container: UIComponent) {
        container.animate {
            setXAnimation(
                Animations.IN_OUT_CIRCULAR,
                1.0F,
                RelativeConstraint(2.0F),
            ).onComplete{ currentWindow = null}
        }
    }
}
