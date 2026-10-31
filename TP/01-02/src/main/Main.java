package main;

import util.ACX; // Pour charger les fonctions ACX.tracerRecherche

/*
 * Nom: NESTERENKO
 * Prénom: Dmytro
 * Numéro de groupe: 4
 */

public class Main {
    public static int recherche(int cherche, int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == cherche) {
                return i;
            }
        }
        return -1;
    }

    public static int recherche2(int cherche, int[] t) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] > cherche) {
                return -1;
            }
            if (t[i] == cherche) {
                return i;
            }
        }
        return -1;
    }

    // Les courbes de référence
    // f(x)=x/4500
    public static int refLineaire(int x) {
        // return x / 4500;
        return x / 7142; // 900000 / 126
    }

    // f(x)= log(x)
    public static int refLogarithmique(int x) {
        return (int) Math.log(x);
    }

    public static void main(String[] args) {
        // Ici écrire vos tests.
        int[] tab1 = { 1, 3, 5, 7 };
        int[] tab2 = { 1, 3, 5, 5 };
        int[] tab3 = { 1, 3, 4, 7 };
        int[] tab4 = {};
        int cherche = 5;

        System.out.println("(1) Contient:\n - En cherchant " + cherche
                + " dans tab1, j'obtiens l'index: "
                + recherche(cherche, tab1));

        System.out.println("(2) Contient 2:\n - En cherchant " + cherche
                + " dans tab1, j'obtiens l'index: "
                + recherche(cherche, tab2));

        System.out.println("(3) Ne contient pas:\n - En cherchant " + cherche
                + " dans tab1, j'obtiens l'index: "
                + recherche(cherche, tab3));

        System.out.println("(4) Vide:\n - En cherchant " + cherche
                + " dans tab1, j'obtiens l'index: "
                + recherche(cherche, tab4));

        System.out.println("(5) fn #2:\n - En cherchant " + cherche
                + " dans tab1, j'obtiens l'index: "
                + recherche2(cherche, tab1));

        // Traçage des courbes de temps de calcul
        String[] fonctions = { "recherche", "recherche2" };
        String[] reference = { "refLogarithmique", "refLineaire" };

        ACX.tracerRecherche(fonctions, reference);
    }
}
