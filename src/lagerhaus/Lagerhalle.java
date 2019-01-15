package lagerhaus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Lagerhalle implements Comparable<Lagerhalle>, Iterable<Paket> {

    private String adresse;
    private Map<String, Set<Paket>> paketeGruppiertNachAdresse;

    public Lagerhalle(String adresse){
        this.adresse = adresse;
        paketeGruppiertNachAdresse = new HashMap<>();
    }

    public void add(Paket p){
        if(!paketeGruppiertNachAdresse.containsKey(p.getAdresse()))
            paketeGruppiertNachAdresse.put(p.getAdresse(), new HashSet<>());
        paketeGruppiertNachAdresse.get(p.getAdresse()).add(p);
    }

    public boolean contains(Paket p){
        if(!paketeGruppiertNachAdresse.containsKey(p.getAdresse()))
            return false;
        return paketeGruppiertNachAdresse.get(p.getAdresse()).contains(p);
    }

    @Override
    public int compareTo(Lagerhalle pakets) {
        return gewicht() - pakets.gewicht();
    }

    @Override
    public Iterator<Paket> iterator() {
        Set<Paket> alles = new HashSet<>();
        for(Set<Paket> p : paketeGruppiertNachAdresse.values())
            alles.addAll(p);
        return alles.iterator();
    }

    public int gewicht(){
        int g = 0;
        for(Paket p : this){
            g += p.getGewicht();
        }
        return g;
    }

    public String getAdresse() {
        return adresse;
    }

    public Map<String, Set<Paket>> getPaketeGruppiertNachAdresse() {
        return paketeGruppiertNachAdresse;
    }

    public static void main(final String[] args) {
        final Lagerhalle lagerhalle = new Lagerhalle("Pinguinmannstraße 3, 85748 Garching");
        lagerhalle.add(new Paket("Pinguinfraustraße 4, 85748 Garching", 100));
        lagerhalle.add(new Paket("Pingustraße 1, 88888 Pinghausen", 85));
        lagerhalle.add(new Paket("Pingustraße 1, 88888 Pinghausen", 73));
        lagerhalle.add(new Paket("Antarktisplatz 3, 12345 Arktis", 107));
        lagerhalle.add(new Paket("Pinguinvollversammlung, 81578 Malediven", 20));
        lagerhalle.add(new Paket("Pingustraat 100, 54321 Pingustan", 2));
        lagerhalle.add(new Paket("Pinguinfraustraße 4, 85748 Garching", 34));
        lagerhalle.add(new Paket("Tierpark Hellabrun, Tierparkstr. 30, 81543 München", 1));
        lagerhalle.add(new Paket("Tierpark Hellabrun, Tierparkstr. 30, 81543 München", 0));
        lagerhalle.add(new Paket("Pingustraße 1, 88888 Pinghausen", 6));

        final String msg1 = StreamSupport.stream(lagerhalle.spliterator(), false)
                .sorted()
                .map(Paket::toString)
                .reduce((adresse1, adresse2) -> adresse1 + "\n" + adresse2)
                .get();

        final String msg2 = StreamSupport.stream(lagerhalle.spliterator(), false)
                .map(Paket::getAdresse)
                .distinct()
                .map(adresse -> {
                    final Set<Paket> pakete = lagerhalle.getPaketeGruppiertNachAdresse().get(adresse);
                    final int anzahl = pakete.size();
                    final int gesamtgewicht = pakete.stream().mapToInt(Paket::getGewicht).sum();
                    return "Lagerhalle:\n  Adresse: " + adresse +
                            "\n# Pakete: " + anzahl +
                            "\nGesamtgewicht: " + gesamtgewicht;
                })
                .collect(Collectors.joining("\n"));

        System.out.println(lagerhalle);
        System.out.println("\n---\n");
        System.out.println(msg1);
        System.out.println("\n---\n");
        System.out.println(msg2);
        System.out.println("\n---\n");
    }


}

