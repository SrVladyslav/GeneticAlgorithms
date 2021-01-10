package proyecto;

import java.util.Random;

import org.opt4j.core.genotype.IntegerGenotype;
import org.opt4j.core.problem.Creator;

public class ProyectoCreator implements Creator<IntegerGenotype>
{
	public IntegerGenotype create(){
		
		/**
		 * Pilla NUM_GRUPOS_TOTAL numeros del 0 al 2 para el genotipo a lo random
		 * correspondiente a la vacuna aplicada
		 * **/
		IntegerGenotype genotipo = new IntegerGenotype(0, Data.NUM_VACUNAS-1);
		genotipo.init(new Random(), Data.NUM_GRUPOS_TOTAL); 	// Array de 13 numeros
		
		return genotipo;
	}
}