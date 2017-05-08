package com.javarticle.spring.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeSource {
    private static final Map<String, Employee> EMPLOYEES = new HashMap<>();
    static {
        Employee emp1 = new Employee();
        emp1.setId("01");
        emp1.setName("Joe");
        emp1.setAge(32);
        
        Employee emp2 = new Employee();
        emp2.setId("02");
        emp2.setName("Sam");
        emp2.setAge(41);
        
        Employee emp3 = new Employee();
        emp3.setId("03");
        emp3.setName("Phil");
        emp3.setAge(22);
        
        EMPLOYEES.put(emp1.getId(), emp1);
        EMPLOYEES.put(emp2.getId(), emp2);
        EMPLOYEES.put(emp3.getId(), emp3);
    }
    
    public static Collection<Employee> getEmployees() {
        return EMPLOYEES.values();
    }
    
    public static Employee getEmployee(String empId) {
        return EMPLOYEES.get(empId);
    }
    
    public String readResponseFromStream(final String filePath) throws IOException {
		final InputStream ip = new FileInputStream(new File(filePath));
		final StringBuilder sb = new StringBuilder();
		String line;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(ip))) {
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		}
		return sb.toString();
	}

}