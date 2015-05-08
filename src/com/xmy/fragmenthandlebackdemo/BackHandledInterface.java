package com.xmy.fragmenthandlebackdemo;

public interface BackHandledInterface {

	public abstract void setSelectedFragment(BackHandledFragment selectedFragment);
	
	public void popBackSelectedFragment(BackHandledFragment selectedFragment);
}
