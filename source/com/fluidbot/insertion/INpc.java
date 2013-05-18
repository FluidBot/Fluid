package com.fluidbot.insertion;

public interface INpc extends IActor {

	public INpcComposition getComposite();
	
	public IModel getThisModel();
	
	public void setThisModel(IModel model);
}
