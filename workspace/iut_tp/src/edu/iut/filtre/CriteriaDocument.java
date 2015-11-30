package edu.iut.filtre;

import java.util.ArrayList;
import java.util.List;

import edu.iut.app.Document;
import edu.iut.app.ExamEvent;

public class CriteriaDocument {
	private Document critere;
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
	public Document getCritere() {
		return critere;
	}
	public void setCritere(Document critere) {
		this.critere = critere;
	}

}

