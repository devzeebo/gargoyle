package com.zeebo.gargoyle.example

import com.zeebo.gargoyle.DisplayController
import com.zeebo.gargoyle.GameDefinition
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.prefab.PrefabManager
import com.zeebo.gargoyle.scene.SceneManager

/**
 * User: Eric
 */
class GargoyleExampleLauncher {

	GargoyleExampleLauncher() {

		DisplayController dc = new DisplayController()

		dc.gameDefinition = GameDefinition.load(new File('example/src/com/zeebo/gargoyle/example/ExampleGameDefinition.groovy').newReader())

		dc.currentScene = SceneManager[dc.gameDefinition.startScene]

		dc.loop()

		dc.destroy()
	}

	public static void main(String[] args) {
		new GargoyleExampleLauncher()
	}
}
