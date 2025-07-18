package Thread;

public class ThreadPrintEvenOdd implements Runnable{
    static int count=1;
    int range=200;
    Object object;

    ThreadPrintEvenOdd(Object object){
      this.object=object;
    }
    @Override
    public void run() {
while(count<=range){
    if(count %2 ==0 && Thread.currentThread().getName().equals("even")){
        synchronized (object){
            System.out.println("Thread Name:"+Thread.currentThread().getName()+"value::"+count);
            count++;
            try {
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    if(count%2 !=0 && Thread.currentThread().getName().equals("odd")){
        synchronized (object){
            System.out.println("Thread Name:"+Thread.currentThread().getName()+"value::"+count);
         count++;
           object.notifyAll();
        }
    }
}
    }

    public static void main(String[] args) {
        Object lock=new Object();
        Runnable r1=new ThreadPrintEvenOdd(lock);
        Runnable r2=new ThreadPrintEvenOdd(lock);
        new Thread(r1, "even").start();
        new Thread(r2, "odd").start();
    }
}
