package gui;

import core.Editor;

public class Mediator {

	private String selected;
	public Editor editor;
	

	
	public Mediator() {
		selected=null;	
		editor = new Editor(2000,2000);
	}
	
	public Mediator(int x,int y){
		selected=null;
		editor = new Editor(x,y);
	}
	

	
	public void setSelected(String t){
		selected=t;
	}
	public String getSelected(){
		return selected;
	}
	

	
}
