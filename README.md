# RayTracer - Laboration 2

Ett raytracer program skrivet i Java

Programmet skickar rays från en fast kamera och kontrollerar om de träffar objekt i en scen. Resultat sparas som en PPM bild

## Klasser:

- Vector3D - används för positioner och riktningar i 3D
- Ray - representerar en ray/stråle med startpunkt och riktning
- Shape - interface som alla former representerar
- Sphere - representerar en sfär och kontrollerar träffar med rays
- Triangle - representerar en triangel och kontrollerar träffar med rays
- HitResult - sparar informationen om en träff
- Scene - innehåller en lista med shapes och hittar närmsta träff
- Color - representerar färg med RGB
- Renderer - renderar scenen och sparar resultatet som en PPM fil
- Main - skapar scenen och startar renderingen

## Lägga till en ny shape

För att lägga till en ny shape skapar man en ny klass som implementerar Shape och skriver en egen hit(Ray ray) metod

Sedan kan formen läggas till i scenen med:

scene.addShape(...)

## Köra programmet

Kör Main.java.

Programmet skapar filen:

output.ppm