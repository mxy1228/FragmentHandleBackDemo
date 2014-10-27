package com.xmy.fragmenthandlebackdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MyFragment extends BackHandledFragment {

	private boolean hadIntercept;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return getLayoutInflater(savedInstanceState).inflate(R.layout.fragment_a, null);
	}
	
	@Override
	protected boolean onBackPressed() {
		if(hadIntercept){
			return false;
		}else{
			Toast.makeText(getActivity(), "Click From MyFragment", Toast.LENGTH_SHORT).show();
			hadIntercept = true;
			return true;
		}
	}

}
