package org.afrivera.genericsclass;

public class EjemploGenerico {
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Tiro al Blanco", "Caballo"));
        transporteCaballos.add(new Animal("Veloz", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);

        System.out.println("=".repeat(40));

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        System.out.println("=".repeat(40));
        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);
    }

    public static <T> void imprimirCamion(Camion<T> camion){
        for (T a: camion){
            if(a instanceof Animal){
                System.out.println(((Animal)a).getNombre() + " Tipo: " + ((Animal)a).getTipo());
            } else if(a instanceof Maquinaria){
                System.out.println(((Maquinaria)a).getTipo());
            } else if( a instanceof Automovil){
                System.out.println(((Automovil)a).getMarca());
            }
        }
    }
}
