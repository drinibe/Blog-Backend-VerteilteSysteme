## Berechtigungskonzept für Blog Backend API

### Öffentlich zugängliche Methoden (kein Benutzer-Login erforderlich):
- Blog-Liste anzeigen
- Einzelne Blog-Beiträge anzeigen
- Kommentare zu einem Blog-Beitrag anzeigen

### Benutzer-Rollen:
- **Gast**: Kann öffentliche Inhalte anzeigen, aber nicht interagieren.
- **Benutzer**: Kann sich anmelden und Kommentare erstellen.
- **Author (Autor)**: Kann sich anmelden, eigene Blog-Beiträge erstellen, bearbeiten und löschen. Kann auch Kommentare zu eigenen Beiträgen moderieren.
- **Admin**: Kann alle Aktionen durchführen, einschließlich Löschen und Bearbeiten von Beiträgen und Kommentaren.

### Methoden, die ein Login oder eine spezifische Benutzer-Rolle erfordern:

#### Blog
- Blog-Beitrag erstellen: **Author**, **Admin**
- Eigene Blog-Beiträge bearbeiten: **Author**
- Eigene Blog-Beiträge löschen: **Author**
- Alle Blog-Beiträge bearbeiten: **Admin**
- Alle Blog-Beiträge löschen: **Admin**

#### Kommentare
- Kommentar erstellen: **Benutzer**, **Author**, **Admin**
- Eigene Kommentare bearbeiten: **Author**, **Benutzer**
- Alle Kommentare bearbeiten: **Admin**
- Eigene Kommentare löschen: **Author**
- Alle Kommentare löschen: **Admin**