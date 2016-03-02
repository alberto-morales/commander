package com.hpe.commander.model.impl;

import com.hpe.commander.model.CommandRunner;
import com.hpe.commander.model.HostConfig;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class CommandRunnerImpl implements CommandRunner {

	@Override
	public String run(String command, HostConfig hostConfig) {
		JSch jsch   = new JSch();
		String result = "";
		Session session = null;
		ChannelExec channel = null;
	    try {
	    	log.info("Running command '"+command+"' on server '"+hostConfig.getAddress()+"'");
	        session = jsch.getSession(hostConfig.getUsername(),
	        								  hostConfig.getAddress(),
	        								  hostConfig.getSSHPort());
	        session.setPassword(hostConfig.getPassword());
	        session.setConfig("StrictHostKeyChecking", "no");
	        session.connect();

	        channel=(ChannelExec) session.openChannel("exec");
	        BufferedReader in=new BufferedReader(new InputStreamReader(channel.getInputStream()));
	        channel.setCommand(command+";");
	        channel.connect();

	    	log.debug("(connected) Running command '"+command+"' on server '"+hostConfig.getAddress()+"'");

	    	String msg=null;
	        while((msg=in.readLine())!=null){
	        	result += msg;
	        }

	    	log.debug("(finished) Running command '"+command+"' on server '"+hostConfig.getAddress()+"'");

	    } catch (Exception e) {
	    	log.warn("(Exception) Running command '"+command+"' on server '"+hostConfig.getAddress()+"'", e);
	    	result = e.getMessage();
	    } finally {
	    	try {
		        channel.disconnect();
		        session.disconnect();
	    	} catch (Exception e) {
	    		log.error(e);
	    	}
	    }
	    return result;
	}

	private static Log log = LogFactory.getLog(CommandRunnerImpl.class);

}
