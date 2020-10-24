package com.example.internshipExercises.util;

import java.util.concurrent.Executor;

public class DataBindExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }
}
