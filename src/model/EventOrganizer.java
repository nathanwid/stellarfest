package model;

import java.util.ArrayList;

public class EventOrganizer extends User {
	private ArrayList<String> events_created;
	
	public EventOrganizer(String user_id, String user_name, String user_email, String user_password, String user_role, 
			ArrayList<String> events_created) {
		super(user_id, user_name, user_email, user_password, user_role);
		this.setEvents_created(events_created);
	}

	public ArrayList<String> getEvents_created() {
		return events_created;
	}

	public void setEvents_created(ArrayList<String> events_created) {
		this.events_created = events_created;
	}
	
}
