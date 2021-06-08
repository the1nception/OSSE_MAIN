package de.hfu.residents;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNull;

public class BaseResidentServiceTest {
    BaseResidentService service;

    @Before
    public void setResidents () throws ParseException {
        Resident resident1 = new Resident("Johannes","Meyer","Wildtalstraße","Freiburg", new Date());
        Resident resident2 = new Resident("Robert","Singinger","Eschholdstraße","Freiburg", new Date());
        Resident resident3 = new Resident("Rosa","Himmelreich","Siemensdamm","Freiburg", new Date());
        ResidentRepository stub = new ResidentRepositoryStub(resident1, resident2, resident3);

        this.service = new BaseResidentService();
        service.setResidentRepository(stub);
    }

    @Test
    public void testGetFilteredResidentsList () {
        List<Resident> list;
        Resident filtered = new Resident("Joh*","","","", new Date());
        list = service.getFilteredResidentsList(filtered);
        for (Resident resi : list) {
            assertEquals(resi.getGivenName(),"Johannes");
        }
    }

    @Test
    public void testNullGetFilteredResidentsList () {
        List<Resident> list;
        Resident filtered = new Resident("Fridolin","","","", new Date());
        list = service.getFilteredResidentsList(filtered);
        for (Resident resi : list) {
            assertNull(resi);
        }
    }

    @Test
    public void testCityGetFilteredResidentsList () {
        List<Resident> list;
        Resident filtered = new Resident("","","","Freiburg", new Date());
        list = service.getFilteredResidentsList(filtered);
        assertEquals(list.get(0).getGivenName(), "Johannes");
        assertEquals(list.get(1).getGivenName(), "Robert");
        assertEquals(list.get(2).getGivenName(), "Rosa");
    }

    @Test
    public void testGetUniqueResident () throws ResidentServiceException {
        Resident filtered = new Resident("Johannes","","","", new Date());
        assertEquals(service.getUniqueResident(filtered).getGivenName(), "Johannes");
    }

    @Test (expected=ResidentServiceException.class, timeout=1000)
    public void testExceptionGetUniqueResident () throws ResidentServiceException {
        Resident filtered = new Resident("","","","Freiburg", new Date());
        assertEquals(service.getUniqueResident(filtered).getGivenName(), "Johannes");
    }

    @Test (expected=ResidentServiceException.class, timeout=1000)
    public void testExceptionWildcardGetUniqueResident () throws ResidentServiceException {
        Resident filtered = new Resident("Joh*","","","", new Date());
        assertEquals(service.getUniqueResident(filtered).getGivenName(), "Johannes");
    }
}
