package biz.arpius.mineria;

import biz.arpius.miningtool.R;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.Window;
import android.widget.TextView;

public class MaquinariaSubterranea extends Activity {

	TextView tituloM = null;
	TextView maquinariaGaleriaPrep = null;
	TextView maquinariaArranque = null;
	TextView maquinariaCarga = null;
	TextView maquinariaTransporte = null;
	TextView maquinariaRelleno = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //para no mostrar la barra de título
		setContentView(R.layout.activity_maquinaria_subte);
		
		tituloM = (TextView) findViewById(R.id.txtTituloMaq);
		maquinariaGaleriaPrep = (TextView) findViewById(R.id.txtMaquinariaGalPrep);
		maquinariaArranque = (TextView) findViewById(R.id.txtMaquinariaArranque);
		maquinariaCarga = (TextView) findViewById(R.id.txtMaquinariaCarga);
		maquinariaTransporte = (TextView) findViewById(R.id.txtMaquinariaTransp);
		maquinariaRelleno = (TextView) findViewById(R.id.txtMaquinariaRelleno);
		
		Typeface fuente = Typeface.createFromAsset(getAssets(), "tiza.ttf"); //fuente personalizada
		
		tituloM.setTypeface(fuente);
		
		//recogemos los datos
		Bundle bundle = getIntent().getExtras();
		
		maquinariaGaleriaPrep.setText( bundle.getString("galeriaPrep") );
		maquinariaArranque.setText( bundle.getString("arranque") );
		maquinariaCarga.setText( bundle.getString("carga") );
		maquinariaTransporte.setText( bundle.getString("transporte") );
		maquinariaRelleno.setText( bundle.getString("relleno") );
		
	}

}
