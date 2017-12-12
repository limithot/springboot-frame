package kr.softwarearchitect.springboot.frame.configuration.prop;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("amazon.credential")
public class AmazonCredential implements Serializable
{
    
    
    /**
     * 
     */
    private static final long serialVersionUID = -8758981720733042957L;
    
    
    private String accessKeyId;
    private String secretKeyId;
    
    public String getAccessKeyId()
    {
        return accessKeyId;
    }
    public void setAccessKeyId(String accessKeyId)
    {
        this.accessKeyId = accessKeyId;
    }
    public String getSecretKeyId()
    {
        return secretKeyId;
    }
    public void setSecretKeyId(String secretKeyId)
    {
        this.secretKeyId = secretKeyId;
    }
}
