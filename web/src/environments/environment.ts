// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  apiBase: "http://localhost:8080",
  firebase: {
    apiKey: "AIzaSyCTF2ftyL3fjJwKWod0OYwrWo_jPuwiL9o",
    authDomain: "card-game-sofka.firebaseapp.com",
    projectId: "card-game-sofka",
    storageBucket: "card-game-sofka.appspot.com",
    messagingSenderId: "183741757287",
    appId: "1:183741757287:web:1270c4d0325b09e912e1c2"
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
