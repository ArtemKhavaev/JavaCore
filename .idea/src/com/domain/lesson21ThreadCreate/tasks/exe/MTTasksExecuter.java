package com.domain.lesson21ThreadCreate.tasks.exe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MTTasksExecutor {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try {
            switch (br.readLine()){
                case "time":
                    pool.execute(new Thread1());
                    break;
                case "help":
                    pool.execute(new Thread2());
                    break;
                case "getFromFile":
                    pool.execute(new Thread3());
                    break;
                default:
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

