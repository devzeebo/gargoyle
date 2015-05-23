package com.zeebo.gargoyle

import com.zeebo.gargoyle.behavior.BehaviorManager
import com.zeebo.gargoyle.scene.Scene
import com.zeebo.gargoyle.util.Timing
import org.lwjgl.Sys
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
		Display.displayMode = new DisplayMode(settings.width, settings.height, 32, settings.refreshRate, true)
		if (settings.fullscreen) {
			Display.fullscreen = settings.fullscreen
		}
		Display.create(new PixelFormat(), contextAttribs)
	}

	def loop() {

		int fps = 0

		def getTime = { (Sys.time * 1000) / Sys.timerResolution }

		long lastFPS = getTime()

		def updateFps = {
			if (getTime() - lastFPS > 1000) {
				Display.title = "FPS: $fps"
				fps = 0
				lastFPS += 1000
			}
			fps++
		}

		def timings = new ArrayList(300)

		Thread.start {
			long lastTime = System.currentTimeMillis()
			int frameCap = 60
			while (Display.created && !Display.closeRequested) {
				timings << Timing.time {
					BehaviorManager.update()
				}
				int millisToSleep = 1000 / 60 - (System.currentTimeMillis() - lastTime)
				if (millisToSleep > 0) {
					sleep(millisToSleep)
				}
				lastTime = System.currentTimeMillis()
				if (timings.size() == 200) {
					println "Average update: ${timings.sum() / 200}"
					timings.clear()
				}
			}
		}

		while (!Display.closeRequested) {
			updateFps()
			Timing.time {
				gameDefinition.renderer.render currentScene.sceneGraph
				Display.update()
			}
//			Display.sync(60)
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
		settings.fullscreen = Boolean.parseBoolean settings.fullscreen
		settings.refreshRate = settings.refreshRate as int
	}

	def saveSettings() {
		settings.toProperties().store propsFile.newWriter(), null
	}
}
