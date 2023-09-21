package com.aurionpro.model;

public class Laptop implements IGadget{
	private int id;
	private String brand;
	private String hdd;
	private String processor;
	private String ram;
	private boolean touchscreen;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public boolean isTouchscreen() {
		return touchscreen;
	}
	public void setTouchscreen(boolean touchscreen) {
		this.touchscreen = touchscreen;
	}
	@Override
	public int getID() {
		return 0;
	}
	
}
