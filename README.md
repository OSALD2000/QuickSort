# QuickSort Dutch national flag partitioning
## Algodat Script Folie 212-235

## Sortierung duch partionieren
## ein pivot Element fest legen, alles was kleiner ist kommt auf der Linkeseite und alles was groeßer ist kommt auf der Rechteeseite.

## und somit wird array in zwei partition getrennt und dann rekusiv die zwei teile wieder partionieren solang bis der Index zwischen start und ende der zum partionieren Arrayteil kleiner 50 ist!. Zum Abbruch ende-start < 50, wird der Arrayteil mit Bubblesort sortiert um mehr Performance zu  gewinnen 

