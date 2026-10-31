package pourDebug;

public class PourDebug {

    // Recherche qui sort de la boucle dès que l'index est trouvé
    public static int recherche(int cherche, int[] t) {
        boolean trouve = false;
        int index = -1; // err #1 : l'index doit être égal à -1 par défaut, selon les tests
        int i = 0;
        while (i < t.length && !trouve) {
            if (t[i] == cherche) { // la syntaxe n'était pas propre : les « {} » manquaient
                index = i;
                trouve = true; // se trouvait en dehors
                               // du « if » (provoquait la sortie de la boucle dans tous les cas)
            }
            i = i + 1; // incrémenter après, pour ne pas sauter l'index 0
        }
        return index;
    }

    // Recherche qui consulte 2 cases du tableau en même temps
    public static int recherche2(int cherche, int[] t) {
        // i < t.length == i <= t.length - 1 != i < t.length - 1
        // i < t.length - 1 : c'est comme soustraire 2 éléments, lorsqu'il faut soustraire le dernier
        for (int i = 0; i < t.length; i += 2) {
            if (t[i] == cherche) {
                return i; // on renvoie toujours "i" et ignorons le "i+1" cas
            }
            // missing check
            // avoiding getting out of bounds
            if (i + 1 < t.length && t[i + 1] == cherche) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Sur recherche, 3 bugs à trouver
        System.out.println("recherche");
        int[] t1 = { 1, 2, 3 };

        // Si l'élément cherché n'est pas dans le tableau
        // return -1
        int i = recherche(4, t1);
        System.out.println(i);

        // Si l'élément cherché est dans le tableau mais pas le premier
        // return its index
        int j = recherche(3, t1);
        System.out.println(j);

        // Si l'élément cherché est le premier du tableau il n'est même pas
        // visité
        // fixed
        int k = recherche(1, t1);
        System.out.println(k);

        // Sur recherche2, 2 bugs à trouver
        System.out.println("recherche2");

        int l = recherche2(3, t1);
        System.out.println(l);

        int m = recherche2(2, t1);
        System.out.println(m);

    }
}
