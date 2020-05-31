package com.example.demo.security;

import lombok.Data;

public enum ApplicationUserPermission {
    STUDENT_WRITE("student:write"),
    STUDENT_READ("student:read"),
    COURSE_WRITE("course:write"),
    COURSE_READ("course:read");

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    private String permission;

    public String getPermission() {
        return permission;
    }
}
