<p align="center">
  <h1 align="center">AutoHome</h1>
  <p align="center">Auto Home - Projeto de automação para residencia</p>
</p>

## 1 - Configuração no FireBase. 

- [Adicionar o Firebase ao projeto para Android](https://firebase.google.com/docs/android/setup?hl=pt-br).

## 2 - Configuração no Android Studio: 

- **Gradle/build.gradle(Project)** 
```
...
dependencies {
        classpath 'com.android.tools.build:gradle:3.5.3'
        classpath 'com.google.gms:google-services:4.3.2'
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
 ```

 - [**Gradle/build.gradle(App)**](app/build.gradle).

 ```
 ...
apply plugin: 'com.google.gms.google-services'
apply plugin: 'com.android.application'

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation 'androidx.appcompat:appcompat:1.1.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'com.google.firebase:firebase-auth:19.1.0'
    implementation 'com.google.firebase:firebase-analytics:17.2.0'
}
```