package lesson4.homework.EX04B;

import java.util.*;

public class School {

    public String addWizard(Wizard wizard) throws NotAWizardException {
        return null;
    }

    public void removeWizard(Wizard wizard) {
    }

    public Set<Wizard> getWizards() {
        return null;
    }

    public String getName() {
        return null;
    }

    public Wizard getWizardByWand(Wand wand) throws InvalidWandException {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    public static void main(String[] args) throws Exception {

        Wand wand1 = new Wand("Holly", "Phoenix feather");
        Wand wand2 = new Wand("Vine", "Dragon heartstring");

        Wand badWand = new Wand(null, "empty");
//        Wizard badWizard = new Wizard(null, null);

        System.out.println(wand1); // -> "Holly, Phoenix feather"
        System.out.println(wand2); // -> "Vine, Dragon heartstring"

        Wizard wizard1 = new Wizard("Harry Potter", null);
        Wizard wizard2 = new Wizard("Hermione Granger", null);

        System.out.println(wizard1); // -> "Harry Potter"
        System.out.println(wizard2); // -> "Hermione Granger"


        School school = new School("Hogwarts School of Witchcraft and Wizardry");

        System.out.println(school); // -> "Hogwarts School of Witchcraft and Wizardry"

        System.out.println(wizard1.getWand()); // -> null

        wizard1.setWand(wand1);

        System.out.println(wizard1.getWand()); // -> "Holly, Phoenix feather"
//        wizard1.setWand(badWand); // InvalidWandException

        System.out.println(school.addWizard(wizard1)); // -> "Harry Potter started studying in Hogwarts School of Witchcraft and Wizardry."
        System.out.println(school.getWizards().size()); // -> 1

//         school.addWizard(wizard2); // -> NotAWizardException
//         school.addWizard(badWizard); // -> NotAWizardException

        wizard2.setWand(wand2);

        System.out.println(school.addWizard(wizard2)); // "Hermione Granger started studying in Hogwarts School of Witchcraft and Wizardry."

        System.out.println(school.getWizards().size()); // -> 2
        System.out.println(school.addWizard(wizard1)); // -> "Harry Potter is already studying in this school!"

        System.out.println(school.getWizardByWand(wand1)); // -> "Harry Potter"
        System.out.println(school.getWizardByWand(wand2)); // -> "Hermione Granger"

        school.removeWizard(wizard1);

        System.out.println(school.getWizardByWand(wand1)); // -> null
    }
}
