/*
+--------------------------------------------------+
|                   Lecturer          			   |
+--------------------------------------------------+
|-name:String             						   |
|-specialization:ArrayList<String>                 |
|+availability:ArrayList<Integer>                  |
+--------------------------------------------------+
|+setName(arg:String):void                         |
|+addSpecialization(arg:String):void               |
|+addSpecialization(args:ArrayList<String>):void   |
|+addAvailability(arg:int):void                    |
|+removeAvailability(arg:int):void                 |
|+getName():String                                 |
|+getSpecialization():ArrayList<String>            |
|+getAvailability():ArrayList<Integer>             |
|+equals(other:Object):boolean                     |
|+toString():String                                |
+--------------------------------------------------+
*/

package courseschedule;

import java.util.*;

public class Lecturer extends Support {

	public Lecturer() {
		super();
	}

	public Lecturer(String name) {
		setName(name);
		Arrays.fill(availability[0], true);
		Arrays.fill(availability[1], true);
	}

	public Lecturer(String name, Course specialization) {
		setName(name);
		addCourse(specialization);
		Arrays.fill(availability[0], true);
		Arrays.fill(availability[1], true);
	}

	public Lecturer(String name, ArrayList<Course> specialization) {
		setName(name);
		addCourses(specialization);
		Arrays.fill(availability[0], true);
		Arrays.fill(availability[1], true);
	}

	public Lecturer(String name, Course specialization, boolean[][] availability) {
		setName(name);
		addCourse(specialization);
		setAvailability(availability);
	}

	public Lecturer(String name, ArrayList<Course> specialization, boolean[][] availability) {
		setName(name);
		addCourses(specialization);
		setAvailability(availability);
	}

	/**
	 * Return an array list of strings of specialization fields of the lecturer.
	 *
	 * @return array list of course codes
	 */
	public ArrayList<String> getSpecializations() {
		return getCourses();
	}

	/**
	 * Receives an object and if the object is an instance of Lecturer, compare their names
	 * ignoring cases to determine if they are equals.
	 *
	 * @param other expecting an object of type Lecturer to compare otherwise, return false without comparing
	 *
	 * @return true if both Lecturer are equals otherwise false
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Lecturer))
			return false;

		Lecturer that = (Lecturer) other;

		return this.name.equalsIgnoreCase(that.name);
	}

	public String getDetails() {
		return getName() + ";" + getSpecializations() + ";" + getAvailability_inWords();
	}
}