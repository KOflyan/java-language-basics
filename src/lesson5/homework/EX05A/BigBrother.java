package lesson5.homework.EX05A;

import java.util.HashSet;
import java.util.Set;

public class BigBrother {
    private final InnerParty innerParty;
    private final OuterParty outerParty;
    private final Set<Citizen> vaporized = new HashSet<>();
    private final Set<Citizen> citizens = new HashSet<>();

    public BigBrother(InnerParty innerParty, OuterParty outerParty) {
        this.innerParty = innerParty;
        this.outerParty = outerParty;
        citizens.addAll(innerParty.getPartyMembers());
        citizens.addAll(outerParty.getPartyMembers());
    }

    public Set<Citizen> getAllCitizens() {
        return citizens;
    }

    public int massiveVaporize(CitizenStatus status) {
        int count = 0;
        for (Citizen citizen : citizens.stream().toList()) {
            System.out.printf("%s %s %b%n", citizen.status, status, citizen.status == status);
            if (status == citizen.status) {
                citizens.remove(citizen);
                if (citizen.party != null) {
                    citizen.party.vaporize(citizen);
                } else {
                    citizen.setStatus(CitizenStatus.NONPERSON);
                }
                vaporized.add(citizen);
                count++;
            }
        }
        System.out.println(count);
        return count;
    }

    public int getNumberOfVaporized() {
        return vaporized.size();
    }
}
