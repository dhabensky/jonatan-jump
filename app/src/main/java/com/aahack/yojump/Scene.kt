package com.aahack.yojump

import android.graphics.Canvas
import com.aahack.yojump.gameobject.GameObject

/**
 * Created on 15.12.2018.
 * @author dhabensky <dhabensky@yandex.ru>
 */
class Scene {

	private val objects = arrayListOf<GameObject>()

	private var lastFrameMillis: Long = 0L

	fun render(canvas: Canvas) {

		val curMillis = System.currentTimeMillis()
		if (lastFrameMillis == 0L) {
			lastFrameMillis = curMillis
		}
		val delta = (curMillis - lastFrameMillis) / 1000f

		for (obj in objects) {
			obj.update(delta)
			obj.render(canvas)
		}

	}

	fun addObject(gameObject: GameObject) {
		objects.add(gameObject)
	}

}
