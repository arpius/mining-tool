package biz.arpius.acercade;

import utilidades.TextViewEx;
import biz.arpius.miningtool.R;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class AcercaDe extends FragmentActivity {
	
	TextView tituloAD = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //para no mostrar la barra de título
		setContentView(R.layout.activity_acerca_de);
		
		tituloAD = (TextView) findViewById(R.id.txtTituloAcercaDe);
		
		TextViewEx textoJustificado = (TextViewEx) findViewById(R.id.txtContenidoAcercaDe);
		textoJustificado.setText(getString(R.string.contenido_acerca_de), true);
		
		Typeface fuente = Typeface.createFromAsset(getAssets(), "tiza.ttf"); //fuente personalizada
		
		tituloAD.setTypeface(fuente);
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	public void mostrarTwitter(View v) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW, 
							Uri.parse("https://twitter.com/MiningTool") );
		startActivity(i);
	}
	
	public void mostrarGithub(View v) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW, 
							Uri.parse("https://github.com/arpius") );
		startActivity(i);
	}

	public void enviarCorreo(View v) {
		String[] to = {"miningtool.app@gmail.com"};
        String[] cc = {"amurriokoa@gmail.com"};
        
        mandarEmail( 
        		to, 
        		cc );
	}
	
	private void mandarEmail( String[] direccion, String[] cc ) {
        Intent i = new Intent(Intent.ACTION_SEND);
        
        i.setData( Uri.parse("mailto:") );
        i.putExtra(Intent.EXTRA_EMAIL, direccion);
        i.putExtra(Intent.EXTRA_CC, cc);
        i.setType("message/rfc822");
        
        startActivity( Intent.createChooser(i, "Email") );
    }
}
