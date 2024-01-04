package lesson4.homework.EX04B;

import java.util.*;

public class School {

    private static final Set<String> SCHOOL_NAMES = new HashSet<>(Arrays.asList(
            "Hogwarts School of Witchcraft and Wizardry",
            "Durmstrang Institute",
            "Ilvermorny School of Witchcraft and Wizardry",
            "Castelobruxo",
            "Beauxbatons Academy of Magic"
    ));

    private String name;
    private Set<Wizard> wizards = new HashSet<>();

    public School(String name) throws InvalidSchoolException {
        if (!School.SCHOOL_NAMES.contains(name)) {
            throw new InvalidSchoolException();
        }

        this.name = name;
    }

    public String addWizard(Wizard wizard) throws NotAWizardException {
        if (wizard == null || wizard.getName() == null) {
            throw new NotAWizardException();
        }

        try {
            Wand.checkWand(wizard.getWand());
        } catch (InvalidWandException e) {
            throw new NotAWizardException();
        }

        if (this.wizards.contains(wizard)) {
            return String.format("%s is already studying in this school!", wizard.getName());
        }

        this.wizards.add(wizard);

        return String.format("%s started studying in %s.", wizard.getName(), this.name);
    }

    public void removeWizard(Wizard wizard) {
        this.wizards.remove(wizard);
    }

    public Set<Wizard> getWizards() {
        return this.wizards;
    }

    public String getName() {
        return this.name;
    }

    public Wizard getWizardByWand(Wand wand) throws InvalidWandException {
        Wand.checkWand(wand);

        for (Wizard w : this.wizards) {
            if (w.getWand().equals(wand)) {
                return w;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) throws Exception {

        Wand wand1 = new Wand("Holly", "Phoenix feather");
        Wand wand2 = new Wand("Vine", "Dragon heartstring");

        Wand badWand = new Wand(null, "empty");
//        Wizard badWizard = new Wizard(null, null);

        System.out.println(wand1); // -> "Holly, Phoenix feather"
        System.out.println(wand2); // -> "Vine, Dragon heartstring"

        Wizard wizard1 = new Wizard("Harry Potter");
        Wizard wizard2 = new Wizard("Hermione Granger");

        System.out.println(wizard1); // -> "Harry Potter"
        System.out.println(wizard2); // -> "Hermione Granger"


        School school = new School("Hogwarts School of Witchcraft and Wizardry");

        System.out.println(school); // -> "Hogwarts School of Witchcraft and Wizardry"

        System.out.println(wizard1.getWand()); // -> null

        wizard1.setWand(wand1);

        System.out.println(wizard1.getWand()); // -> "Holly, Phoenix feather"
//        wizard1.setWand(badWand); // InvalidWandException

        System.out.println(school.addWizard(wizard1)); // -> "Harry Potter started studying in Hogwarts School of Witchcraft and Wizardry."
        System.out.println(school.wizards.size()); // -> 1

//         school.addWizard(wizard2); // -> NotAWizardException
//         school.addWizard(badWizard); // -> NotAWizardException

        wizard2.setWand(wand2);

        System.out.println(school.addWizard(wizard2)); // "Hermione Granger started studying in Hogwarts School of Witchcraft and Wizardry."

        System.out.println(school.wizards.size()); // -> 2
        System.out.println(school.addWizard(wizard1)); // -> "Harry Potter is already studying in this school!"

        System.out.println(school.getWizardByWand(wand1)); // -> "Harry Potter"
        System.out.println(school.getWizardByWand(wand2)); // -> "Hermione Granger"

        school.removeWizard(wizard1);

        System.out.println(school.getWizardByWand(wand1)); // -> null
    }
}
