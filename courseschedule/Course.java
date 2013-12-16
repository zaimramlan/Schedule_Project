/*
+---------------------------------------------------------------------------------+
|			course                                                                |
+---------------------------------------------------------------------------------+
|-code:String                                                                     |
|-title:String                                                                    |
|-credit:int                                                                      |
|-requiredSections:int                                                            |
+---------------------------------------------------------------------------------+
|-constructor(code:String,title:String,credit:int,requiredSections:int):void      |
|+setCredit(arg:int):void                                                         |
|+setRequiredSections(arg:int):void                                               |
|+setTitle(arg:String):void                                                       |
|+setCode(arg:String):void                                                        |
|+getCredit():int                                                                 |
|+getRequiredSections():int                                                       |
|+getCode():String                                                                |
|+getTitle():String                                                               |
|+equals(other:Object):boolean                                                    |
|+toString():String                                                               |
+---------------------------------------------------------------------------------+
*/

package courseschedule;

public class Course {
	private String code, title = null;
	private int credit = 3, requiredSections = 1;

	public Course(String code) {
		this(code, null, 3, 1);
	}

	public Course(String code, String title) {
		this(code, title, 3, 1);
	}

	public Course(String code, String title, int credit) {
		this(code, title, credit, 1);
	}

	public Course(String code, String title, int credit, int requiredSections) {
		setCode(code);
		setTitle(title);
		setCredit(credit);
		setRequiredSections(requiredSections);
	}

	public void setCredit(int arg) {
		credit = arg;
	}

	public int getCredit() {
		return credit;
	}

	public void setRequiredSections(int arg) {
		requiredSections = arg;
	}

	public int getRequiredSections() {
		return requiredSections;
	}

	public void setCode(String arg) {
		if (arg != null)
			code = arg.replaceAll("\\s", "").toUpperCase();
	}

	public String getCode() {
		return code;
	}

	public void setTitle(String arg) {
		if (arg != null)
			title = arg;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Course))
			return false;

		Course that = (Course) other;

		return this.code.equalsIgnoreCase(that.code) && this.title.equalsIgnoreCase(that.title);
	}

	public int compareTo(Course other) {
		if (other.equals(this))
			return 0;

		return getCode().compareTo(other.getCode());
	}

	public String getDetails() {
		return getCode() + ";" + getTitle() + ";" + getCredit() + ";" + getRequiredSections();
	}

	public String[] detailsArray() {
		String[] str = new String[4];
		str[0] = getCode();
		str[1] = getTitle();
		str[2] = Integer.toString(getCredit());
		str[3] = Integer.toString(getRequiredSections());
		return str;
	}

	public String[] getCodeandTitle() {
		String[] str = new String[2];
		str[0] = getCode();
		str[1] = getTitle();
		return str;
	}

	public String toString() {
		return getCode() + " " + getTitle() + " " + getCredit();
	}
}