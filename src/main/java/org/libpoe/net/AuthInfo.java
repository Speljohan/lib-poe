package org.libpoe.net;

/**
 * Created by Johan on 2014-02-11.
 */
public class AuthInfo {

    private String email, password, sessionId;

    private boolean useSessionId;

    public AuthInfo(String email, String password) {
        this.email = email;
        this.password = password;
        this.useSessionId = false;
    }

    public AuthInfo(String sessionId) {
        this.sessionId = sessionId;
        this.useSessionId = true;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getSessionId() {
        return sessionId;
    }

    public boolean useSessionId() {
        return useSessionId;
    }
}
