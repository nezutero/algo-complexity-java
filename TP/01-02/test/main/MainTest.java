package main;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import pourDebug.PourDebug;
import util.ACX;

public class MainTest {

    // Main.recherche
    @Test
    public void recherche_absent() {
        int[] t = { 2, 3, 4, 7, 8 };
        int resultatRecherche = Main.recherche(5, t);
        assertEquals(-1, resultatRecherche);
    }

    @Test
    public void recherche_doublons() {
        int[] t = { 2, 2, 5, 5, 8 };
        int resultatRecherche = Main.recherche(5, t);
        assertEquals(2, resultatRecherche);
    }

    @Test
    public void recherche_vide() {
        int[] t = {};
        int resultatRecherche = Main.recherche(5, t);
        assertEquals(-1, resultatRecherche);
    }

    // Main.recherche2 (tableau trié)

    @Test
    public void recherche2_present() {
        int[] t = { 2, 3, 5, 7, 8 };
        int resultatRecherche = Main.recherche2(5, t);
        assertEquals(2, resultatRecherche);
    }

    @Test
    public void recherche2_absent() {
        int[] t = { 2, 3, 4, 7, 8 };
        int resultatRecherche = Main.recherche2(5, t);
        assertEquals(-1, resultatRecherche);
    }

    @Test
    public void recherche2_doublons() {
        int[] t = { 2, 2, 5, 5, 8 };
        int resultatRecherche = Main.recherche2(5, t);
        assertEquals(2, resultatRecherche);
    }

    @Test
    public void recherche2_vide() {
        int[] t = {};
        int resultatRecherche = Main.recherche2(5, t);
        assertEquals(-1, resultatRecherche);
    }

    // PourDebug.recherche

    @Test
    public void pdRecherche_present() {
        int[] t = { 2, 3, 5, 7, 8 };
        int resultatRecherche = PourDebug.recherche(5, t);
        assertEquals(2, resultatRecherche);
    }

    @Test
    public void pdRecherche_absent() {
        int[] t = { 2, 3, 4, 7, 8 };
        int resultatRecherche = PourDebug.recherche(5, t);
        assertEquals(-1, resultatRecherche);
    }

    @Test
    public void pdRecherche_doublons() {
        int[] t = { 2, 2, 5, 5, 8 };
        int resultatRecherche = PourDebug.recherche(5, t);
        assertEquals(2, resultatRecherche);
    }

    @Test
    public void pdRecherche_vide() {
        int[] t = {};
        int resultatRecherche = PourDebug.recherche(5, t);
        assertEquals(-1, resultatRecherche);
    }

    // PourDebug.recherche2

    @Test
    public void pdRecherche2_doublons() {
        int[] t = { 2, 2, 5, 5, 8 };
        int resultatRecherche = PourDebug.recherche2(5, t);
        assertEquals(2, resultatRecherche);
    }

    @Test
    public void pdRecherche2_vide() {
        int[] t = {};
        int resultatRecherche = PourDebug.recherche2(5, t);
        assertEquals(-1, resultatRecherche);
    }

    @Test
    public void pdRecherche2_tailleUn() {
        int[] t = { 7 };
        int resultatRecherche = PourDebug.recherche2(7, t);
        assertEquals(0, resultatRecherche);
    }

    @Test
    public void pdRecherche2_dernierSeul() {
        int[] t = { 1, 2, 3, 4, 9 };
        int resultatRecherche = PourDebug.recherche2(9, t);
        assertEquals(4, resultatRecherche);
    }

    // generer aleatoirement des tests
    // Main.recherche
    @Test
    public void recherche_aleatoire() {
        for (int i = 0; i < 1000; i++) {
            int n = ACX.genererEntierAleatoire(0, 20);
            int[] t = ACX.genererTableauAleatoire(n, 0, 10);
            int cherche = ACX.genererEntierAleatoire(0, 10);

            int resultatRecherche = Main.recherche(cherche, t);

            if (resultatRecherche == -1) {
                for (int j = 0; j < t.length; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            } else {
                assertEquals(cherche, t[resultatRecherche]);
                for (int j = 0; j < resultatRecherche; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            }
        }
    }

    // Main.recherche2
    @Test
    public void recherche2_aleatoire() {
        for (int i = 0; i < 1000; i++) {
            int n = ACX.genererEntierAleatoire(0, 20);
            int[] t = ACX.genererTableauAleatoire(n, 0, 10);
            // Précondition : t est trié par ordre croissant, donc on trie
            Arrays.sort(t);
            int cherche = ACX.genererEntierAleatoire(0, 10);

            int resultatRecherche = Main.recherche2(cherche, t);

            if (resultatRecherche == -1) {
                for (int j = 0; j < t.length; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            } else {
                assertEquals(cherche, t[resultatRecherche]);
                for (int j = 0; j < resultatRecherche; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            }
        }
    }

    // pourDebug.recherche
    @Test
    public void pdRecherche_aleatoire() {
        for (int i = 0; i < 1000; i++) {
            int n = ACX.genererEntierAleatoire(0, 20);
            int[] t = ACX.genererTableauAleatoire(n, 0, 10);
            int cherche = ACX.genererEntierAleatoire(0, 10);

            int resultatRecherche = PourDebug.recherche(cherche, t);

            if (resultatRecherche == -1) {
                for (int j = 0; j < t.length; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            } else {
                assertEquals(cherche, t[resultatRecherche]);
                for (int j = 0; j < resultatRecherche; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            }
        }
    }

    // pourDebug.recherche2
    @Test
    public void pdRecherche2_aleatoire() {
        for (int i = 0; i < 1000; i++) {
            int n = ACX.genererEntierAleatoire(0, 20);
            int[] t = ACX.genererTableauAleatoire(n, 0, 10);
            int cherche = ACX.genererEntierAleatoire(0, 10);

            int resultatRecherche = PourDebug.recherche2(cherche, t);

            if (resultatRecherche == -1) {
                for (int j = 0; j < t.length; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            } else {
                assertEquals(cherche, t[resultatRecherche]);
                for (int j = 0; j < resultatRecherche; j++) {
                    assertNotEquals(cherche, t[j]);
                }
            }
        }
    }

    @Test
    public void recherche2_commeRecherche() {
        for (int i = 0; i < 1000; i++) {
            int n = ACX.genererEntierAleatoire(0, 20);
            int[] t = ACX.genererTableauAleatoire(n, 0, 10);
            Arrays.sort(t);
            int cherche = ACX.genererEntierAleatoire(0, 10);

            int resultat1 = Main.recherche(cherche, t);
            int resultat2 = Main.recherche2(cherche, t);

            assertEquals(resultat1, resultat2);
        }
    }
}
