package assignment1;

public class Entity {
	private String name;
	private Date born;
	
	public Entity(String name, Date birthDate) {
		this.name = name;
		this.born = new Date(birthDate); //no privacy leak
	}
	
	public Entity(Entity entity) {
		this.name = entity.name;
		this.born = new Date(entity.born); //no privacy leak
	}

	public String getName() {
		return name;
	}

	public Date getBorn() {
		return new Date(born);
	}
	
	public String toString() {
		return "Name: "+name+"\n"+"Born at: "+born.toString()+"\n";
	}
}
