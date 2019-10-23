//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package io.swagger;

import io.swagger.api.EmployeesApi;
import io.swagger.api.EmployeesApiController;
import io.swagger.model.Employee;
import io.swagger.model.Employees;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
@Service
public class HRService {
    private static final Logger log = LoggerFactory.getLogger(HRService.class);
    Employees employees = new Employees();
    private EmployeesApiController empApiContrl;

    public HRService() {
    }

    public Employees getEmployees() {
        return this.employees;
    }

    public Employee getEmployeeId(int id) {
        Iterator var2 = this.employees.iterator();
        Employee employee;
        do {
            if (!var2.hasNext()) {
                return null;
            }
            employee = (Employee) var2.next();
        } while (employee.getId() != id);
        return employee;
    }

    public int setEmployees(Employee employee) {
        boolean check = false;
        for (int i = 0; i < employees.size(); i++) {
            Employee emp = employees.get(i);
            if (emp.getId() == employee.getId()) {
                check = true;
            }
        }
        if (check == false) {
            log.info("Employee Added");
            this.employees.add(employee);
            return 1;
        } else {
            log.info("Employee already exists!");
            return 0;
        }
    }


    public Optional<Employee> deleteEmployees(int id) {
        Employee employeeclone = null;
        Iterator var3 = this.employees.iterator();
        while (var3.hasNext()) {
            Employee employee = (Employee) var3.next();
            if (employee.getId() == id) {
                log.info("Found employee with id:" + id);
                log.info("Employee Name:" + employee.getEmployeeName());
                employeeclone = employee;
                break;
            }
        }
        if (employeeclone != null) {
            this.employees.remove(employeeclone);
            log.info("Employee successfully deleted");
        } else {
            log.info("Employee not found! There's nothing to remove.");
        }
        return Optional.ofNullable(employeeclone);
    }
}
