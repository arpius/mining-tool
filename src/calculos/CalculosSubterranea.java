package calculos;

public class CalculosSubterranea {
	
	public static final String MINERAL_IND = "Mineral industrial";
	public static final String METAL = "Metal";
	public static final String CAMARAS_PILARES = "Cámaras y pilaresl";
	public static final String CAMARAS_ALMACEN = "Cámaras almacén";
	public static final String SUBNIVELES = "Subniveles";
	public static final String CORTE_RELLENO = "Corte y relleno";
	public static final String HUND_SUBNIV = "Hundimiento por subniveles";
	public static final String HUND_BLOQ = "Hundimiento por bloques";
	public static final String FRENTE_LARGO = "Frente largo";
	public static final String M1 = "Jumbo";
	public static final String M2 = "Rozadura puntual";
	public static final String M3 = "LHD";
	public static final String M4 = "Volquete";
	public static final String M5 = "Cinta transportadora";
	public static final String M6 = "Perforadora (Barrenos largos)";
	public static final String M7 = "Perforadora (Abanicos)";
	public static final String M8 = "Rozadora de tajo largo";
	public static final String M9 = "Rozadora continua";
	
	public static String calcularGaleriaPreparacion( int rcs ) {
		
		String maquinaria = null;
		
		if( rcs >= 70) maquinaria = M1;
		else maquinaria = M2;
		
		return maquinaria;
	}
	
	public static String calcularArranque( int rcs, String tipo, String metodo ) {
		
		String maquinaria = null;
		
		if( tipo.trim().equals(METAL) ) {
			
			if( metodo.trim().equals(CAMARAS_PILARES) || metodo.trim().equals(CORTE_RELLENO) ) {
				
				if( rcs >= 70) maquinaria = M1;
				else maquinaria = M2;
				
			}
			else if( metodo.trim().equals(CAMARAS_ALMACEN) ) {
				maquinaria = M6;
			}
			else {
				maquinaria = M7;
			}
			
		}
		else if( tipo.trim().equals(MINERAL_IND) ) {
			
			if( metodo.trim().equals(CAMARAS_PILARES) || metodo.trim().equals(CORTE_RELLENO) ) {
				
				if( rcs >= 70 ) maquinaria = M1;
				else maquinaria = M9;
				
			}
			else if( metodo.trim().equals(CAMARAS_ALMACEN) ) {
				maquinaria = M6;
			}
			else if( metodo.trim().equals(FRENTE_LARGO) ) {
				maquinaria = M8;
			}
			else {
				maquinaria = M7;
			}
			
		}
		
		return maquinaria;
	}
	
	public static String calcularCarga( int rcs, String tipo, String metodo ) {
		
		String maquinaria = null;
		
		if( tipo.trim().equals(METAL) ) {
			
			if( metodo.trim().equals(CAMARAS_PILARES) || metodo.trim().equals(CORTE_RELLENO) ) {
				
				if( rcs >= 70 ) maquinaria = M3;
				else maquinaria = M2;
				
			}
			else {
				maquinaria = M3;
			}
			
		}
		else if( tipo.trim().equals(MINERAL_IND) ) {
			
			if( metodo.trim().equals(CAMARAS_PILARES) || metodo.trim().equals(CORTE_RELLENO) ) {
				
				if( rcs >= 70 ) maquinaria = M3;
				else maquinaria = M9;
				
			}
			else {
				maquinaria = M3;
			}
			
		}
		
		return maquinaria;
	}
	
	public static String calcularTransporte( int rcs, int distTransp, String metodo ) {
		
		String maquinaria = null;
		
		if( metodo.trim().equals(CAMARAS_PILARES) || metodo.trim().equals(CORTE_RELLENO) ) {
			
			if( rcs >= 70) {
				
				if( distTransp >= 300 ) maquinaria = M4;
				else maquinaria = M3;
				
			}
			else {
				maquinaria = M5;
			}
			
		}
		else {
			
			if( distTransp >= 300 ) maquinaria = M4+ " / " +M5;
			else maquinaria = M3;
			
		}
		
		return maquinaria;
	}
	
	public static String calcularRelleno( String metodo ) {
		
		if( metodo.trim().equals(CORTE_RELLENO) ) return M3;
		else return "- - -";
	}
	
}
