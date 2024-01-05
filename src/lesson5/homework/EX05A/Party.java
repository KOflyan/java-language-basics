package lesson5.homework.EX05A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Party {
    private final List<Citizen> members = new ArrayList<>();


    public List<Citizen> getPartyMembers() {
        return members;
    }

    public void addPartyMember(Citizen citizen) {
        if (citizen == null || citizen.status == CitizenStatus.NONPERSON || members.contains(citizen)) {
            return;
        }
        members.add(citizen);
        citizen.setParty(this);
    }

    public void removePartyMember(Citizen citizen) {
        if (members.remove(citizen)) citizen.setParty(null);
    }

    public void vaporize(Citizen citizen) {
        if (members.contains(citizen)) citizen.setStatus(CitizenStatus.NONPERSON);
    }

    public boolean isMember(Citizen citizen) {
        return members.contains(citizen);
    }

    public abstract String getPrivileges();

    public static String getSlogan() {
        return "WAR IS PEACE\nFREEDOM IS SLAVERY\nIGNORANCE IS STRENGTH";
    }
}
