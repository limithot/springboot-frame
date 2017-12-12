package kr.softwarearchitect.springboot.modules.react.akka;

import org.json.JSONArray;

import java.io.InputStream;
import java.io.Serializable;

/*
@Named
@Scope("prototype")
public class SensorDataLoadActor extends AbstractActor implements RequiresMessageQueue<BoundedMessageQueueSemantics> 
{
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private final static Logger LOG = LoggerFactory.getLogger(SensorDataLoadActor.class);
    
    @Inject
    private SynsensorService synsensorService;

    @Override
    public Receive createReceive()
    {
        Receive receive = super.receiveBuilder().match(SensorDataLoadActoDTO.class, dto -> {
            try {
                this.synsensorService.storeSensorData(dto.getSynsensorId(),  dto.getData() , dto.getFile() );
            }catch(Exception e) {
                LOG.error("",e);
            }
            super.sender().tell("OK", this.self());
        }).build();
        return receive;
    }
    
    public static class SensorDataLoadActoDTO implements Serializable
    {


        private static final long serialVersionUID = 4361703331986691984L;
        
        private JSONArray data;
        private InputStream file;
        private long synsensorId;
        
        public SensorDataLoadActoDTO(long synsensorId, JSONArray jsonArray, InputStream is)
        {
            this.synsensorId = synsensorId;
            this.data = jsonArray;
            this.file = is;
            
        }
        
        public JSONArray getData()
        {
            return data;
        }
        public void setData(JSONArray data)
        {
            this.data = data;
        }
        public InputStream getFile()
        {
            return file;
        }
        public void setFile(InputStream file)
        {
            this.file = file;
        }

        public long getSynsensorId()
        {
            return synsensorId;
        }

        public void setSynsensorId(long synsensorId)
        {
            this.synsensorId = synsensorId;
        }
    }
}
*/
public class SensorDataLoadActor
{
    
    public static class SensorDataLoadActoDTO implements Serializable
    {


        private static final long serialVersionUID = 4361703331986691984L;
        
        private JSONArray data;
        private InputStream file;
        private long synsensorId;
        
        public SensorDataLoadActoDTO(long synsensorId, JSONArray jsonArray, InputStream is)
        {
            this.synsensorId = synsensorId;
            this.data = jsonArray;
            this.file = is;
            
        }
        
        public JSONArray getData()
        {
            return data;
        }
        public void setData(JSONArray data)
        {
            this.data = data;
        }
        public InputStream getFile()
        {
            return file;
        }
        public void setFile(InputStream file)
        {
            this.file = file;
        }

        public long getSynsensorId()
        {
            return synsensorId;
        }

        public void setSynsensorId(long synsensorId)
        {
            this.synsensorId = synsensorId;
        }
    }
}

