package biz.arpius.obracivil;

import biz.arpius.miningtool.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class ObraCivil extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_obra_civil);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.obra_civil, menu);
		return true;
	}

}
