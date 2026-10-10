package com.assignment.q10;

import javax.ejb.Remote;

@Remote
public interface ResultServiceRemote {
    StudentResult process(String rollNumber, double subject1, double subject2, double subject3);
}
