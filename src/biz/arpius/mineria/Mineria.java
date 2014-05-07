package biz.arpius.mineria;

import biz.arpius.miningtool.R;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

public class Mineria extends FragmentActivity implements OnClickListener {

	TextView tituloM = null;
	TextView tituloSub = null;
	TextView tituloCA = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //para no mostrar la barra de título
		setContentView(R.layout.activity_mineria);
		
		tituloM = (TextView) findViewById(R.id.txtTituloM);
		tituloSub = (TextView) findViewById(R.id.txtTituloSub);
		tituloCA = (TextView) findViewById(R.id.txtTituloCA);
		
		Typeface fuente = Typeface.createFromAsset(getAssets(), "tiza.ttf"); //fuente personalizada
		
		tituloM.setTypeface(fuente);
		tituloSub.setTypeface(fuente);
		tituloCA.setTypeface(fuente);
		
		tituloSub.setOnClickListener(this);
		tituloCA.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch ( v.getId() ) {
			case R.id.txtTituloSub:
				startActivity( new Intent(this, Subterranea.class) );
				break;
	
			case R.id.txtTituloCA:
				startActivity( new Intent(this, CieloAbierto.class) );
				break;
				
			default:
				Toast.makeText(getBaseContext(), R.string.error, Toast.LENGTH_SHORT).show();
				break;
		}
		
	}

}
