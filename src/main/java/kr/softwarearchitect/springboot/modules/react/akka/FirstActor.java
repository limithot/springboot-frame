package kr.softwarearchitect.springboot.modules.react.akka;


import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@Scope("prototype")
public class FirstActor extends AbstractActor
{
    private final static Logger LOG = LoggerFactory.getLogger(FirstActor.class);
    
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
   
    @Inject
    //private ActorTestDAO actorTestDAO;

    @Override
    public Receive createReceive()
    {
        //LOG.error("############### This is FirstActor = " + " ####################3");
        log.error("**************############### This is FirstActor = ####################3");
//        try {
//            Thread.sleep(4000l);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        
        Receive receive = super.receiveBuilder().match(String.class, s -> {
            System.out.println("3#######33333333===================================" + s);
            super.sender().tell(" from actor1", this.self());
        }).build();
        return receive;
    }

}
