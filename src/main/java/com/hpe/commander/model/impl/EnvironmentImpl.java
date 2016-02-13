package com.hpe.commander.model.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hpe.commander.model.Environment;
import com.hpe.commander.model.Server;

public class EnvironmentImpl implements Environment {

    public EnvironmentImpl(List<Server> paramServerList) {
        super();
        this.paramServerList = paramServerList;
    }

    @Override
    public String start() {
        String resultado = "Nothing done!!!";
        resultado = startStop(paramServerList, Operation.START);
        return resultado;
    }

    @Override
    public String stop() {
        String resultado = "Nothing done!!!";
        ArrayList<Server> reverseOrderList = new ArrayList<Server>(paramServerList);
        Collections.reverse(reverseOrderList);
        resultado = startStop(reverseOrderList, Operation.STOP);
        return resultado;
    }

	private String startStop(List<Server> serverList, Operation operation) {
		String resultado = "";
		List<StartStopRunnable> startersList = new ArrayList<StartStopRunnable>();
        for (Server server : serverList) {
            StartStopRunnable starter = new StartStopRunnable(server, operation);
            Thread thread = new Thread(starter);
            thread.start();
            while (!starter.isStarted()) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            };
            startersList.add(starter);
        }
        for (StartStopRunnable starter : startersList) {
            while (!starter.isFinished()) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        for (StartStopRunnable starter : startersList) {
            resultado += "\n\r";
            resultado += operation.equals(Operation.START) ? "Starting" : "Stoppping";
            resultado += " " + starter.getDescription()+"\n\r";
            resultado += starter.getResult();
            resultado += "\n\r" + starter.getDescription()+" ";
            resultado += operation.equals(Operation.START) ? "started" : "stopped";
            resultado += " \n\r";
        }
		return resultado;
	}

    private List<Server> paramServerList = null;
}
