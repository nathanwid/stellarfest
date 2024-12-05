package model;

import java.util.ArrayList;

public class Guest extends User {
	private ArrayList<Invitation> accepted_invitations;
	
	public Guest(String user_id, String user_name, String user_email, String user_password, String user_role, 
			ArrayList<Invitation> accepted_invitations) {
		super(user_id, user_name, user_email, user_password, user_role);
		this.accepted_invitations = accepted_invitations;
	}

	public ArrayList<Invitation> getAccepted_invitations() {
		return accepted_invitations;
	}

	public void setAccepted_invitations(ArrayList<Invitation> accepted_invitations) {
		this.accepted_invitations = accepted_invitations;
	}
	
}
