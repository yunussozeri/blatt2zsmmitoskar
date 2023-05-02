package pm2.zweiteblatt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author yunussozeri
 */
public class Person implements Comparable<Person> {

    private final String vorname;
    private String nachname;
    private final LocalDate geburtsdatum;
    private int anzahlKinder;

    /**
     * Empty Constructor for Person. Creates an empty person. Empty person has
     * the surname empty and the birthday 1/1/1111.
     */
    public Person() {
        this.vorname = "EMPTY";
        this.geburtsdatum = LocalDate.of(1111, 1, 1);
    }

    /**
     * Creates a Person Object.
     *
     * @param vorname is the name of the person
     * @param nachname is the surname of the person
     * @param geburtsjahr birth year of the person
     * @param geburtsmonat birth month of the person
     * @param geburtstag birthday of the person
     * @param anzahlKinder number of children of the person
     */
    public Person(String vorname,
            String nachname,
            int geburtsjahr,
            int geburtsmonat,
            int geburtstag,
            int anzahlKinder) {
        //TODO: Precondition, birth year not smaller than 1900
        //TODO: Precondition number of children is larger or equal to 0.
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = LocalDate.of(geburtsjahr, geburtsmonat, geburtstag);
        this.anzahlKinder = anzahlKinder;
    }

    /**
     * Returns the name.
     * @return vorname is the name
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * Returns the number of children.
     * @return anzahlkinder is the number of children
     */
    public int getAnzahlKinder() {
        return anzahlKinder;
    }

    /**
     * Modifies the number of children.
     * Cannot be smaller than 0.
     * @param anzahlKinder is the new number of children.
     */
    public void setAnzahlKinder(int anzahlKinder) {
        if(anzahlKinder < 0){
            return;
        }
        this.anzahlKinder = anzahlKinder;
    }

    /**
     * Gets the surname.
     * @return nachname is the surname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * Changes the surname.
     * @param nachname is the new surname.
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    /**
     * Gets the birth date of person
     * @return geburtsdatum is the birthday of the person.
     */
    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    /**
     * Creates a unique HashCode for the person.
     * 
     * @return hash is the unique hash for the person.
     * 
     */
    @Override
    public int hashCode() {
        int hash;
        
        int hashbase = 31;
        
        final int hashmultiplier = 101;
        
        hash = hashbase + hashmultiplier * geburtsdatum.getYear();
      
        hash = hash + hashmultiplier * geburtsdatum.getMonthValue();

        hash = hash + hashmultiplier * geburtsdatum.getDayOfMonth();
//        
        hash = hash + hashmultiplier * geburtsdatum.getDayOfYear();    
        
        return hash;
    }

    /**
     * Checks if two people are the same. 2 People are same, when their name,
     * surname, and their birthday is exactly the same.
     *
     * @param person the person to compare
     * @return isSame is true when the 2 people are the same.
     */
    @Override
    public boolean equals(Object person) {
        if (!(person instanceof Person)) {
            return false;
        }
        Person p = (Person) person;

        boolean isSame = equalsName(p)
                && equalsNachname(p)
                && equalsGeburtsdatum(p)
                && compareTo(p) == 0;
        return isSame;
    }

    private boolean equalsName(Person p) {
        return getVorname().equals(p.getVorname());
    }

    private boolean equalsNachname(Person p) {
        return getNachname().equals(p.getNachname());
    }

    private boolean equalsGeburtsdatum(Person p) {
        return getGeburtsdatum().equals(p.getGeburtsdatum());
    }

    /**
     * Gives a string version of the person.
     * @return the string containing all information about the person. 
     */
    @Override
    public String toString() {
        
        return "Person["+ hashCode()+"]:{ "
                + getVorname()+", "
                + getNachname() + ", "
                + "Birthday: " + getGeburtsdatum().format(DateTimeFormatter.ISO_DATE)+", "
                + "Number of Children: "+ getAnzahlKinder()+ "}";     
    }

    /**
     * Compares 2 People.
     *
     * @param p is the person to compare
     * @return result is the result of the comparison. return -1 if the compared
     * person has more children than the actual person. return 0 if the number
     * of children is the same. return 1 if the actual person has more children
     * than the compared person
     */
    @Override
    public int compareTo(Person p) {
        int comp = p.getAnzahlKinder();
        int result = 0;
        if (comp < getAnzahlKinder()) {
            result = 1;
        } else if (comp > getAnzahlKinder()) {
            result = -1;
        }
        return result;
    }

}
