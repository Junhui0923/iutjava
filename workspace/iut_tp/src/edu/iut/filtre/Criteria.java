package edu.iut.filtre;
import java.util.List;

import edu.iut.app.ExamEvent;

public interface Criteria {
	 public List<ExamEvent> meetCriteria(List<ExamEvent> ee);
	}
