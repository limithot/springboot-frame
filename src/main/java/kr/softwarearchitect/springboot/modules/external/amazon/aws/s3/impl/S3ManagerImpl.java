package kr.softwarearchitect.springboot.modules.external.amazon.aws.s3.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import kr.softwarearchitect.springboot.modules.external.amazon.aws.s3.S3Manager;
import kr.softwarearchitect.springboot.frame.configuration.prop.AmazonCredential;
import kr.softwarearchitect.springboot.frame.configuration.prop.AmazonS3Prop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.InputStream;

@Named
public class S3ManagerImpl implements S3Manager
{
    private final static Logger LOG = LoggerFactory.getLogger(S3ManagerImpl.class);

    @Inject
    private AmazonCredential amazonCredential;
    
    @Inject
    private AmazonS3Prop amazonS3Prop;
    
    private AmazonS3 amazonS3;

    @Override
    public InputStream readFile(String key)
    {
        String bucketPath = key.substring(0);
        
        if( 0< key.length() 
                && !key.startsWith("/") ) {
            bucketPath = "/" + key;
        }
        S3Object obj = null;
        try {
            obj = this.getClientInstance().getObject(this.amazonS3Prop.getWaveBucket()
                                                , this.amazonS3Prop.getPrefix().substring(1) + bucketPath);
        }catch(AmazonS3Exception e) {
            LOG.error("Bucket = " + this.amazonS3Prop.getWaveBucket() 
             + "\n" + "Key-ID= " + this.amazonS3Prop.getPrefix().substring(1) + bucketPath ,e);
            
        }
        return obj.getObjectContent();
    }

    @Override
    public String write(InputStream is, String path)
    {
        ObjectMetadata meta = new ObjectMetadata();
        meta.setHeader("Content-Type", "audio/wav");
        
        AccessControlList acl = new AccessControlList();
        acl.grantPermission( GroupGrantee.AllUsers, Permission.Read);
        
        String bucketPath = path.substring(0);
        if( 0< path.length() && !path.startsWith("/")) {
            bucketPath = "/" + path;
        }

        PutObjectRequest por = new PutObjectRequest( this.amazonS3Prop.getWaveBucket()
                , this.amazonS3Prop.getPrefix().substring(1) + bucketPath 
                , is
                , meta);
        por.withAccessControlList(acl);
        por.getRequestClientOptions().setReadLimit(100000000);
        PutObjectResult pore = this.getClientInstance().putObject(por);
        
        return this.amazonS3Prop.getWaveBucket() + path;
    }
    
    @Override
    public String getPublicUrl(String path)
    {
        String splitter  = "";
        
        if(0 < path.length() && !path.startsWith("/")) {
            splitter = "/";
        }
            
        return this.amazonS3Prop.getDomain() + this.amazonS3Prop.getPrefix() + splitter + path; 
    }
    
    
    @Override
    public void deleteFile(String key)
    {
        String bucketPath = key.substring(0);
        
        if( 0< key.length() 
                && !key.startsWith("/") ) {
            bucketPath = "/" + key;
        }
        S3Object obj = null;
        try {
            DeleteObjectsRequest deleteReq = new DeleteObjectsRequest(this.amazonS3Prop.getWaveBucket());
            deleteReq.withKeys( this.amazonS3Prop.getPrefix().substring(1) + bucketPath);
                                
            DeleteObjectsResult deleteResults = this.getClientInstance().deleteObjects(deleteReq);
            LOG.debug("DETELET S3 Obj == " + deleteResults.toString() );
        }catch(AmazonS3Exception e) {
            LOG.error("Bucket = " + this.amazonS3Prop.getWaveBucket() 
             + "\n" + "Key-ID= " + this.amazonS3Prop.getPrefix().substring(1) + bucketPath ,e);
            
        }
    }

    private AmazonS3 getClientInstance()
    {
        
        if( null == this.amazonS3 ) {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials( 
                                                    this.amazonCredential.getAccessKeyId()
                                                    ,  this.amazonCredential.getSecretKeyId());
            
            
            AWSStaticCredentialsProvider privider =new AWSStaticCredentialsProvider(awsCreds);
            AmazonS3 s3Client = AmazonS3ClientBuilder
                    .standard()
                    .withCredentials(privider)
                    .withRegion("ap-northeast-2")
                    .build();
            this.amazonS3 = s3Client;
        }
        return this.amazonS3;
    }

    @Override
    public String writeSensorLog(InputStream is, String path)
    {
        ObjectMetadata meta = new ObjectMetadata();
        meta.setHeader("Content-Type", "text/plain");
        
        AccessControlList acl = new AccessControlList();
        acl.grantPermission( GroupGrantee.AllUsers, Permission.Read);
        
        String bucketPath = path.substring(0);
        if( 0< path.length() && !path.startsWith("/")) {
            bucketPath = "/" + path;
        }

        PutObjectRequest por = new PutObjectRequest( this.amazonS3Prop.getWaveBucket()
                , this.amazonS3Prop.getLogBackPrefix().substring(1) + bucketPath 
                , is
                , meta);
        por.withAccessControlList(acl);
        por.getRequestClientOptions().setReadLimit(100000000);
        PutObjectResult pore = this.getClientInstance().putObject(por);
        
        return this.amazonS3Prop.getWaveBucket() + path;
    }

}
