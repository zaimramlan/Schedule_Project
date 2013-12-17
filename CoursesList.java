
import courseschedule.*;
import courseschedule.util.*;

import java.util.*;

public class CoursesList extends DropList {

	public CoursesList(ScheduleBuilder sb, ArrayList<String> lCourses, int limit) {
		super(sb, lCourses, limit);
	}

	public ArrayList<Course> getCourses() {
		Collections.sort(lCourses);
		String[] c = lCourses.toString().replaceAll("[\\[\\] ]", "").split(",");
		return sb.getCourses(c);
	}
}