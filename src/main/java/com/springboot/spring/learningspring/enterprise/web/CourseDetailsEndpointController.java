package com.springboot.spring.learningspring.enterprise.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.springboot.spring.learningspring.enterprise.data.CourseDetailsService;

import localhost._8090.courses.CourseDetails;
import localhost._8090.courses.GetAllCourseDetailsResponse;
import localhost._8090.courses.GetCourseDetailsRequest;

// You will keep running into this sort of error message until you use the ComponentScan annotation "The declared package "com.springboot.spring.learningspring.enterprise.web" does not match the expected package "com.springboot.spring.learningspring.enterprise.data.courses"
@Endpoint
@ComponentScan("com.springboot.spring.learningspring.enterprise.data")
public class CourseDetailsEndpointController {

    // Telling spring to only process requests with the following namespace and name
    // of the request
    // @RequestPayload will convert to a POJO the request
    // @ResponsePayLoad will convert to a POJO the response

    @Autowired
    CourseDetailsService service;

    /**
     * <pre>
     * @param request
     * @return response
     * 
     * Checking this thing out.
     * </pre>
     */
    @ResponsePayload
    @PayloadRoot(namespace = "http://localhost:8090/courses", localPart = "GetCourseDetailsRequest")
    public GetAllCourseDetailsResponse processCourseDetailsRequest(@RequestPayload GetCourseDetailsRequest request) {
        GetAllCourseDetailsResponse response = new GetAllCourseDetailsResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(8402);
        courseDetails.setDescription("Uzarr");
        courseDetails.setName("big courses");
        response.setCourseDetails(courseDetails);
        return response;
    }

}