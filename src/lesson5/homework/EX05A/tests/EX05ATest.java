package lesson5.homework.EX05A.tests;

import lesson5.homework.EX05A.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

// TODO: uncomment when you have completed the exercise & ready to run tests!
public class EX05ATest {
//    private static final Random R = new Random();
//    private static final List<CitizenStatus> STATUSES = Arrays.stream(CitizenStatus.values()).toList();
//    private static final List<String> NAMES = new ArrayList<>(Arrays.asList(
//            "Winston",
//            "Julia",
//            "Syme",
//            "O'Brien",
//            "Parsons",
//            "Charrington",
//            "Ampleforth"
//    ));
//
//
//    private Citizen createCitizen(Party party, CitizenStatus status) {
//        String name = NAMES.get(EX05ATest.R.nextInt(NAMES.size()));
//
//        return new Citizen(name, party, status);
//    }
//    private Citizen createCitizen(Party party) {
//        return this.createCitizen(party, null);
//    }
//
//    private List<Citizen> createManyCitizens(int n, CitizenStatus ... allowedStatuses) {
//        List<Citizen> citizens = new ArrayList<>();
//
//        Party ip = new InnerParty();
//        Party op = new OuterParty();
//
//        for (int i = 0; i < n; i++) {
//            Party party = i % 2 == 0
//                    ? op
//                    : ip;
//
//            List<CitizenStatus> statuses = allowedStatuses == null || allowedStatuses.length == 0
//                    ? EX05ATest.STATUSES
//                    : Arrays.asList(allowedStatuses);
//
//            CitizenStatus status = statuses.get(EX05ATest.R.nextInt(statuses.size()));
//
//            citizens.add(this.createCitizen(party, status));
//        }
//
//        return citizens;
//    }
//
//    @Test
//    public void testCitizenConstructor() {
//        var citizens = this.createManyCitizens(30);
//
//        // Append two citizens with undefined statuses
//        // The status should be changed to 'citizen'
//        citizens.add(this.createCitizen(new OuterParty()));
//        citizens.add(this.createCitizen(new InnerParty()));
//
//        for (Citizen c : citizens) {
//            CitizenStatus status = c.getStatus();
//            Party party = c.getParty();
//            String name = c.getName();
//
//            if (status == null) {
//                fail("Status cannot be null");
//            }
//
//            if (status.equals(CitizenStatus.PROLE)) {
//                assertTrue(NAMES.contains(name));
//                assertNull(party);
//            } else if (status.equals(CitizenStatus.NONPERSON)) {
//                assertNull(name);
//                assertNull(party);
//            } else if (status.equals(CitizenStatus.CITIZEN) || status.equals(CitizenStatus.UNDER_SURVEILLANCE)) {
//                assertTrue(NAMES.contains(name));
//                assertTrue(party.getPartyMembers().contains(c));
//            } else {
//                fail(String.format("Not allowed status: %s", status));
//            }
//        }
//    }
//
//    @Test
//    public void testCitizenSetPartyWithCorrectParty() {
//        var op = new OuterParty();
//        var ip = new InnerParty();
//
//        var c = createCitizen(op);
//
//        assertTrue(op.getPartyMembers().contains(c));
//
//        c.setParty(ip);
//
//        assertFalse(op.getPartyMembers().contains(c));
//        assertTrue(ip.getPartyMembers().contains(c));
//    }
//
//    @Test
//    public void testCitizenSetPartyWithNull() {
//        var party = new OuterParty();
//        Party badParty = null;
//
//        var c = this.createCitizen(party);
//        c.setParty(badParty);
//
//        assertFalse(party.getPartyMembers().contains(c));
//        assertNull(c.getParty());
//
//        c.setParty(party);
//        assertTrue(party.getPartyMembers().contains(c));
//    }
//
//    @Test
//    public void testCitizenSetStatus() {
//        var citizens = this.createManyCitizens(
//                50,
//                CitizenStatus.CITIZEN,
//                CitizenStatus.UNDER_SURVEILLANCE
//        );
//
//        for (Citizen c : citizens.subList(0, citizens.size() / 2 + 1)) {
//            Party party = c.getParty();
//
//            System.out.println(c.getName() + " " + c.getStatus());
//            System.out.println(c.getParty().getPartyMembers());
//            System.out.println(c.getParty().getPartyMembers().contains(c));
//            System.out.println();
//
//            c.setStatus(CitizenStatus.NONPERSON);
//
//            assertNull(c.getName());
//            assertNull(c.getParty());
//            assertEquals(c.getStatus(), CitizenStatus.NONPERSON);
//            assertFalse(party.getPartyMembers().contains(c));
//        }
//
//
//        for (Citizen c : citizens.subList(citizens.size() / 2, citizens.size())) {
//            String name = c.getName();
//
//            c.setStatus(CitizenStatus.PROLE);
//
//            assertEquals(c.getName(), name);
//            assertNull(c.getParty());
//            assertEquals(c.getStatus(), CitizenStatus.PROLE);
//        }
//    }
//
//    @Test
//    public void testCitizenSetName() {
//        var c = createCitizen(new OuterParty());
//
//        String name = "new name";
//
//        c.setName(name);
//
//        assertEquals(name, c.getName());
//    }
//
//    @Test
//    public void testCitizenToString() {
//        var citizens = createManyCitizens(10);
//
//        for (Citizen c : citizens) {
//            assertEquals(String.format("BIG BROTHER IS WATCHING YOU, %s", c.getName()), c.toString());
//        }
//    }
//
//    @Test
//    public void testPartyAddPartyMember() {
//        var citizens = this.createManyCitizens(
//                1,
//                CitizenStatus.CITIZEN,
//                CitizenStatus.UNDER_SURVEILLANCE
//        );
//
//        var party = new OuterParty();
//
//
//        for (Citizen c : citizens) {
//            System.out.println(party.getPartyMembers());
//
//            party.addPartyMember(c);
//
//            assertEquals(party, c.getParty());
//            assertTrue(party.getPartyMembers().contains(c));
//        }
//    }
//
//    @Test
//    public void testPartAddPartyMemberProleOrNonperson() {
//
//        var op = new OuterParty();
//
//        var c = createCitizen(op, CitizenStatus.NONPERSON);
//        var c1 = createCitizen(op, CitizenStatus.PROLE);
//
//        op.addPartyMember(c);
//
//        assertFalse(op.getPartyMembers().contains(c));
//        assertNull(c.getParty());
//
//        op.addPartyMember(c1);
//
//        assertTrue(op.getPartyMembers().contains(c1));
//        assertEquals(op, c1.getParty());
//    }
//
//    @Test
//    public void testPartyRemovePartyMember() {
//        var ip = new InnerParty();
//        var c = createCitizen(null);
//
//        ip.addPartyMember(c);
//
//        assertTrue(ip.getPartyMembers().contains(c));
//
//        ip.removePartyMember(c);
//
//        assertFalse(ip.getPartyMembers().contains(c));
//
//
//        // Must not throw an error
//        ip.removePartyMember(c);
//        ip.removePartyMember(createCitizen(new OuterParty()));
//    }
//
//    @Test
//    public void testPartyVaporize() {
//
//        var citizens = createManyCitizens(30, CitizenStatus.CITIZEN, CitizenStatus.UNDER_SURVEILLANCE);
//
//        for (Citizen c : citizens) {
//            var party = c.getParty();
//
//            party.vaporize(c);
//
//            assertNull(c.getName());
//            assertNull(c.getParty());
//            assertEquals(CitizenStatus.NONPERSON, c.getStatus());
//            assertFalse(party.getPartyMembers().contains(c));
//        }
//
//        var c = createCitizen(null, CitizenStatus.NONPERSON);
//        var c1 = createCitizen(null, CitizenStatus.PROLE);
//        var op = new OuterParty();
//
//        // Must not throw an error
//        op.vaporize(c);
//        op.vaporize(c1);
//
//
//        c = createCitizen(null);
//
//        op.vaporize(c);
//        assertNotNull(c.getName());
//        assertNotEquals(CitizenStatus.NONPERSON, c.getStatus());
//    }
//
//    @Test
//    public void testPartyGetPrivileges() {
//        assertNull(new OuterParty().getPrivileges());
//        assertEquals("Everything", new InnerParty().getPrivileges());
//    }
//
//    @Test
//    public void testPartyGetSlogan() {
//        assertEquals("WAR IS PEACE\nFREEDOM IS SLAVERY\nIGNORANCE IS STRENGTH", Party.getSlogan());
//    }
//
//    @Test
//    public void testPartyToString() {
//        assertEquals("Inner party", new InnerParty().toString());
//        assertEquals("Outer party", new OuterParty().toString());
//    }
//
//    @Test
//    public void testBigBrotherGetAllCitizens() {
//
//        var citizens = createManyCitizens(30, CitizenStatus.CITIZEN, CitizenStatus.UNDER_SURVEILLANCE);
//
//        var op = (OuterParty) citizens.get(0).getParty();
//        var ip = (InnerParty) citizens.get(1).getParty();
//
//        System.out.println(op);
//        System.out.println(ip);
//
//        var bb = new BigBrother(ip, op);
//
//        assertEquals(new HashSet<>(citizens).size(), bb.getAllCitizens().size());
//    }
//
//    @Test
//    public void testBigBrotherMassiveVaporizeAndGetNumberOfVaporized() {
//
//        var op = new OuterParty();
//        var ip = new InnerParty();
//
//        var newStatuses = new ArrayList<>(Arrays.asList(
//                CitizenStatus.CITIZEN,
//                CitizenStatus.UNDER_SURVEILLANCE
//        ));
//
//        Map<CitizenStatus, Integer> statusCount = new HashMap<>();
//
//        for (int i = 0; i < 20; i++) {
//            var party = i % 2 == 0
//                    ? op
//                    : ip;
//
//            var initialNumberOfMembers = party.getPartyMembers().size();
//            var status = newStatuses.get(R.nextInt(newStatuses.size()));
//
//
//            createCitizen(party, status);
//
//            if (party.getPartyMembers().size() > initialNumberOfMembers) {
//                statusCount.put(
//                        status,
//                        statusCount.getOrDefault(status, 0) + 1
//                );
//            }
//        }
//        var bb = new BigBrother(ip, op);
//
//        var numberOfCitizensInTheBeginning = bb.getAllCitizens().size();
//
//        var firstVaporize = bb.massiveVaporize(CitizenStatus.UNDER_SURVEILLANCE);
//
//        assertEquals(
//                numberOfCitizensInTheBeginning - firstVaporize,
//                bb.getAllCitizens().size()
//        );
//
//        assertEquals(
//                statusCount.getOrDefault(CitizenStatus.UNDER_SURVEILLANCE, 0),
//                firstVaporize
//        );
//        assertEquals(
//                statusCount.getOrDefault(CitizenStatus.UNDER_SURVEILLANCE, 0),
//                bb.getNumberOfVaporized()
//        );
//
//        var secondVaporize = bb.massiveVaporize(CitizenStatus.CITIZEN);
//
//        assertEquals(
//                statusCount.getOrDefault(CitizenStatus.CITIZEN, 0),
//                secondVaporize
//        );
//
//        assertEquals(
//                firstVaporize + secondVaporize,
//                bb.getNumberOfVaporized()
//        );
//
//        assertEquals(0, bb.getAllCitizens().size());
//    }
}
