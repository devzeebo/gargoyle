package com.zeebo.gargoyle.example

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.mesh.ObjMeshLoader
import com.zeebo.gargoyle.render.ShaderRenderer

definition {

	pooledObjects null

	renderer new ShaderRenderer(new File('vertex.glsl').newReader(), new File('fragment.glsl').newReader(), [
			0: 'in_Position',
			1: 'in_Color',
			2: 'in_Texture'
	])

	startScene 'scene1'
}

meshes {
	quad new File('example/quad.obj').newReader(), ObjMeshLoader
}

prefabs {
	quad( [(Render) : { mesh = 'quad' } ] )
}

scenes {
	scene1 'example/scenes/scene1.scene'
}