package com.fluidbot.bot.script.callback;

import com.fluidbot.bot.script.callback.PersistentModelCache.MutableCachedModel;
import com.fluidbot.insertion.IActor;
import com.fluidbot.insertion.IModel;
import com.fluidbot.insertion.IRenderable;


/**
 * Model callback used to retrieve renderable's model instances
 * @author tommo
 * @author `Discardedx2
 *
 */
public class ModelCallback {

	public static void callback(IRenderable renderable, IModel model) {
		if (model != null) {
			if (!PersistentModelCache.table.containsKey(renderable)) {
				int orientation = 0;
				if (renderable instanceof IActor) {
					orientation = ((IActor) renderable).getOrientation();
				}
				MutableCachedModel m = new MutableCachedModel(model.getVerticesX(), model.getVerticesY(), model.getVerticesZ(), model.getTriViewX(), model.getTriViewY(), model.getTriViewZ(), orientation);
				PersistentModelCache.table.put(renderable, m);
			} else {
				int orientation = 0;
				if (renderable instanceof IActor) {
					orientation = ((IActor) renderable).getOrientation();
				}
				MutableCachedModel cache = PersistentModelCache.table.get(renderable);
				cache.set(model.getVerticesX(), model.getVerticesY(), model.getVerticesZ(), model.getTriViewX(), model.getTriViewY(), model.getTriViewZ(), orientation);
				PersistentModelCache.table.put(renderable, cache);
			}
		}
	}

}
