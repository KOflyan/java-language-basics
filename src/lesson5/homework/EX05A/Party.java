package lesson5.homework.EX05A;

import java.util.ArrayList;
import java.util.List;

public abstract class Party {
    protected List<Citizen> members = new ArrayList<>();

    public List<Citizen> getPartyMembers() {
        return this.members;
    }

    public void addPartyMember(Citizen citizen) {
        if (
                citizen.getName() == null
                || citizen.getStatus() == null
                || citizen.getStatus().equals(CitizenStatus.NONPERSON)
                || this.members.contains(citizen)
        ) {
            return;
        }

        this.members.add(citizen);
        citizen.setParty(this);
    }

    public void removePartyMember(Citizen citizen) {
        this.members.remove(citizen);
    }

    public void vaporize(Citizen citizen) {
        if (!this.members.contains(citizen)) {
            return;
        }

        this.removePartyMember(citizen);
        citizen.setParty(null);
        citizen.setName(null);
        citizen.setStatus(CitizenStatus.NONPERSON);
    }

    public abstract String getPrivileges();

    public static String getSlogan() {
        return "WAR IS PEACE\nFREEDOM IS SLAVERY\nIGNORANCE IS STRENGTH";
    }

    public static void main(String[] args) {
//        InnerParty ip = new InnerParty();
//        OuterParty op = new OuterParty();
//
//        Citizen c = new Citizen("Winston Smith", op, CitizenStatus.UNDER_SURVEILLANCE);
//        Citizen c1 = new Citizen("Julia", op, CitizenStatus.UNDER_SURVEILLANCE);
//
//        System.out.println(c.getName()); // "Winston Smith"
//        System.out.println(c.getParty()); //"Outer party"
//
//        System.out.println(c.getStatus()); // "under surveillance"
//        System.out.println(c); // "BIG BROTHER IS WATCHING YOU, Winston Smith"
//        System.out.println(c1); // "BIG BROTHER IS WATCHING YOU, Julia"
//
//        c.setParty(ip);
//
//        System.out.println(c.getParty()); // "Inner party"
//        System.out.println(ip.getPartyMembers().size()); // 1
//        System.out.println(op.getPartyMembers().size()); // 1
//        System.out.println(op.getPartyMembers().contains(c)); // false
//
//        c.setParty(op);
//
//        System.out.println(c.getParty()); // "Outer party"
//        System.out.println(op.getPartyMembers().size()); // 2
//
//        Citizen c2 = new Citizen("O'Brien", ip);
//        System.out.println(c2.getName()); // == "O"Brien";
//        System.out.println(c2.getParty()); // "Inner party";
//        System.out.println(c2.getStatus()); // "citizen";
//
//        Citizen c3 = new Citizen("Syme", op, CitizenStatus.NONPERSON);
//        System.out.println(c3.getName()); // null
//        System.out.println(c3.getParty()); // null
//        System.out.println(c3.getStatus()); // "nonperson"
//
//        Citizen c4 = new Citizen("Smb", op, CitizenStatus.PROLE);
//
//        System.out.println(c4.getName()); // "Smb"
//        System.out.println(c4.getParty()); // null
//        System.out.println(c4.getStatus()); // "prole"
//
//        System.out.println(ip.getPartyMembers().size()); // 1
//        System.out.println(op.getPartyMembers().size()); // 2
//        System.out.println(ip); // "Inner party"
//        System.out.println(op); // "Outer party"
//        System.out.println(ip.getPrivileges()); // "Everything"
//        System.out.println(op.getPrivileges()); // null
//
//        System.out.println((Party.getSlogan()));  // "WAR IS PEACE\nFREEDOM IS SLAVERY\nIGNORANCE IS STRENGTH"
//
//        BigBrother bb = new BigBrother(ip, op);
//        System.out.println(bb.getAllCitizens().size()); // 3
//        System.out.println(bb.massiveVaporize(CitizenStatus.UNDER_SURVEILLANCE)); // 2
//        System.out.println(bb.getAllCitizens().size()); // 1
//        System.out.println(c.getName()); // null
//        System.out.println(c.getParty()); // null
//        System.out.println(c.getStatus()); // "nonperson"
//        System.out.println(ip.getPartyMembers()); // 1
//        System.out.println(op.getPartyMembers().size()); // 0
//        System.out.println(bb.massiveVaporize(CitizenStatus.CITIZEN)); // 1
//        System.out.println(bb.getNumberOfVaporized()); // 3
    }
}
