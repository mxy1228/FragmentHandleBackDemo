package com.xmy.fragmenthandlebackdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements BackHandledInterface{

	private BackHandledFragment mBackHandedFragment;
	private List<BackHandledFragment> mBackHandedList=new ArrayList<BackHandledFragment>();
	private boolean hadIntercept;
	
	private Button mBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.mBtn = (Button)findViewById(R.id.btn);
		this.mBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				MyFragment f = new MyFragment();
				FragmentManager fm = getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.container, f);
				ft.addToBackStack("tag");
				ft.commit();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void setSelectedFragment(BackHandledFragment selectedFragment) {
		mBackHandedList.add(selectedFragment);
		this.mBackHandedFragment = selectedFragment;
	}
	
	@Override
	public void popBackSelectedFragment(BackHandledFragment selectedFragment) {
		mBackHandedList.remove(selectedFragment);
		int size=mBackHandedList.size();
		if(size>0){
		    this.mBackHandedFragment = mBackHandedList.get(size-1);
		}
		
	}
	
	@Override
	public void onBackPressed() {
		if(mBackHandedFragment == null || !mBackHandedFragment.onBackPressed()){
			if(getSupportFragmentManager().getBackStackEntryCount() == 0){
				super.onBackPressed();
			}else{
				getSupportFragmentManager().popBackStack();
			}
		}
	}
}
