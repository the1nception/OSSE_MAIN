package de.hfu.residents;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import org.junit.Test;
import static org.easymock.EasyMock.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseResidentServiceEasyMockTest {
    @Test
    public void test() {
        List<Resident> liste = new ArrayList<>();
        Resident resident1 = new Resident("Johannes","Meyer","Wildtalstraße","Freiburg", new Date());
        liste.add(resident1);

        ResidentRepository repositoryMock = mock(ResidentRepository.class);
        when(repositoryMock.getResidents()).thenReturn(liste);

        replay(repositoryMock);
        BaseResidentService service = new BaseResidentService();
        service.setResidentRepository(repositoryMock);

        service.getFilteredResidentsList(resident1);

        verify(repositoryMock);
        assertThat(resident1.getGivenName(), equalTo("Johannes"));



    }
}
