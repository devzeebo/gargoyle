package com.zeebo.gargoyle.example

import com.zeebo.gargoyle.DisplayController
import com.zeebo.gargoyle.GameDefinition
import com.zeebo.gargoyle.gameobject.GameObject
import com.zeebo.gargoyle.prefab.PrefabManager

/**
 * User: Eric
 */
class GargoyleExampleLauncher {

	GargoyleExampleLauncher() {

		DisplayController dc = new DisplayController()

		dc.gameDefinition = GameDefinition.load(new ExampleGameDefinition())

		GameObject go = PrefabManager.quad.newGameObject()

		dc.sceneGraph.children << go

		dc.loop()

		dc.destroy()
	}

	public static void main(String[] args) {
		new GargoyleExampleLauncher()
	}
}
