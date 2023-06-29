# Blog API Spezifikation

Hier erhält ihr die Spezifikationen und Dokumentation für mein BLOG-API, die es Entwicklern ermöglicht, auf die verschiedenen Funktionen und Endpunkte der API zuzugreifen.

## Schemas

---

### Blog
- `id`: number
- `titel`: string
- `beschreibung`: string
- `likeVonMir`: boolean
- `meineFavoriten`: boolean
- `blogDatum`: string
- `author`: Autor Schema
- `gast`: Gast Schema
- `kommentar`: Kommentar Schema

---
### Kommentar
- `id`: string
- `kommentarText`: string
- `kommentarAuthor`: Autor Schema
- `kommentarDatum`: string
- `kommentarLikeVonMir`: boolean

---
### Autor
- `id`: string
- `vorname`: string
- `nachname`: string
- `benutzername`: string
- `geburtstag`: string
- `eMail`: string
- `passwort`: string

---
### Gast
- `id`: string
- `vorname`: string
- `nachname`: string
- `benutzername`: string
- `eMail`: string


## Endpunkte

---
### Author

---

**Listet alle Blog**
```http request
GET /author
```
- Query-Parameter: `sort` Sortiert eine liste von Authoren (asc, desc)


---
### Blog

---

**Listet alle Blog**
```http request
GET /blog
```
- Query-Parameter: `sort` Sortiert eine liste von Blogs nach Alphabet (asc, desc)
- Query-Parameter: `from` und `to` wählt die Blogs aus die sich in dieser Range sich Befinden nach Datum
- Response: Gibt die sortierte Liste Zurück und auch nur die Blogs die `from` bis `to`. (200 OK)

---

**Gibt Details zu einem einzelnen Blog aus.**
```http request
GET /blog/{postId}
```
- Pfad-Parameter: `postId` um einen spezifischen Blog auszuwählen (benötigt)
- Pfad-Parameter: `postTitel` um einen spezifischen Blog auszuwählen (benötigt)
- Query-Parameter: `fields` wird gebraucht, wenn man nur spezifische Felder braucht
- Response: gibt denn ausgewählten Blog zurück (200 OK)

---

**Erstellt neue Blog**
```http request
POST /blog
```
- Header-Parameter: `id` (Benötigt)
- Request Body: Blog Schema
- Response: Erstellter Blog (201 Created)

---

**Aktualisiert einen vorhandenen Blog vollständig**
```http request
PUT /blog/{postId}
```
- Pfad-Parameter: `postId` Um eine Blog auszuwählen, denn man ändern will (benötigt)
- Request Body: Blog Schema
- Response: Aktualisierter Blog (200 OK)

---
**Aktualisiert teilweise einen vorhandenen Blog.**
```http request
PATCH /blog/{postId}
```
- Pfad-Parameter: `postId` Um einen Blog auszuwählen, denn man ändern will (benötigt)
- Request Body: Blog Schema (nur die zu aktualisierenden Felder)
- Response: Teilweise aktualisierter Blog (200 OK)

---

**Löscht einen Blog.**
```http request
DELETE /blog/{postId}
```
- Pfad-Parameter: `postId` Um einen Blog auszuwählen, denn man Löschen will (benötigt)
- Response: Keine (204 No Content)
---

### Kommentare

---

**Listet die Kommentare für einen bestimmten Blog auf**
```http request
GET /blog/{postId}/comments
```
- Pfad-Parameter: `postId` Um denn Blog auszuwählen und die dazugehörigen Comments Darstellen (benötigt)
- Query-Parameter: `sort` Um die Kommentare zu sortieren (asc, desc)
- Response: Eine Liste von Kommentaren (200 OK)

---

**Fügt einen neuen Kommentar zu einem Blog hinzu**
```http request
POST /blog/{postId}/comments
```

- Pfad-Parameter: `postId` Um denn Blog auszuwählen und einen Kommentar in diesem Blog zu erstellen (benötigt)
- Request Body: Comment Schema
- Response: Erstellter Kommentar (201 Created)

---

**Aktualisiert einen Kommentar vollständig**
```http request
PUT /blog/{postId}/comments/{commentId}
```
- Pfad-Parameter: `postId`, `commentId` selektiert den Blog und den Comment (benötigt)
- Request Body: Comment Schema
- Response: Aktualisierter Kommentar (200 OK)

---

**Aktualisiert teilweise einen Kommentar**
```http request
PATCH /blog/{postId}/comments/{commentId}
```
- Pfad-Parameter: `postId`, `commentId` selektiert den Blog und den Comment (benötigt)
- Request Body: Comment Schema (nur die zu aktualisierenden Felder)
- Response: Teilweise aktualisierter Kommentar (200 OK)

---

**Löscht einen Kommentar**
```http request
DELETE /blog/{postId}/comments/{commentId}
```
- Pfad-Parameter: `postId`, `commentId` (benötigt)
- Response: Keine (204 No Content)

---