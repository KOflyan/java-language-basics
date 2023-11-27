package lesson4.homework.EX04B.tests;

import lesson4.homework.EX04B.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class EX04BTest {

    private static final Random random = new Random();

    private static final List<String> WAND_CORES = new ArrayList<>(Arrays.asList(
            "Thestral tail hair",
            "Dragon heartstring",
            "Troll whisker",
            "Unicorn hair",
            "Phoenix feather",
            "Veela hair"
    ));

    private static final List<String> WAND_WOOD_TYPES = new ArrayList<>(Arrays.asList(
            "Elder",
            "Walnut",
            "Blackthorn",
            "Ash",
            "Larch",
            "Birch"
    ));

    private static final List<String> WIZARDS = new ArrayList<>(Arrays.asList(
            "Harry Potter",
            "Draco Malfoy",
            "Hermione Granger",
            "Ronald Weasley",
            "Fred Weasley",
            "George Weasley"
    ));

    private static final List<String> SCHOOLS = new ArrayList<>(Arrays.asList(
            "Hogwarts School of Witchcraft and Wizardry",
            "Durmstrang Institute",
            "Ilvermorny School of Witchcraft and Wizardry",
            "Castelobruxo",
            "Beauxbatons Academy of Magic"
    ));

    private Wizard createWizard(Wand wand) throws InvalidWandException {
        String name = WIZARDS.get(random.nextInt(WIZARDS.size()));

        return new Wizard(name, wand);
    }
    private Wizard createWizard() throws InvalidWandException {
        return createWizard(null);
    }

    private Wand createWand() {
        String core = WAND_CORES.get(random.nextInt(WAND_CORES.size()));
        String wood = WAND_WOOD_TYPES.get(random.nextInt(WAND_WOOD_TYPES.size()));

        return new Wand(core, wood);
    }

    private School createSchool() throws InvalidSchoolException {
        String name = SCHOOLS.get(random.nextInt(SCHOOLS.size()));

        return new School(name);
    }

    @Test
    void testWandConstructor() {

        for (int i = 0; i < WAND_WOOD_TYPES.size(); i++) {
            String wood = WAND_WOOD_TYPES.get(i);
            String core = WAND_CORES.get(i);

            Wand wand = new Wand(wood, core);

            assertEquals(wood, wand.getWoodType());
            assertEquals(core, wand.getCore());
        }
    }

    @Test
    void testSetWoodTypeAndCore() {
        String core = WAND_CORES.get(2);
        String wood = WAND_WOOD_TYPES.get(2);

        Wand w = new Wand(wood, core);

        assertEquals(wood, w.getWoodType());
        assertEquals(core, w.getCore());
    }

    @Test
    void testWandToString() {
        Wand w = createWand();

        String expected = String.format("%s, %s", w.getWoodType(), w.getCore());

        assertEquals(expected, w.toString());

    }

    @Test
    void testCheckWand() {
        assertThrows(
                InvalidWandException.class,
                () -> Wand.checkWand(null),
                "Should throw \"InvalidWandException\""
        );
        assertThrows(
                InvalidWandException.class,
                () -> Wand.checkWand(new Wand(null, WAND_CORES.get(0))),
                "Should throw \"InvalidWandException\""
        );
        assertThrows(
                InvalidWandException.class,
                () -> Wand.checkWand(new Wand(WAND_WOOD_TYPES.get(0), null)),
                "Should throw \"InvalidWandException\""
        );
    }


    @Test
    void testWizardConstructor() throws InvalidWandException {
        String name = WIZARDS.get(random.nextInt(WIZARDS.size()));
        Wizard wizard = new Wizard(name, null);

        assertEquals(name, wizard.getName());
        assertThrows(
                InvalidWandException.class,
                () -> new Wizard("name", new Wand(null, null)),
                "Should throw \"InvalidWandException\""
        );
    }

    @Test
    void testWizardSetWandWithCorrectWand() throws InvalidWandException {
        Wizard wizard = createWizard();
        Wand wand = createWand();

        assertNull(wizard.getWand());

        wizard.setWand(wand);

        assertEquals(wizard.getWand(), wand);
    }

    @Test
    void testWizardSetWandWithBadWand() throws InvalidWandException {
        Wizard wizard = createWizard();
        Wand wand0 = createWand();
        Wand wand1 = createWand();

        wand0.setWoodType(null);
        wand1.setCore(null);


        assertThrows(
                InvalidWandException.class,
                () -> wizard.setWand(wand0)
        );

        assertThrows(
                InvalidWandException.class,
                () -> wizard.setWand(wand1)
        );

        assertThrows(
                InvalidWandException.class,
                () -> wizard.setWand(new Wand(null, null))
        );

        assertNull(wizard.getWand());
    }

    @Test
    void testWizardToString() throws Exception {
        Wizard wizard = createWizard();

        assertEquals(wizard.getName(), wizard.toString());
    }

    @Test
    void testSchoolConstructor() throws InvalidSchoolException {
        assertThrows(
                InvalidSchoolException.class,
                () -> new School("invalid school name")
        );

        School school = createSchool();

        assertNotNull(school);
    }

    @Test
    void testAddWizard1() throws Exception {
        School school = createSchool();

        for (int i = 0; i < 5; i++) {
            Wand wand = new Wand(WAND_WOOD_TYPES.get(i), WAND_CORES.get(i));
            Wizard wizard = new Wizard(WIZARDS.get(i), wand);
            String expected = String.format("%s started studying in %s.", wizard.getName(), school.getName());

            assertEquals(expected, school.addWizard(wizard));
            assertTrue(school.getWizards().contains(wizard));
            assertEquals(school.getWizards().size(), i + 1);
        }
    }

    @Test
    void testAddWizard2() throws Exception {
        School school = createSchool();
        Wizard noWand = createWizard();
        Wizard noName = new Wizard(null, createWand());

        assertThrows(
                NotAWizardException.class,
                () -> school.addWizard(noWand)
        );
        assertThrows(
                NotAWizardException.class,
                () -> school.addWizard(noName)
        );
    }

    @Test
    void testAddWizard3() throws Exception {
        School school = createSchool();
        List<Wizard> wizards = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Wand wand = createWand();
            Wizard wizard = createWizard(wand);

            wizards.add(wizard);
            school.addWizard(wizard);
        }

        for (Wizard w : wizards) {
            assertEquals(String.format("%s is already studying in this school!", w.getName()), school.addWizard(w));
            assertEquals(wizards.size(), school.getWizards().size());
        }
    }

    @Test
    void testRemoveWizard() throws Exception {
        School s = createSchool();
        Wizard wizard = createWizard(createWand());
        Wizard wizard1 = createWizard(createWand());

        assertEquals(0, s.getWizards().size());

        s.addWizard(wizard);
        s.addWizard(wizard1);

        s.removeWizard(wizard);

        assertEquals(1, s.getWizards().size());

        // Should not do anything
        s.removeWizard(new Wizard("abc", null));
        assertEquals(1, s.getWizards().size());
    }

    @Test
    void testGetWizardByWand() throws Exception {
        School s = createSchool();
        Wand wand0 = createWand();
        Wizard wizard = createWizard(wand0);

        s.addWizard(wizard);

        Wand wand1 = createWand();
        Wand wand2 = createWand();

        wand1.setCore(null);
        wand2.setWoodType(null);

        assertThrows(
                InvalidWandException.class,
                () -> s.getWizardByWand(wand1)
        );

        assertThrows(
                InvalidWandException.class,
                () -> s.getWizardByWand(wand2)
        );

        assertEquals(wizard, s.getWizardByWand(wand0));

        assertNull(s.getWizardByWand(createWand()));
    }

    @Test
    void testSchoolToString() throws Exception {
        School s = createSchool();

        assertEquals(s.getName(), s.toString());
    }
}
