
package com.tech.exam.gaspi.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class WelcomeMessage {
    
    private String msg;
            
    private String version;
    
    
    public WelcomeMessage(){
        
    }
    
    public WelcomeMessage(String candidate, String version){
        this.msg = "WELCOME " + candidate;
        this.version = version;
    }

    public String getMsg() {
        return msg;
    }

    public String getVersion() {
        return version;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    
    
}
