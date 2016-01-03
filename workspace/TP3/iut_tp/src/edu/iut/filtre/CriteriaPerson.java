package edu.iut.filtre;

import java.util.ArrayList;
import java.util.List;

import edu.iut.app.ExamEvent;
import edu.iut.app.Person;

public class CriteriaPerson {
	private Person critere;
	public List<ExamEvent> meetCriteria(List<ExamEvent> ee) {
		// TODO Auto-generated method stub
		List<ExamEvent> CP = new ArrayList<ExamEvent>();
		if(critere!=null){
		for (ExamEvent examEvent : ee){
			if(examEvent.getClassroom().equals(critere)){
				CP.add(examEvent);
				}				
			}
		}
		return CP;
	}
	public Person getCritere() {
		return critere;
	}
	public void setCritere(Person critere) {
		this.critere = critere;
	}

}
