package com.fluidbot.insertion;

public interface INode {

	public INode next();
	
	public INode prev();

	public long uid();
	
}
