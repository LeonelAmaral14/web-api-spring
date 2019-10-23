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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesApiControllerTEST {

    @InjectMocks
    private EmployeesApiController employeesApiController;
    @Mock
    private HRService hrService = new HRService();
    @Mock
    private ObjectMapper objectMapper;
    @Mock
    private HttpServletRequest request;


    @Test
    public void deleteEmployees_givenValidId_employeeIsDeleted() {
        Integer id = 44;
        Employee employee = new Employee();
        employee.setId(44);
        Mockito.when(this.request.getHeader("Accept")).thenReturn("application/json");
        ((HRService)Mockito.doReturn(Optional.of(employee)).when(this.hrService)).deleteEmployees(44);
        ResponseEntity<Employee> responseEntity = this.employeesApiController.employeesIdDelete(44);
        assertEquals("HTTP status should be OK", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Should have returned id of deleted employee", Integer.valueOf(44), responseEntity.getBody().getId());
    }

    @Test
    public void deleteEmployees_givenInvalidId_doNothing() {
        Mockito.when(this.request.getHeader("Accept")).thenReturn("application/json");
        ((HRService)Mockito.doReturn(Optional.empty()).when(this.hrService)).deleteEmployees(787);
        ResponseEntity<Employee> responseEntity = this.employeesApiController.employeesIdDelete(787);
        assertEquals("HTTP status should be No_Content", HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        assertNull("Response body should be empty", responseEntity.getBody());
    }

    @Test
    public void deleteEmployees_givenInvalidHeader_doNothing() {
        //Given
        //when(request.getHeader("Accept")).thenReturn("application/json");
        when(request.getHeader("Accept")).thenReturn(null);
        Mockito.doReturn(Optional.empty()).when(hrService).deleteEmployees(787);

        //When
        ResponseEntity<Employee> responseEntity = employeesApiController.employeesIdDelete(787);

        //Then
        assertEquals("HTTP status should be OK",  HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull("Response body should be empty", responseEntity.getBody());
    }

    @Test
    public void SetEmployees_givenValidNameTitle_getEmployee() {
        //Given
        Employee employee = new Employee();
        employee.setEmployeeName("Matheus Silva");
        employee.setEmployeeTitle("Trainee");
        when(request.getHeader("Accept")).thenReturn("application/json");

        /*
        Não pode retornar pois o valor é vazio (VOID) -- não podes ler um SET
        Entao se faz um doNothing() para ele não retornar o valor quando fazemos um SET dos Employees
        //Mockito.doReturn(Optional.empty()).when(hrService).getEmployees();
        */

        doNothing().when(hrService).setEmployees(employee);

        //When
        ResponseEntity<Employee> responseEntity = employeesApiController.employeesIdDelete(787);

        //Then
        assertEquals("HTTP status should be OK",  HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        System.out.println("Nome inserido: " + employee.getEmployeeName());
        assertNull("Response body should be empty", responseEntity.getBody());

    }

    @Test
    public void employeesIdGetTest() {
        Integer id = 44;
        Employee employee = new Employee();
        employee.setId(44);
        employee.employeeName("Leonel");
        employee.employeeTitle("estagiario");
        Mockito.when(this.request.getHeader("Accept")).thenReturn("application/json");
        Mockito.when(this.hrService.getEmployeeId(id)).thenReturn(employee);
        ResponseEntity<Employee> responseEntity = this.employeesApiController.employeesIdGet(44);
        assertEquals("Should be ok", HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("should have returned id of employee", Integer.valueOf(44), employee.getId());
        assertEquals("should have returned id of deleted employee", Integer.valueOf(44), ((Employee)responseEntity.getBody()).getId());
    }

    @Test
    public void GetEmployees_givenValidLimits_getEmployees() {
        //Given
        Integer bodyLimit = 7;
        Integer pageLimit = 1;
        String accept = request.getHeader("Accept");
        when(request.getHeader("Accept")).thenReturn("application/json");

        //When
        ResponseEntity<Employees> responseEntity = employeesApiController.employeesGet(bodyLimit, pageLimit);

        //Then
        assertEquals("HTTP status should be OK",  HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void IdGetEmployee_givenInvalidId_doNothing() {
        //Given
        when(request.getHeader("Accept")).thenReturn("application/json");

        //When
        ResponseEntity<Employee> responseEntity = employeesApiController.employeesIdGet(787);

        //Then
        assertEquals("HTTP status should be OK",  HttpStatus.OK, responseEntity.getStatusCode());
        assertNull("Response body should be empty", responseEntity.getBody());
    }

    @Test
    public void IdGetEmployee_givenValidId_getEmployee() {
        //Given
        Integer id = 44;
        Employee employee = new Employee();
        employee.setId(id);
        when(request.getHeader("Accept")).thenReturn("application/json");
        Mockito.when(hrService.getEmployeeId(id)).thenReturn(employee);
        //Employee emp = hrService.getEmployeeId(id);


        //When
        ResponseEntity<Employee> responseEntity = employeesApiController.employeesIdGet(id);

        //Then
        assertEquals("HTTP status should be OK",  HttpStatus.OK, responseEntity.getStatusCode());
        System.out.println("Busca do Employee com o ID: " + employee.getId());
        assertEquals("should have returned id of deleted employee", Integer.valueOf(id), responseEntity.getBody().getId());
    }
}
