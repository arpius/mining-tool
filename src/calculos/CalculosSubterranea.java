package calculos;

import biz.arpius.mineria.Subterranea;

public class CalculosSubterranea {
	
	public static final String MINERAL_IND = Subterranea.MINERAL_IND;
	public static final String METAL = Subterranea.METAL;
	public static final String CAMARAS_PILARES = Subterranea.CAMARAS_PILARES;
	public static final String CAMARAS_ALMACEN = Subterranea.CAMARAS_ALMACEN;
	public static final String SUBNIVELES = Subterranea.SUBNIVELES;
	public static final String CORTE_RELLENO = Subterranea.CORTE_RELLENO;
	public static final String HUND_SUBNIV = Subterranea.HUND_SUBNIV;
	public static final String HUND_BLOQ = Subterranea.HUND_BLOQ;
	public static final String FRENTE_LARGO = Subterranea.FRENTE_LARGO;
	public static final String M1 = Subterranea.M1;
	public static final String M2 = Subterranea.M2;
	public static final String M3 = Subterranea.M3;
	public static final String M4 = Subterranea.M4;
	public static final String M5 = Subterranea.M5;
	public static final String M6 = Subterranea.M6;
	public static final String M7 = Subterranea.M7;
	public static final String M8 = Subterranea.M8;
	public static final String M9 = Subterranea.M9;
	
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
