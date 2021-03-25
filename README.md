# TT1203 README

<img src="https://i.imgur.com/XL4EYHx.png"> </n>
Charge la liste des exercises et affiche leurs images avec **Volley**, **Gson** et **RecyclerView** </n>
Le POC est développé en **Kotlin**, suit une structure **MVVM**, **Single-Activity App** et utilise la **Dependency Injection** avec **Hilt** </n>
Le threading est géré avec **Coroutine**. </n>
Application fonctionnement Best effort : pour les applications à API 21 et plus : si le wifi n'est pas activié, la coroutine va charger la liste depuis les **Shared Preferences** attend en arrière plan l'arrivée du reseau pour lancer la requête Volley.
