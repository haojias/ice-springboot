package xin.haojias.ice.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * 异步任务
 */
@Component
public class AsyncTask {


    public static Random random =new Random();



    @Async
    public void doTaskTwo() throws Exception {
        return;
    }

    @Async
    public void doTaskThree() throws Exception {
        return;
    }


    /**
     * 回掉任务
     * @return
     * @throws Exception
     */
    @Async
    public Future<String> doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    public static void main(String[] args){
//        Future<String> task1 = task.doTaskOne();
//        Future<String> task2 = task.doTaskTwo();
//        Future<String> task3 = task.doTaskThree();
//
//        while(true) {
//            if(task1.isDone() && task2.isDone() && task3.isDone()) {
//                // 三个任务都调用完成，退出循环等待
//                break;
//            }
//            Thread.sleep(1000);
//        }
//
//        long end = System.currentTimeMillis();
//
//        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");
    }

}
