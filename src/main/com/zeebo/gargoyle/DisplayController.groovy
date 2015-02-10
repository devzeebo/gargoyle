package com.zeebo.gargoyle

import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.scene.Scene
import org.lwjgl.opengl.ContextAttribs
import org.lwjgl.opengl.Display
import org.lwjgl.opengl.DisplayMode
import org.lwjgl.opengl.PixelFormat

/**
 * User: Eric
 */
class DisplayController {

	ConfigObject settings
	File propsFile = new File('settings.properties')

	GameDefinition gameDefinition

	Scene currentScene

	DisplayController() {

		loadSettings()

		ContextAttribs contextAttribs = new ContextAttribs(3, 2).withForwardCompatible(true).withProfileCore(true)
		Display.displayMode = new DisplayMode(settings.width, settings.height)
		Display.create(new PixelFormat(), contextAttribs)
	}

	def loop() {

		while (!Display.closeRequested) {
			gameDefinition.renderer.render(currentScene.sceneGraph)
			Display.update()
		}
	}

	def destroy() {

		saveSettings()

		Display.destroy()
	}

	def loadSettings() {
		Properties props = new Properties()
		props.load(new File('defaults.properties').newReader())
		settings = new ConfigSlurper().parse(props)

		if (propsFile.exists()) {
			props.clear()
			props.load(propsFile.newReader())
			settings.merge new ConfigSlurper().parse(props)
		}

		settings.width = settings.width as int
		settings.height = settings.height as int
	}

	def saveSettings() {
		settings.toProperties().store propsFile.newWriter(), null
	}
}
