package kr.softwarearchitect.springboot.frame.configuration.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("amazon.s3")
public class AmazonS3Prop
{
    private String waveBucket;
    private String prefix;
    private String domain;
    private String logBackPrefix;
    private String localLogLocation;
    private String localLogTransferLog;
    
    public String getWaveBucket()
    {
        return waveBucket;
    }
    public void setWaveBucket(String waveBucket)
    {
        this.waveBucket = waveBucket;
    }
    public String getPrefix()
    {
        return prefix;
    }
    public void setPrefix(String prefix)
    {
        this.prefix = prefix;
    }
    public String getDomain()
    {
        return domain;
    }
    public void setDomain(String domain)
    {
        this.domain = domain;
    }
    public String getLogBackPrefix()
    {
        return logBackPrefix;
    }
    public void setLogBackPrefix(String logBackPrefix)
    {
        this.logBackPrefix = logBackPrefix;
    }
    public String getLocalLogLocation()
    {
        return localLogLocation;
    }
    public void setLocalLogLocation(String localLogLocation)
    {
        this.localLogLocation = localLogLocation;
    }
    public String getLocalLogTransferLog()
    {
        return localLogTransferLog;
    }
    public void setLocalLogTransferLog(String localLogTransferLog)
    {
        this.localLogTransferLog = localLogTransferLog;
    }

}
