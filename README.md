# Machine à Café Automatique

Ce projet décrit le fonctionnement métier d'une machine à café automatique. Le système permet aux utilisateurs de payer, choisir leur café et recevoir leur boisson.

---

## Flow Fonctionnel

1. **Paiement du client**  
   L’utilisateur insère un moyen de paiement.

2. **Choix du café**  
   L’utilisateur sélectionne un café parmi les options disponibles.

3. **Obtention du café**  
   La machine prépare et délivre le café dans un gobelet.

---

## Contraintes et Erreurs possibles

### 1. Paiement
- `SoldeInsuffisant` : Paiement refusé
- `MoyenDePaiementInvalide`

### 2. Sélection du café
- `CaféIndisponible`
- `PlusDePoudre`
- `RéservoirVide`
- `CoupureÉlectricité`
- `PanneMachine`

### 3. Distribution
- `PlusDeGobelets`
- `BlocageMécanique`
- `ErreurChauffage`

---

## Cas d’usage

- Servir du café à tout client qui paie et fait un choix valide.

---

## Composants principaux

| Composant         | Rôle                                               |
|-------------------|----------------------------------------------------|
| `PaymentProcessor`| Gère la validation du paiement                     |
| `CoffeeSelector`  | Affiche et vérifie les choix de boissons           |
| `CoffeeDispenser` | Prépare et distribue la boisson choisie            |
| `InventoryManager`| Vérifie la disponibilité (eau, café, gobelets)     |
| `ErrorHandler`    | Intercepte les erreurs et affiche des messages     |

---

## Exemple de scénario utilisateur

1. L'utilisateur sélectionne "Expresso"
2. La machine affiche : "Veuillez payer"
3. Paiement validé
4. La machine vérifie les stocks
5. Préparation du café en cours…
6. "Veuillez récupérer votre boisson"
