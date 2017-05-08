package com.javarticle.spring.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ephesoft.dcma.webservice.client.constants.ASMConstants;

@RestController
public class RESTControllerExample {
  /*  @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Collection<Employee> getEmployeeNames() {
        return EmployeeSource.getEmployees();
    }*/
   /* 
    @RequestMapping(value = "/employees/{empId}", method = RequestMethod.GET)
    public Employee getEmployeeNames(@PathParam("empId") String id) {
        return EmployeeSource.getEmployee(id);
    }
    */
    
	
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String getAccess(final HttpServletRequest request, final HttpServletResponse response) {
    	String user=	request.getParameter(ASMConstants.FORM_PARAM_USERNAME);
    	String pass= request.getParameter(ASMConstants.FORM_PARAM_PASSWORD);
    	String appcode= request.getParameter(ASMConstants.FORM_PARAM_APPCODE);
    	String ip=request.getParameter(ASMConstants.FORM_PARAM_IP);
    	EmployeeSource es=new EmployeeSource();
    	
    	System.out.println("Username ::"+user+" Password ::"+pass+" appcode ::"+appcode+" Ip ::"+ip);
    
    	String asmResponse="";
    	try {
			String filepath = null;
			if (user.equalsIgnoreCase("ephesoft")) {
				filepath = "D:\\Ephesoft\\Application\\WEB-INF\\classes\\META-INF\\dcma-asm-client\\success.xml";
			} else if (user.equalsIgnoreCase("user1")) {
				filepath = "D:\\Ephesoft\\Application\\WEB-INF\\classes\\META-INF\\dcma-asm-client\\user1.xml";
			} else {
				filepath = "D:\\Ephesoft\\Application\\WEB-INF\\classes\\META-INF\\dcma-asm-client\\failure.xml";
			}
			asmResponse = es.readResponseFromStream(filepath);
			
		} catch (final IOException e) {
			e.printStackTrace();
		}
    	 return asmResponse;
    }
    
    


}
