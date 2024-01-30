# TP : cadeaux de noel
--------
__Etape 1__  
Créer un nouveau projet SpringBoot configuré pour créer une API REST
et se connecter à postgreSQL  

__Etape 2__  
Créer une Entity Cadeau : nom, description, prix  

__Etape 3__  
Créer un repository pour sauvegarder et lire des cadeaux dans la base  
__Etape 4__  
Tester votre repository avec un JUnit  
__Etape 5__  
Créer un Service avec les méthodes pour:
ajouter un cadeau en base et récupérer les cadeaux en base  
__Etape 6__  
Tester dans un nouveau fichier Junit
les méthodes du Service  
__Etape 7__  
Créer un Controller pour avoir une API REST
avec les routes suivantes:  
GET /cadeaux  
POST /cadeaux  
GET /cadeaux/{id}  
DELETE /cadeaux/{id}   
__Etape 8__
Tester manuellement votre API avec une client HTTP  
__Etape 9__  
Créer un Entity ListeCadeau (nom, ..)
et le repository correspondant (modifié)
Dans entity Cadeau rajouter un attribut :
listeCadeau avec un ManyToOne  
Dans l’API, quand in affiche un cadeau il faudra
afficher à quelle liste il appartient  
__Etape 10__  
On ne veut pas voir l’id dans le JSON
trouvez une solution pour le cacher et ajouter le symbole
€ lors de l’affichage du prix.  