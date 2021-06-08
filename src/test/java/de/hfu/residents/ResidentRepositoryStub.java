package de.hfu.residents;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;

import java.util.ArrayList;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository {
    List<Resident> list = new ArrayList<>();

    public ResidentRepositoryStub (Resident resident1, Resident resident2, Resident resident3) {
        this.list.add(resident1);
        this.list.add(resident2);
        this.list.add(resident3);
    }

    public List<Resident> getResidents() {
        return list;
    }
}
