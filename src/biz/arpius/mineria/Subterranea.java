package biz.arpius.mineria;

import calculos.CalculosSubterranea;
import biz.arpius.miningtool.R;
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
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Subterranea extends FragmentActivity implements OnCheckedChangeListener {
	
	TextView tituloSubte = null;
	RadioGroup rdgSubte = null;
	RadioGroup rdgMetodo = null;
	RadioButton rb = null;
	RadioButton rbFL = null;
	EditText edtRCS = null;
	EditText edtVR = null;
	EditText edtProd = null;
	EditText edtDenMin = null;
	EditText edtTranspMineral = null;
	Button btnCalcular = null;
	String tipo = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //para no mostrar la barra de título
		setContentView(R.layout.activity_subterranea);
		
		tituloSubte = (TextView) findViewById(R.id.txtTituloSubte);
		rdgSubte = (RadioGroup) findViewById(R.id.rdg_subte);
		rdgMetodo = (RadioGroup) findViewById(R.id.rdg_metodo);
		rbFL = (RadioButton) findViewById(R.id.rbFL);
		edtRCS = (EditText) findViewById(R.id.edtRCS);
		edtVR = (EditText) findViewById(R.id.edtVR);
		edtProd = (EditText) findViewById(R.id.edtProd);
		edtDenMin = (EditText) findViewById(R.id.edtDenMin);
		edtTranspMineral = (EditText) findViewById(R.id.edtTranspMineral);
		btnCalcular = (Button) findViewById(R.id.btnCalcular);
		
		Typeface fuente = Typeface.createFromAsset(getAssets(), "tiza.ttf"); //fuente personalizada
		
		tituloSubte.setTypeface(fuente);
		btnCalcular.setTypeface(fuente);
		
		rdgSubte.setOnCheckedChangeListener(this);
		rdgMetodo.setOnCheckedChangeListener(this);
	}

	@Override
	public void onCheckedChanged(RadioGroup rdg, int pos) {
		rb = (RadioButton) findViewById(pos);
        //Toast.makeText(this, rb.getText(), Toast.LENGTH_SHORT).show();
        
        if( rb.getText().equals( getString(R.string.metal) ) ) { //si es metal desabilitamos la opción de frente largo
        	rbFL.setEnabled(false);
        	tipo = rb.getText().toString();
        }
        else if( rb.getText().equals( getString(R.string.mineral_ind) ) ) { //en caso contrario la habilitamos
        	rbFL.setEnabled(true);
        	tipo = rb.getText().toString();
        }
	}
	
	public void calcular(View v) {
		
		String galeriaPrep = null, arranque = null, carga = null, transporte = null, relleno = null;

		try {
			
			galeriaPrep = CalculosSubterranea.calcularGaleriaPreparacion(
						Integer.parseInt( edtRCS.getText().toString() )
					);
			
			//-----------------------------------------------------------------------------------------------------------------------
			
			arranque = CalculosSubterranea.calcularArranque(
					Integer.parseInt( edtRCS.getText().toString() ), 
					tipo, 
					rb.getText().toString() );
			
			//-----------------------------------------------------------------------------------------------------------------------
			
			carga = CalculosSubterranea.calcularCarga(
					Integer.parseInt( edtRCS.getText().toString() ), 
					tipo, 
					rb.getText().toString() );
			
			//-----------------------------------------------------------------------------------------------------------------------
			
			transporte = CalculosSubterranea.calcularTransporte(
					Integer.parseInt( edtRCS.getText().toString() ), 
					Integer.parseInt( edtTranspMineral.getText().toString() ), 
					rb.getText().toString() );
			
			//-----------------------------------------------------------------------------------------------------------------------
			
			relleno = CalculosSubterranea.calcularRelleno( rb.getText().toString() );
			
		} catch (Exception e) {
			e.printStackTrace();
			Toast.makeText(this, R.string.campos_vacios, Toast.LENGTH_SHORT).show();
		}
		
		Intent intent = new Intent(this, MaquinariaSubterranea.class);
		
		//rellenamos los datos
		Bundle bundle = new Bundle();
		bundle.putString("galeriaPrep", galeriaPrep);
		bundle.putString("arranque", arranque);
		bundle.putString("carga", carga);
		bundle.putString("transporte", transporte);
		bundle.putString("relleno", relleno);
		
		//añadimos los datos al intent
		intent.putExtras(bundle);
		
		startActivity(intent);

	}

}
