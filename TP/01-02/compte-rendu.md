---
title: "Compte-rendu sur TP1 et 2"
author: "Dmytro NESTERENKO (Groupe 4)"
lang: fr
mainfont: "Libertinus Serif"
fontsize: 13pt
margin:
  x: 1.5cm
  top: 0.5cm
  bottom: 1cm
page-numbering: ""
---

**Question 1** : La fonction `recherche` prend deux paramètres de types respectifs `int` et `int[]` (nommés `cherche` et `t`). Si elle trouve la valeur recherchée, elle renvoie son indice, sinon elle renvoie `-1` par défaut.

**Question 2** : La fonction parcourt le tableau donné afin de trouver l'élément recherché (`cherche`). Elle procède en itérant sur le tableau et en comparant chaque élément à la valeur recherchée, elle renvoie son indice en cas de succès.

**Question 3** : J'ai suivi le conseil de supposer que le tableau était trié. En conséquence, si le tableau est trié, ses valeurs sont positionnées par ordre croissant, de la plus petite à la plus grande. Ainsi, j'ai ajouté une condition `if` qui vérifie si l'élément actuel est plus grand que la valeur recherchée et qui, lorsqu'elle est vraie, renvoie `-1`, ce qui indique l'absence de l'élément cherché. En effet, si c'est le cas, cela signifie que la valeur recherchée ne peut pas être dans le tableau, car si elle y était, elle aurait été trouvée avant, puisque le tableau est trié. Cela améliore l'efficacité de la recherche, car nous n'avons pas besoin de vérifier systématiquement chaque élément. Toutefois, il est impossible d'éviter cette situation dans le pire des cas, par exemple lorsque la valeur recherchée correspond au dernier élément du tableau.

**Question 4** :

```java
refLineaire(x) = x / 7142; // nbElemDansLeTableau / temps = 900000 / 126
refLogarithmique(x) = log(x);
```

Les courbes se rapprochaient davantage d'une fonction de référence linéaire que de la fonction logarithmique ; je les ai alignées en modifiant la constante.

Selon l'algorithme, la fonction vérifie chaque élément : dans le pire des cas, elle vérifie tous les éléments. Les deux fonctions ont donc une complexité linéaire `O(n)`.

```{=typst}
#align(center, image("doc/visu_success.png", width: 50%))
```
