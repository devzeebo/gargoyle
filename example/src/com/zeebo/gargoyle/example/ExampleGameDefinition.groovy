package com.zeebo.gargoyle.example

import com.zeebo.gargoyle.behavior.Render
import com.zeebo.gargoyle.behavior.camera.Camera
import com.zeebo.gargoyle.mesh.ObjMeshLoader
import com.zeebo.gargoyle.render.ShaderRenderer
import org.lwjgl.util.vector.Vector3f

definition {

	pooledObjects null

//	shaderRenderer {
//		vertex new File('vertex.glsl').newReader()
//		fragment new File('fragment.glsl').newReader()
//		uniformLocations 'projectionMatrix', 'viewMatrix', 'modelMatrix'
//		vertexBindings 0: 'in_Position', 1: 'in_Color', 2: 'in_Texture'
//	}

	renderer new ShaderRenderer(new File('vertex.glsl').newReader(), new File('fragment.glsl').newReader(),
		[0: 'in_Position', 1: 'in_Color', 2: 'in_Texture'], ['projectionMatrix', 'viewMatrix', 'modelMatrix']
	)

	startScene 'scene1'
}

meshes {
	quad new File('example/quad.obj').newReader(), ObjMeshLoader
}

prefabs {
	quad([(Render): { mesh = 'quad' }])
	camera([(Camera): {
		main = true

		projection.aspectRatio = 16 / 9.0f
		projection.farPlane = 1000.0f
		projection.nearPlane = 0.1f
		projection.fieldOfView = 80
		matrix.translate new Vector3f(0, 0, -10)
	}])
}

scenes {
	scene1 '/scenes/scene1.scene'
}