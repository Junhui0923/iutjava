import numpy

def recupererMatrice(chemin) :
    fichier=open(chemin, "r")
    contenu=fichier.readlines()
    lignes=0
    colonnes=0
    
    tableau=[]
    
    for ligne in contenu :
        listeNombre=str((ligne).replace('\n', '')).split('\t')
        for nombre in listeNombre :
            tableau.append(float(nombre))
            
        colonnes=len(listeNombre)
        lignes+=1
    
    fichier.close()
    
    return lignes, colonnes, tableau

lignes, colonnes, matriceListe=recupererMatrice("C:/Users/hakim.assous/Downloads/Donnees.txt")
matrice=numpy.array(matriceListe).reshape(lignes, colonnes)
print(type(matrice))
