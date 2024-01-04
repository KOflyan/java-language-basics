package lesson5.homework.EX05A;

public class Citizen {

    private String name;
    private Party party;
    private CitizenStatus status;


    public Citizen(String name, Party party) {
        this(name, party, CitizenStatus.CITIZEN);
    }

    public Citizen(String name, Party party, CitizenStatus status) {
        this.name = name;
        this.party = party;
        this.status = status == null ? CitizenStatus.CITIZEN : status;

        if (status == CitizenStatus.NONPERSON) {
            this.name = null;
            this.party = null;
        } else if (status == CitizenStatus.PROLE) {
            this.party = null;
        } else if (party != null) {
            this.party.addPartyMember(this);
        }
    }

    public void setParty(Party party) {
        if (party != null && party.getPartyMembers().contains(this)) {
            this.party = party;
            return;
        }

        if (this.party != null) {
            this.party.removePartyMember(this);
        }

        if (party != null) {
            party.addPartyMember(this);
        }

        this.party = party;
    }


    public Party getParty() {
        return this.party;
    }

    public void setStatus(CitizenStatus status) {
        if (status.equals(CitizenStatus.NONPERSON) && this.party != null) {
            this.party.vaporize(this);
            return;
        }

        if (status.equals(CitizenStatus.PROLE)) {
            this.party = null;
        }

        this.status = status;
    }

    public CitizenStatus getStatus() {
        return this.status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("BIG BROTHER IS WATCHING YOU, %s", this.name);
    }
}
