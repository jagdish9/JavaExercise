package com.java.StringAndArray;
import java.util.*;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable
{
 private final BlockingQueue queue;
 
 Producer(BlockingQueue q)
  {
    this.queue = q;
  }
  
 public void run()
 {
    try
	{
	  while(true)
	  {
	     queue.put(produce());
	  }
	}
	catch(InterruptedException ie)
	{
	   ie.printStackTrace();
	}
 }
 
 Object produce()
 {
	return queue;
 }
}

class Consumer implements Runnable
{
 private final BlockingQueue queue;
  Consumer(BlockingQueue q)
   {
     queue = q;
   }
  public void run()
  {
    try
	 {
	   while(true)
	   {
	     consume(queue.take());
	   }
	 }
	 catch(InterruptedException ie)
	 {
	   ie.printStackTrace();
	 }
	
  }
  
  void consume(Object x)
  {
  }
}

public class SetUp
{
  public static void main(String... args)
  {
    BlockingQueue q = (BlockingQueue) new LinkedList();
	Producer p = new Producer(q);
	Consumer c1 = new Consumer(q);
	Consumer c2 = new Consumer(q);
	new Thread(p).start();
	new Thread(c1).start();
	new Thread(c2).start();
  }
}