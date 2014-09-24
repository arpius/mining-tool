package biz.arpius.mineria;

import calculos.Calculos;
import biz.arpius.miningtool.app.R;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class CieloAbierto extends FragmentActivity implements OnCheckedChangeListener {
	
	TextView tituloCA = null;
	RadioGroup rdgCA = null;
	RadioButton rb = null;
	EditText edtRCS = null;
	EditText edtRCSEst = null;
	EditText edtVR = null;
	EditText edtRatio = null;
	EditText edtDenMin = null;
	EditText edtDenEst = null;
	EditText edtTranspEst = null;
	EditText edtTranspMineral = null;
	EditText edtPendiente = null;
	Button btnCalcular = null;
	
	public static String MINERAL_IND, METAL, ARIDO;
	public static String M1, M2, M3, M4, M5, M6;
	public static String T1, T2, T3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //para no mostrar la barra de título
		setContentView(R.layout.activity_cielo_abierto);
		
		MINERAL_IND = getString(R.string.mineral_ind);
		METAL = getString(R.string.metal);
		ARIDO = getString(R.string.arido);
		M1 = getString(R.string.m1);
		M2 = getString(R.string.m2);
		M3 = getString(R.string.m3);
		M4 = getString(R.string.m4);
		M5 = getString(R.string.m5);
		M6 = getString(R.string.m6);
		T1 = getString(R.string.t1);
		T2 = getString(R.string.t2);
		T3 = getString(R.string.t3);
		
		tituloCA = (TextView) findViewById(R.id.txtTituloCA);
		rdgCA = (RadioGroup) findViewById(R.id.rdg_ca);
		edtRCS = (EditText) findViewById(R.id.edtRCS);
		edtRCSEst = (EditText) findViewById(R.id.edtRCSEst);
		edtVR = (EditText) findViewById(R.id.edtVR);
		edtRatio = (EditText) findViewById(R.id.edtRatio);
		edtDenMin = (EditText) findViewById(R.id.edtDenMin);
		edtDenEst = (EditText) findViewById(R.id.edtDenEst);
		edtTranspEst = (EditText) findViewById(R.id.edtTranspEst);
		edtTranspMineral = (EditText) findViewById(R.id.edtTranspMineral);
		edtPendiente = (EditText) findViewById(R.id.edtPendiente);
		btnCalcular = (Button) findViewById(R.id.btnCalcular);
		
		Typeface fuente = Typeface.createFromAsset(getAssets(), "tiza.ttf"); //fuente personalizada
		
		tituloCA.setTypeface(fuente);
		btnCalcular.setTypeface(fuente);
		
		rdgCA.setOnCheckedChangeListener(this);	
	}
	
	@Override
	public void onCheckedChanged(RadioGroup rdg, int pos) {
		rb = (RadioButton) findViewById(pos);
        //Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
        
        if( rb.getText().equals( getString(R.string.arido) ) ) { //si es árido desabilitamos las opciones no necesarias
        	edtRCSEst.setText("0");
        	edtRCSEst.setEnabled(false);
        	
        	edtRatio.setText("0");
        	edtRatio.setEnabled(false);
        	
        	edtDenMin.setText("0");
        	edtDenMin.setEnabled(false);
        	
        	edtDenEst.setText("0");
        	edtDenEst.setEnabled(false);
        	
        	edtTranspEst.setText("0");
        	edtTranspEst.setEnabled(false);
        }
        else { //en caso contrario las habilitamos
        	edtRCSEst.setEnabled(true);
        	edtRatio.setEnabled(true);
        	edtDenMin.setEnabled(true);
        	edtDenEst.setEnabled(true);
        	edtTranspEst.setEnabled(true);
        }
	}
	
	public void calcular(View v) {
		
		String arranque = null, arranqueEst = null, carga = null, cargaEst = null, transporte = null, transporteEst = null;

		try {
			//Toast.makeText(this, R.string.arranque, Toast.LENGTH_SHORT).show();
			
			/*Toast.makeText(
					this, 
					Calculos.calcularArranque( Integer.parseInt( edtRCS.getText().toString() ), Integer.parseInt( edtVR.getText().toString() ), 
							rb.getText().toString() ),
					Toast.LENGTH_SHORT
				).show();*/
			
			arranque = Calculos.calcularArranque( 
					Integer.parseInt( edtRCS.getText().toString() ), 
					Integer.parseInt( edtVR.getText().toString() ), 
					rb.getText().toString() );
			
			arranqueEst = Calculos.calcularArranque( 
					Integer.parseInt( edtRCSEst.getText().toString() ), 
					Integer.parseInt( edtVR.getText().toString() ), 
					rb.getText().toString() );
			
			//-----------------------------------------------------------------------------------------------------------------------
			
			//Toast.makeText(this, R.string.carga, Toast.LENGTH_SHORT).show();
			  
			/*Toast.makeText(
					this, 
					Calculos.calcularCarga( Integer.parseInt( edtRCS.getText().toString() ), Integer.parseInt( edtVR.getText().toString() ), 
							rb.getText().toString() ),
					Toast.LENGTH_SHORT
				).show();*/
			
			carga = Calculos.calcularCarga( 
					Integer.parseInt( edtRCS.getText().toString() ), 
					Integer.parseInt( edtVR.getText().toString() ), 
					rb.getText().toString() );
			
			cargaEst = Calculos.calcularCarga( 
					Integer.parseInt( edtRCSEst.getText().toString() ), 
					Integer.parseInt( edtVR.getText().toString() ), 
					rb.getText().toString() );
			
			//-----------------------------------------------------------------------------------------------------------------------
			
			//Toast.makeText(this, R.string.transporte, Toast.LENGTH_SHORT).show();
			  
			/*Toast.makeText(
					this, 
					Calculos.calcularTransporte( Integer.parseInt( edtRCS.getText().toString() ), Integer.parseInt( edtVR.getText().toString() ), 
							Integer.parseInt( edtTranspEst.getText().toString() ), Integer.parseInt( edtPendiente.getText().toString() ),
							rb.getText().toString() ),
					Toast.LENGTH_SHORT
				).show();*/
			
			transporte = Calculos.calcularTransporte( 
					Integer.parseInt( edtRCS.getText().toString() ), 
					Integer.parseInt( edtVR.getText().toString() ),
					Integer.parseInt( edtTranspMineral.getText().toString() ), 
					Integer.parseInt( edtPendiente.getText().toString() ), 
					rb.getText().toString() );
			
			transporteEst = Calculos.calcularTransporte( 
					Integer.parseInt( edtRCSEst.getText().toString() ), 
					Integer.parseInt( edtVR.getText().toString() ),
					Integer.parseInt( edtTranspEst.getText().toString() ),
					Integer.parseInt( edtPendiente.getText().toString() ), 
					rb.getText().toString() );
			
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, R.string.campos_vacios, Toast.LENGTH_SHORT).show();
		}
		
		Intent intent = new Intent(this, Maquinaria.class);
		
		//rellenamos los datos
		Bundle bundle = new Bundle();
		bundle.putString("arranque", arranque);
		bundle.putString("arranqueEst", arranqueEst);
		bundle.putString("carga", carga);
		bundle.putString("cargaEst", cargaEst);
		bundle.putString("transporte", transporte);
		bundle.putString("transporteEst", transporteEst);
		
		//añadimos los datos al intent
		intent.putExtras(bundle);
		
		startActivity(intent);

	}

}
