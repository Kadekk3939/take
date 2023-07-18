package eu.myszojelenie.controller;


import eu.myszojelenie.controller.dto.student.NewStudentDto;
import eu.myszojelenie.controller.dto.student.StudentDto;
import eu.myszojelenie.controller.dto.student.StudentsDto;
import eu.myszojelenie.controller.dto.student.UpdateStudentDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/student")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface StudentController {

    @POST
    StudentDto createStudent(NewStudentDto studentDto);

    @PUT
    StudentDto updateStudent(UpdateStudentDto studentDto);

    @GET
    @Path("/{index}")
    StudentDto getStudent(@PathParam("index") String index);

    @GET
    StudentsDto getStudents();

    @GET
    @Path("/approve/{index}")
    StudentDto approveStudentInternship(@PathParam("index") String index);

    @GET
    @Path("/finalize/{index}")
    StudentDto finalizeStudentInternship(@PathParam("index") String index);
    
    @GET
    @Path("/test")
    String testMethod();
}
