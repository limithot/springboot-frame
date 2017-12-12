package kr.softwarearchitect.springboot.frame.configuration.react;


import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

public class Producer implements IndirectActorProducer
{
    final ApplicationContext applicationContext;
    final String actorBeanName;

    public Producer(ApplicationContext applicationContext,
                               String actorBeanName) {
      this.applicationContext = applicationContext;
      this.actorBeanName = actorBeanName;
    }

    @Override
    public Actor produce() {
      return (Actor) applicationContext.getBean(actorBeanName);
    }

    @Override
    public Class<? extends Actor> actorClass() {
      return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }
}