package com.yh.applet.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class ForkJoinPoolTest {
	
	@Test
	public void getResult() {
		//定义你期望的并行级别(这里的4)。并行级别表示你想要传递给 ForkJoinPool 的任务所需的线程或 CPU 数量。
		ForkJoinPool forkJoinPool = new ForkJoinPool(4);  
		
		MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);  
		forkJoinPool.invoke(myRecursiveAction);
	}
	
	@Test
	public void makeMoneyTest() throws InterruptedException, ExecutionException {
		//默认并行级别:运行时计算机的处理器数量
		ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new MakeMoneyTask(1000000));
//        do {
//            try {
//                TimeUnit.MILLISECONDS.sleep(5);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }while (!task.isDone());
        task.join();
        pool.shutdown();
        System.out.println(task.get());
	}
	
	//RecursiveAction 是一种没有任何返回值的任务。它只是做一些工作，比如写数据到磁盘，然后就退出了。
	class MyRecursiveAction extends RecursiveAction {  
		  
		private static final long serialVersionUID = 1L;
		private long workLoad = 0;  
	  
	    public MyRecursiveAction(long workLoad) {  
	        this.workLoad = workLoad;  
	    }  
	  
	    @Override  
	    protected void compute() {  
	  
	        //if work is above threshold, break tasks up into smaller tasks  
	        if(this.workLoad > 16) {  
	            System.out.println("Splitting workLoad : " + this.workLoad);  
	  
	            List<MyRecursiveAction> subtasks =  
	                new ArrayList<MyRecursiveAction>();  
	  
	            subtasks.addAll(createSubtasks());  
	  
	            for(RecursiveAction subtask : subtasks){  
	                subtask.fork();  
	            }  
	  
	        } else {  
	            System.out.println("Doing workLoad myself: " + this.workLoad);  
	        }  
	    }  
	  
	    private List<MyRecursiveAction> createSubtasks() {  
	        List<MyRecursiveAction> subtasks =  
	            new ArrayList<MyRecursiveAction>();  
	  
	        MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);  
	        MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);  
	  
	        subtasks.add(subtask1);  
	        subtasks.add(subtask2);  
	  
	        return subtasks;  
	    }  
	  
	}  
	
	//RecursiveTask 是一种会返回结果的任务。它可以将自己的工作分割为若干更小任务，并将这些子任务的执行结果合并到一个集体结果。
	public static class MakeMoneyTask extends RecursiveTask<Integer>{

		private static final long serialVersionUID = 1L;
		private static final int MIN_GOAL_MONEY = 100000;
	    private int goalMoney;
	    private String name;
	    private static final AtomicLong employeeNo = new AtomicLong();
	    public MakeMoneyTask(int goalMoney){
	        this.goalMoney = goalMoney;
	        this.name = "员工" + employeeNo.getAndIncrement() + "号";
	    }
	    @Override
	    protected Integer compute() {
	        if (this.goalMoney < MIN_GOAL_MONEY){
	            System.out.println(name + ": 老板交代了,要赚 " + goalMoney + " 元,为了买车买房,加油吧....");
	            return makeMoney();
	        }else{
	            int subThreadCount = ThreadLocalRandom.current().nextInt(10) + 2;
	            System.out.println(name + ": 上级要我赚 " + goalMoney + ", 有点小多,没事让我" + subThreadCount + "个手下去完成吧," +
	                    "每人赚个 " + Math.ceil(goalMoney * 1.0 / subThreadCount) + "元应该没问题...");
	            List<MakeMoneyTask> tasks = new ArrayList<MakeMoneyTask>();
	            for (int i = 0; i < subThreadCount; i ++){
	                tasks.add(new MakeMoneyTask(goalMoney / subThreadCount));
	            }
	            Collection<MakeMoneyTask> makeMoneyTasks = invokeAll(tasks);
	            int sum = 0;
	            for (MakeMoneyTask moneyTask : makeMoneyTasks){
	                try {
	                    sum += moneyTask.get();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	            System.out.println(name + ": 嗯,不错,效率还可以,终于赚到 " + sum + "元,赶紧邀功去....");
	            return sum;
	        }
	    }

	    private Integer makeMoney(){
	        int sum = 0;
	        int day = 1;
	        try {
	            while (true){
	                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
	                int money = ThreadLocalRandom.current().nextInt(MIN_GOAL_MONEY / 3);
	                System.out.println(name + ": 在第 " + (day ++) + " 天赚了" + money);
	                sum += money;
	                if (sum >= goalMoney){
	                    System.out.println(name + ": 终于赚到 " + sum + " 元, 可以交差了...");
	                    break;
	                }
	            }
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        return sum;
	    }
	}  

}
