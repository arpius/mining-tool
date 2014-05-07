package biz.arpius.miningtool;

import biz.arpius.acercade.AcercaDe;
import biz.arpius.mineria.Mineria;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener{

	TextView tituloApp = null;
	TextView tituloOC = null;
	TextView tituloM = null;
	TextView tituloAD = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //para no mostrar la barra de título
		setContentView(R.layout.activity_main);
		
		tituloApp = (TextView) findViewById(R.id.txtTituloApp);
		tituloOC = (TextView) findViewById(R.id.txtTituloOC);
		tituloM = (TextView) findViewById(R.id.txtTituloM);
		tituloAD = (TextView) findViewById(R.id.txtTituloAcercaDe);
		
		Typeface fuente = Typeface.createFromAsset(getAssets(), "tiza.ttf"); //fuente personalizada
		
		tituloApp.setTypeface(fuente);
		tituloOC.setTypeface(fuente);
		tituloM.setTypeface(fuente);
		tituloAD.setTypeface(fuente);
		
		tituloOC.setOnClickListener(this);
		tituloM.setOnClickListener(this);
		tituloAD.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
			case R.id.txtTituloOC:
				Toast.makeText(getApplication(), R.string.proximamente, Toast.LENGTH_SHORT).show();
				break;
				
			case R.id.txtTituloM:
				//Toast.makeText(getBaseContext(), R.string.mineria, Toast.LENGTH_SHORT).show();
				startActivity( new Intent(this, Mineria.class) );
				break;
				
			case R.id.txtTituloAcercaDe:
				//Toast.makeText(getBaseContext(), R.string.acerca_de, Toast.LENGTH_SHORT).show();
				startActivity( new Intent(this, AcercaDe.class) );
				break;
	
			default:
				Toast.makeText(getBaseContext(), R.string.error, Toast.LENGTH_SHORT).show();
				break;
		}
		
	}


}
