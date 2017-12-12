package kr.softwarearchitect.springboot.util;

import org.junit.Test;

import com.google.common.collect.EvictingQueue;

public class ArrayBlockingQueueTest
{
    @Test
    public void queueTest()
    {
        System.out.println("@#$%^&*(");
        EvictingQueue q = EvictingQueue.create(10);
        q.add(new Integer(1));
        q.add(new Integer(2));
        q.add(new Integer(3));
        q.add(new Integer(4));
        q.add(new Integer(5));
        q.add(new Integer(6));
        q.add(new Integer(7));
        q.add(new Integer(8));
        q.add(new Integer(9));
        q.add(new Integer(10));
        q.add(new Integer(11));
        q.add(new Integer(12));
                        
        q.poll();
            
            System.out.println("###");
        
        
    }
    

}
