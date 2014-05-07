package biz.arpius.mineria;

import calculos.Calculos;
import biz.arpius.miningtool.R;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Window;
import android.widget.TextView;

public class Maquinaria extends Activity {

	TextView tituloM = null;
	TextView maquinariaArranque = null;
	TextView maquinariaCarga = null;
	TextView maquinariaTransporte = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //para no mostrar la barra de título
		setContentView(R.layout.activity_maquinaria);
		
		tituloM = (TextView) findViewById(R.id.txtTituloMaq);
		maquinariaArranque = (TextView) findViewById(R.id.txtMaquinariaArranque);
		maquinariaCarga = (TextView) findViewById(R.id.txtMaquinariaCarga);
		maquinariaTransporte = (TextView) findViewById(R.id.txtMaquinariaTransp);
		
		Typeface fuente = Typeface.createFromAsset(getAssets(), "tiza.ttf"); //fuente personalizada
		
		tituloM.setTypeface(fuente);
		
		//recogemos los datos
		Bundle bundle = getIntent().getExtras();
		
		if( Calculos.esArido ) {
			maquinariaArranque.setText( bundle.getString("arranque") );
			maquinariaCarga.setText( bundle.getString("carga") );
			maquinariaTransporte.setText( bundle.getString("transporte") );
		}
		else {
			maquinariaArranque.setText( getString(R.string.esteril)+ ": " +bundle.getString("arranqueEst")+ "\n" +getString(R.string.mineral)+ ": " +bundle.getString("arranque") );
			maquinariaCarga.setText( getString(R.string.esteril)+ ": " +bundle.getString("cargaEst")+ "\n" +getString(R.string.mineral)+ ": " +bundle.getString("carga") );
			maquinariaTransporte.setText( getString(R.string.esteril)+ ": " +bundle.getString("transporteEst")+ "\n" +getString(R.string.mineral)+ ": " +bundle.getString("transporte") );
		}
		
	}

}
