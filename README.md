# TT1203 README

<img src="https://i.imgur.com/XL4EYHx.png"> 
Charge la liste des exercises et affiche leurs images avec **Volley**, **Gson** et **RecyclerView**
Le POC est développé en **Kotlin**, suit une structure **MVVM**, **Single-Activity App** et utilise la **Dependency Injection** avec **Hilt**
Le threading est géré avec **Coroutine**, la coroutine attend en arrière plan l'arrivé du reseau pour lancer la requête Volley.
Note : L'application est compatible jusqu'à API 19. Toutefois, l'attente du reseau n'est actuellement pas gérée sous API 19, la requête Volley se fera au lancement de l'app.
