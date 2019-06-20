package pack;

public class Employee {  
private int topicid;

private String name, description;  

public Employee( String name, String description) {
	super();
	this.name = name;
	this.description = description;
}

public Employee() {
}
public int getTopicid() {
	return topicid;
}
public void setTopicid(int topicid) {
	this.topicid = topicid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

  
} 
