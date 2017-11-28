package com.yh.designpattern.publishsubscribe;

import java.util.ArrayList;
import java.util.List;

public class TeacherSubject implements Subject {
	
	List<Observer> obsList = new ArrayList<Observer>();

	@Override
	public void addObserver(Observer obs) {
		obsList.add(obs);
	}

	@Override
	public void deleteObserver(Observer obs) {
		obsList.remove(obs);
	}

	@Override
	public void notifyObserver(String info) {
		for(Observer obs : obsList){
			obs.update(info);
		}
	}

}
