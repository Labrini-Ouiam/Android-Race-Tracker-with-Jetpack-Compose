# 🏁 Android Race Tracker with Jetpack Compose

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-blue.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.5.0-brightgreen)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-Apache%202.0-orange.svg)](https://opensource.org/licenses/Apache-2.0)

Une application Android interactive de **course entre deux joueurs**, développée avec les dernières technologies Kotlin et Jetpack Compose.

<p align="center">
  <img src="https://github.com/user-attachments/assets/f7a34075-8d49-426c-ade4-967c55343bad" width="300" />
</p>


---

## ✨ Fonctionnalités

- 🚀 **Deux participants** progressant en parallèle avec suivi en temps réel
- ⚡ Utilisation des **coroutines** Kotlin pour une gestion fluide des délais
- 🎨 Interface basée sur **Material 3**, entièrement personnalisable
- 🔄 Boutons **Start / Pause / Reset** pour contrôler la course
- 📊 Barres de progression animées avec effet visuel

---

## 🛠️ Technologies

- ✅ **100% Kotlin**
- ✅ **Jetpack Compose** (UI déclarative)
- ✅ **Kotlin Coroutines** pour les opérations asynchrones
- ✅ **Material Design 3** pour une interface moderne
- ✅ Architecture propre avec **State Hoisting**

---

## ⚙️ Installation

1. **Cloner le dépôt :**
   ```bash
   git clone https://github.com/Labrini-Ouiam/Android-Race-Tracker-with-Jetpack-Compose.git
   ```
2. **Ouvrir dans Android Studio** (version *Hedgehog* ou plus récente recommandée)
3. **Compiler et exécuter** sur un émulateur ou appareil (API 26+)

---

## 📁 Structure du projet

```
/com.example.racetracker
├── ui/
│   ├── RaceParticipant.kt     # Logique des coureurs
│   └── RaceTrackerApp.kt      # Composants principaux
├── theme/
│   ├── Color.kt               # Couleurs personnalisées
│   └── Theme.kt               # Thème Material 3
└── MainActivity.kt            # Point d'entrée de l'app
```

---

## 🎨 Personnalisation

Pour ajuster la vitesse ou le comportement d’un joueur, modifie dans `RaceTrackerApp.kt` :

```kotlin
RaceParticipant(
    name = "Player 1",
    progressIncrement = 1,           // Vitesse de progression
    progressDelayMillis = 300L       // Fréquence de mise à jour
)
```

---

## 📄 Licence

```
Copyright 2023 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
```

> Fichier complet disponible dans `LICENSE`

---

## 👏 Contributeur

- [Labrini Ouiam](https://github.com/Labrini-Ouiam)

---

## 🔖 Recommandations

- IDE : **Android Studio Hedgehog** ou plus récent
- SDK : **API 26+**
- Kotlin : **1.9.0+**
- Jetpack Compose : **1.5.0+**

---

## 📷 Capture d’écran

Ajoute une image nommée `screenshot.png` dans la racine du projet pour illustrer ton app.

---

## 📂 Fichiers recommandés

- `LICENSE` → pour la licence Apache 2.0 :
  ```bash
  curl https://www.apache.org/licenses/LICENSE-2.0.txt > LICENSE
  ```
- `.gitignore` → généré automatiquement par Android Studio
- `screenshot.png` → capture d’écran principale

---

> ✨ N’hésite pas à étoiler le projet si tu le trouves utile ! ⭐
