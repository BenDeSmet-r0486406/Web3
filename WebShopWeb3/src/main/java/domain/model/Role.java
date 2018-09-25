package domain.model;

public enum Role {
	CUSTOMER(1),
	ADMINISTRATOR(2);
	
	private int roleNumber;
	
	private Role (int value){   
		this.roleNumber = value;  
	}
	public int getRoleNumber(){
		return this.roleNumber;
	}
}
