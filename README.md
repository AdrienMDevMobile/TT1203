# TT1203 README

<img src="https://i.imgur.com/XL4EYHx.png"> 
Charge la liste des exercises et affiche leurs images avec **Volley**, **Gson** et **RecyclerView**
Le POC est développé en **Kotlin**, suit une structure **MVVM**, **Single-Activity App** et utilise la **Dependency Injection** avec **Hilt**
Le threading est géré avec **Coroutine**.
Application fonctionnement Best effort : pour les applications à API 21 et plus : si le wifi n'est pas activié, la coroutine va charger la liste depuis les **Shared Preferences** attend en arrière plan l'arrivé du reseau pour lancer la requête Volley.