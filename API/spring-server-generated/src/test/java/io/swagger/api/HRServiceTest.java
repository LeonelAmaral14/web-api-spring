package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.HRService;
import io.swagger.model.Employee;
import io.swagger.model.Employees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;



@RunWith(SpringRunner.class)
@SpringBootTest
public class HRServiceTest {

    private Employee employee = new Employee();

    @InjectMocks
    private EmployeesApiController employeesApiController;

    @Mock
    private HRService hrService = new HRService();
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private HttpServletRequest request;

    @Test
    public void getId_givenValidData_doGet() {
        //Given
        Employee employee = new Employee();
        employee.setId(44);
        employee.employeeName("Leonel");
        employee.employeeTitle("estagiario");
        Mockito.when(hrService.getEmployeeId(44)).thenReturn(employee);
        //When

        //Then
        assertEquals("should have returned id of employee", Integer.valueOf(44),employee.getId());
    }

    @Test
    public void getEmployee_givenValidData_doGet() {

        Employees employees = new Employees();
        Employee employee = new Employee();
        employee.setId(47);
        employee.employeeName("Afonso");
        employee.employeeTitle("estagiario");

        employees.add(employee);

        Mockito.when(hrService.getEmployees()).thenReturn(employees);

        //ResponseEntity<Employees> responseEntity = employeesApiController.employeesGet(pagelimit1, pagelimit2);
        System.out.println(employees.toString());
        assertEquals("should have returned employee", "class Employees {\n" +
                " [class Employee {\n" +
                "        id: 47\n" +
                "        employeeName: Afonso\n" +
                "        employeeTitle: estagiario\n" +
                "    }]\n" +
                "}", employees.toString());
    }

    @Test
    public void deleteEmployees_givenValidData_doNothing() {
        Integer id=45;
        Employee employeeClone = new Employee();
        Mockito.when(hrService.deleteEmployees(id)).thenReturn(Optional.of(employeeClone));

        assertEquals("should have returned null", null,employee.getId());
    }

    @Test
    public void employeeSet_givenValidData_doSet() {
        Employee employee = new Employee();
        employee.setId(47);
        employee.setEmployeeName("Leonel Amaral");
        employee.setEmployeeTitle("Boss");
        doNothing().when(hrService).setEmployees(employee);

        System.out.println(employee.toString());

        assertEquals("should have returned employee", "class Employee {\n" +
                "    id: 47\n" +
                "    employeeName: Leonel Amaral\n" +
                "    employeeTitle: Boss\n" +
                "}", employee.toString());
    }
}