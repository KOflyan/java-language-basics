package lesson5.homework.EX05A;

public class Citizen {
    String name;
    Party party;
    CitizenStatus status;

    public Citizen(String name, Party party) {
        this.name = name;
        this.party = party;
        this.status = CitizenStatus.CITIZEN;
    }

    public Citizen(String name, Party party, CitizenStatus status) {
        if (status == null) status = CitizenStatus.CITIZEN;
        switch (status) {
            case PROLE -> {
                this.name = name;
                this.party = null;
                this.status = status;
            }
            case NONPERSON -> {
                this.name = null;
                this.party = null;
                this.status = status;
            }
            default -> {
                this.name = name;
                setParty(party);
                this.status = status;
            }
        }
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party newParty) {
        if (party == newParty) return;
        if (party != null) party.removePartyMember(this);
        if (newParty != null && !newParty.isMember(this)) newParty.addPartyMember(this);
        party = newParty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CitizenStatus getStatus() {
        return status;
    }

    public void setStatus(CitizenStatus status) {
        switch (status) {
            case NONPERSON -> {
                removeParty();
                name = null;
            }
            case PROLE -> removeParty();
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("BIG BROTHER IS WATCHING YOU, %s", name);
    }

    private void removeParty() {
        if (party != null) {
            party.removePartyMember(this);
            party = null;
        }
    }
}
