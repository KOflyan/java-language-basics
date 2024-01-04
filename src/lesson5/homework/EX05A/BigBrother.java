package lesson5.homework.EX05A;

import java.util.ArrayList;
import java.util.List;

public class BigBrother {

    private final InnerParty innerParty;
    private final OuterParty outerParty;

    private int totalNumberOfVaporized = 0;

    public BigBrother(InnerParty innerParty, OuterParty outerParty) {
        this.innerParty = innerParty;
        this.outerParty = outerParty;
    }

    public List<Citizen> getAllCitizens() {
        List<Citizen> allMembers = new ArrayList<>();

        allMembers.addAll(this.innerParty.members);
        allMembers.addAll(this.outerParty.members);

        return allMembers;
    }


    public int massiveVaporize(CitizenStatus status) {
        int vaporized = 0;

        for (Citizen citizen : this.getAllCitizens()) {
            if (citizen.getStatus().equals(status)) {
                citizen.getParty().vaporize(citizen);
                this.totalNumberOfVaporized += 1;
                vaporized += 1;
            }
        }

        return vaporized;
    }

    public int getNumberOfVaporized() {
        return this.totalNumberOfVaporized;
    }
}
