package com.zeebo.gargoyle

import org.lwjgl.BufferUtils
import org.lwjgl.opengl.GL11
import org.lwjgl.opengl.Pbuffer
import org.lwjgl.opengl.PixelFormat

import java.awt.image.BufferedImage
import java.nio.IntBuffer

/**
 * User: Eric
 * Date: 5/26/2015
 */
class OffscreenDisplayController extends DisplayController {

	int[] ints
	IntBuffer pixels
	BufferedImage image

	def initialize() {
		Pbuffer pbuffer = new Pbuffer(width, height, new PixelFormat(), null, null)
		pbuffer.makeCurrent()

		int bpp = 3

		ints = new int[width * height * bpp]
		pixels = BufferUtils.createIntBuffer(width * height * bpp)
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
	}

	def redraw() {
		GL11.glReadPixels(0, 0, width, height, GL11.GL_RGB, GL11.GL_UNSIGNED_INT, pixels)

		pixels.get(ints)
		pixels.rewind()
		image.raster.setPixels(0, 0, width, height, ints)
	}
}