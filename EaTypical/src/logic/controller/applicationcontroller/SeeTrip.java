package logic.controller.applicationcontroller;

import java.sql.SQLException;
import logic.engineeringclasses.dao.SchedulingDAO;
import logic.model.Tourist;

public class SeeTrip {

	public void deleteScheduleTrip(String username) throws ClassNotFoundException, SQLException {
		SchedulingDAO dao = new SchedulingDAO();
		Tourist tourist = new Tourist(null, null, username, null, null);
		dao.delete(tourist);
	}
	
}
