package calculos;

import biz.arpius.mineria.CieloAbierto;

public class Calculos {
	
	public static final String MINERAL_IND = CieloAbierto.MINERAL_IND;
	public static final String METAL = CieloAbierto.METAL;
	public static final String ARIDO = CieloAbierto.ARIDO;
	public static final String M1 = CieloAbierto.M1;
	public static final String M2 = CieloAbierto.M2;
	public static final String M3 = CieloAbierto.M3;
	public static final String M4 = CieloAbierto.M4;
	public static final String M5 = CieloAbierto.M5;
	public static final String M6 = CieloAbierto.M6;
	public static final String T1 = CieloAbierto.T1;
	public static final String T2 = CieloAbierto.T2;
	public static final String T3 = CieloAbierto.T3;
	public static boolean esArido = false;
	
	public static String calcularArranque( int rcs, int volReservas, String tipo ) {
		
		String maquinaria = null;
		
		if( tipo.trim().equals(ARIDO) ) esArido = true;
		else esArido = false;
		
		if( tipo.trim().equals(ARIDO) ) {
			
			if( rcs <= 20 ) maquinaria = M2;
			else if( rcs > 20 && rcs < 70 ) maquinaria = M6;
			else maquinaria = M1;
			
		}
		else if( tipo.trim().equals(METAL) ) {
			
			if( rcs <= 20 && volReservas > 30 ) maquinaria = M4;
			else if( rcs <= 20 && volReservas <= 30 ) maquinaria = M2;
			else if( rcs > 20 && rcs < 70 ) maquinaria = M6;
			else maquinaria = M1;
			
		}
		else {
			
			if( rcs < 20 && volReservas > 30 ) maquinaria = M3;
			else if( rcs < 20 && volReservas <= 30 ) maquinaria = M2;
			else if( rcs > 20 && rcs < 70 ) maquinaria = M6;
			else maquinaria = M1;
			
		}
		
		return maquinaria;
	}
	
	public static String calcularCarga( int rcs, int volReservas, String tipo ) {
		
		String maquinaria = null;
		
		if( tipo.trim().equals(ARIDO) ) esArido = true;
		else esArido = false;
		
		if( tipo.trim().equals(ARIDO) ) {
			maquinaria = M2+ " / " +M5;
		}
		else if( tipo.trim().equals(METAL) ) {
			
			if( volReservas <= 30 ) {
				
				if( rcs <= 20 ) maquinaria = M2;
				else maquinaria = M2+ " / " +M5;
				
			}
			else {
				maquinaria = M4;
			}
			
		}
		else {
			
			if( volReservas > 30 ) {
				
				if( rcs <= 20 ) maquinaria = M3;
				else maquinaria = M4;
				
			}
			else {
				maquinaria = M2;
			}

		}
		
		return maquinaria;
	}
	
	public static String calcularTransporte( int rcs, int volReservas, int distTransp, int pendiente, String tipo ) {
		
		String maquinaria = null;
		
		if( tipo.trim().equals(ARIDO) ) esArido = true;
		else esArido = false;
		
		if( tipo.trim().equals(ARIDO) ) {
			
			if( distTransp >= 3000 ) {
				maquinaria = T1;
			}
			else {
				
				if( pendiente >= 12 ) maquinaria = T1;
				else maquinaria = T2;
				
			}
			
		}
		else if( tipo.trim().equals(METAL) ) {
			
			if( distTransp >= 3000 ) {
				maquinaria = T1;
			}
			else {
				
				if( pendiente >= 12 ) maquinaria = T1;
				else maquinaria = T3;
				
			}
			
		}
		else if( tipo.trim().equals(MINERAL_IND) ) {
			
			if( volReservas > 30 ) {
				
				if( rcs < 20 ) {
					maquinaria = T1;
				}
				else {
					
					if( distTransp >= 3000 ) {
						maquinaria = T1;
					}
					else {
						
						if( pendiente >= 12 ) maquinaria = T1;
						else maquinaria = T3;
						
					}
					
				}
				
			}
			else {
				
				if( distTransp >= 3000 ) {
					maquinaria = T1;
				}
				else {
					
					if( pendiente >= 12 ) maquinaria = T1;
					else maquinaria = T3;
					
				}
				
			}
			
		}
		
		return maquinaria;
	}
	
}
