package com.meixiang.beauty.webapp.vehicle.disruptor;

import com.aliyun.opensearch.sdk.dependencies.com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class MainT {


    public static void main(String args[]) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String s = sdf.format(new Date());

        JFrame jFrame = new JFrame("数据清洗");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 添加 "Hello World" 标签
        JLabel productlabel = new JLabel(s);
        JLabel consumerlabel = new JLabel(s);
        jFrame.setBounds(250,250,600,200);
        jFrame.getContentPane().add(productlabel, BorderLayout.NORTH);
        jFrame.getContentPane().add(consumerlabel, BorderLayout.SOUTH);
        // 显示窗口
        jFrame.pack();
        jFrame.setVisible(true);

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
        ExecutorService fixedThreadPool = new ThreadPoolExecutor(10,20,200L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory,bufferSize,fixedThreadPool,
                ProducerType.MULTI,new YieldingWaitStrategy());

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();

        disruptor.handleEventsWithWorkerPool(new Consumer(consumerlabel),new Consumer(consumerlabel),new Consumer(consumerlabel));
        disruptor.start();

        Producer producer = new Producer(ringBuffer,productlabel);
        producer.beginProduce();

        disruptor.shutdown();
        fixedThreadPool.shutdown();

        System.out.println("消费开始================="+s);
        System.out.println("消费结束================="+sdf.format(new Date()));
        productlabel.setText("消费开始"+s+"-------------"+"消费结束"+sdf.format(new Date()));
    }

}
