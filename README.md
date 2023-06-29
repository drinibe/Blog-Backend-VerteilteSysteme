<<<<<<< HEAD
# Blog-Projekt-Valdrin_VS
Im Rahmen meines Studiums an der HFTM wurde ich beauftragt, ein Blog-System zu entwickeln. Dieses Projekt begleitet mich während des Studiums und erfordert sowohl Unterricht als auch Selbststudium zu Hause. Weitere Informationen dazu werden folgen mit dem Themeninhalt:

- Informationen darüber, wie das Projekt installiert wird und welche Abhängigkeiten erforderlich sind  
- Eine Liste der Hauptfunktionen und -fähigkeiten des Projekts     
- Eine Anleitung zum Beitritt und zur Zusammenarbeit mit dem Projekt     
- Lizenzinformationen und Haftungsausschlüsse

# Anweisungen zum Ausführen des Projekts:
Um die Software auszuführen, musst du im Visual Studio Code im Terminal folgenden Befehl eingeben: ./mvnw quarkus:dev.
Anschließend kannst du deinen Webbrowser öffnen und diese Links eingeben:

    Begrüßung: [Begrüssungs-Link](http://www.localhost:8080/hello)
    Blog: [Blog-Link](http://www.localhost:8080/blog)

# API-Spezifikation
- [Meine Blog-API-Spezifikationen](.github\docs\API_Designe.md)




=======
# backend-blog

Dieses Projekt verwendet Quarkus, das Supersonic Subatomic Java Framework.

Wenn Sie mehr über Quarkus erfahren möchten, besuchen Sie bitte die Website: https://quarkus.io/.

## Die Anwendung im Entwicklungsmodus ausführen

Sie können Ihre Anwendung im Entwicklungsmodus ausführen, der Live-Coding ermöglicht, indem Sie Folgendes verwenden:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

Die Anwendung kann mithilfe von verpackt werden:
```shell script
./mvnw package
```
Es wird die Datei quarkus-run.jar im Verzeichnis target/quarkus-app/ erzeugt.
Beachten Sie, dass es sich nicht um ein über-jar handelt, da die Abhängigkeiten in das Verzeichnis target/quarkus-app/lib/ kopiert werden.

Die Anwendung kann jetzt mit java -jar target/quarkus-app/quarkus-run.jar ausgeführt werden.

Wenn Sie ein über-jar erstellen möchten, führen Sie den folgenden Befehl aus:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

Die Anwendung, die als über-jar verpackt wurde, kann jetzt mit java -jar target/*-runner.jar ausgeführt werden.

## Creating a native executable

Sie können eine native ausführbare Datei erstellen, indem Sie Folgendes verwenden:
```shell script
./mvnw package -Pnative
```

Alternativ, wenn Sie GraalVM nicht installiert haben, können Sie den nativen Ausführungsbau in einem Container ausführen, indem Sie Folgendes verwenden:
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

Sie können Ihre native ausführbare Datei dann mit ./target/backend-blog-0.0.1-runner ausführen.

Wenn Sie mehr über das Erstellen nativer ausführbarer Dateien erfahren möchten, konsultieren Sie bitte https://quarkus.io/guides/maven-tooling.

## Related Guides


## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
>>>>>>> 40af6d2 (Start Backend-Blog Projekt)
