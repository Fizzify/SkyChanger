/*
 * SkyChanger
 * Copyright (C) 2017 Daniel D. Scalzi
 * See License.txt for license information.
 */
package com.dscalzi.skychanger;

import org.bstats.Metrics;
import org.bukkit.plugin.java.JavaPlugin;
import com.dscalzi.skychanger.managers.ConfigManager;
import com.dscalzi.skychanger.managers.MessageManager;

public class SkyChanger extends JavaPlugin{

	private boolean metricsEnabled = false;
	
	@Override
	public void onEnable(){
		ConfigManager.initialize(this);
		MessageManager.initialize(this);
		this.getCommand("skychanger").setExecutor(new MainExecutor(this));
		this.enableMetrics();
	}
	
	@Override
	public void onDisable(){
		//Nothing for now.
	}
	
	public void enableMetrics(){
		if(metricsEnabled) return;
		if(!ConfigManager.getInstance().metricsOptOut()){
			@SuppressWarnings("unused")
			Metrics metrics = new Metrics(this);
			metricsEnabled = true;
		} else
			MessageManager.getInstance().logMetricsOptOut();
	}
	
}
