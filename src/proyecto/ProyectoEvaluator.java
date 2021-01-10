package proyecto;

import java.util.ArrayList;

import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Evaluator;

public class ProyectoEvaluator implements Evaluator<ArrayList<Integer>>
{
	public Objectives evaluate(ArrayList<Integer> fenotipo) {
		//VARIABLE QUE GUARDA EL COSTE TOTAL DE CADA UNA DE LAS VACUNAS
		//{VACUNA 1, VACUNA 2, VACUNA 3}
		int costeFinalIndividual [] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		/*
		for(int i = 0; i < fenotipo.size(); i++) {
			for(int j = 0; j < costeFinalIndividual.length; j++) {
				//COMPRUEBO QUE EL VALOR I DEL FENOTIPO SEA MENOR QUE EL QUE LE CORRESPONDE EN
				//LA 
				if(fenotipo.get(i) <= Data.arrayVoluntarios[i] && costeFinalIndividual[j] != Integer.MAX_VALUE) {
					costeFinalIndividual[j] += Data.matrizCostes[j][i]*fenotipo.get(i);
				}
				else {
					//EN CASO DE QUE SEA MAYOR EL VALOR DEL GENOTIPO QUE EL QUE LE CORRESPONDE
					//DE arrayVoluntarios LE ASIGNAMOS UN NUMERO MUY ALTO PARA QUE SEA UNA MALA
					//OPCION USARLA.
					//costeFinalIndividual[j] = (int) Math.pow(10, 5);
					costeFinalIndividual[j] = Integer.MAX_VALUE;
					//break;
				}
				
			}
			
		}*/
		
		//VAMOS A PONER OBJETIVOS A LOS CUALES VAMOS A ASPIRAR
		Objectives objectives = new Objectives();
		
		int costeTotal = 0;
		for(int i= 0; i < fenotipo.size(); i++) {
			System.out.print("Puta:");
			costeFinalIndividual[i] = Data.matrizCostes[fenotipo.get(i)][i] * Data.arrayVoluntarios[i];
			
			// CALCULAMOS EL TOTAL QUE NOS VA A COSTAR LA COMBINACION DE VACUNAS 1 + VACUNAS 2 + VACUNAS 3 A LO LARGO DE LOS FENOTIPOS
			costeTotal += costeFinalIndividual[i];
			
			if(fenotipo.get(i) == 1 || fenotipo.get(i) == 0) {
				objectives.add("Maximizamos el grupo "+ i, Sign.MAX, costeFinalIndividual[i]);
			}
		}
		
		//OBJETIVO MINIMIZAR EL COSTE TOTAL
		objectives.add("MINIMIZAMOS EL COSTE TOTAL", Sign.MIN, Math.abs(Data.MEJOR_RESULTADO - costeTotal));
		
		//MAXIMIZAMOS EL USO LAS VACUNAS 1
		//objectives.add("MAXIMIZAMOS USO VACUNA 1", Sign.MAX, costeFinalIndividual[0]);
		
		//MAXIMIZAMOS EL USO LAS VACUNAS 1
		//objectives.add("MAXIMIZAMOS USO VACUNA 2", Sign.MAX, costeFinalIndividual[1]);

		return objectives;
	}
}