package practica01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SplittableRandom;

public class RadixSortEjerc
{
    public static void radixSort(int []arr)
    {
        // Convierto el array(en int) a un array de strings
        String sArr[] = StringUtil.toStringArray(arr);

        //Normalizamos el array de string completando de 0
        StringUtil.lNormalize(sArr, '0');

        // creamos un hashmap de tipo arrayList de indice de integer y valor de tipo arrayList
        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();

        // Inicio una variable con la cant digitos de la posicion 0 (longitud)
        int digitos = sArr[0].length();

        //
        for (int i=0; i<digitos;i++){
            // agrego 10 entradas de 0 a 9 con arrayList vacios
            iniciarHm(hm);

            // Inicio una variable con los digitos -1 - la posicion del for
            int posDigito = digitos-1-i;
            for (int j=0; j< sArr.length;j++){

                // Donde asignamos c/ posicion como charAt con 0 para que no lo contemple
                int d = sArr[j].charAt(posDigito)-'0';

                // la posicion d le agregamos la posicion j del array de tipo string (sArr)
                hm.get(d).add(sArr[j]);
            }

            //
            rearmarArr(sArr,hm);
        }
        int iArr[] = StringUtil.toIntArray(sArr);
        for (int x=0; x<iArr.length; x++){
            arr[x] = iArr[x];
        }

    }

    // Se rearma el metodo hashmap
    private static void rearmarArr(String[] sArr, HashMap<Integer, ArrayList<String>> hm ) {
        int k = 0;
        for (int i=0; i<10 ; i++){

            // le asigno c/ posicion del hashmap
            ArrayList<String> x = hm.get(i);
            for(int j=0; j < x.size();j++){

                // asiganmos de c/ posicion del array de string la posicion de j
                sArr[k++] = x.get(j);
            }
        }
    }

    private static void iniciarHm(HashMap<Integer, ArrayList<String>> hm ) {
        hm.clear();
        for (int i=0;i <10;i++){
            hm.put(i, new ArrayList<>());

        }
    }

    public static void main(String[] args)
    {
        int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
        radixSort(arr);

        for(int i=0; i<arr.length;i++)
        {
            System.out.println(arr[i]+(i<arr.length-1?",":""));
        }

    }
}

