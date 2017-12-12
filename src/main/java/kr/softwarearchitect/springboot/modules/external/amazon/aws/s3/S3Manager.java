package kr.softwarearchitect.springboot.modules.external.amazon.aws.s3;

import java.io.InputStream;

public interface S3Manager
{
    public InputStream readFile(String key);
    
    public String write(InputStream is, String path);
    
    public String writeSensorLog(InputStream is, String path);
    
    public String getPublicUrl(String path);
    
    public void deleteFile(String key);

}
