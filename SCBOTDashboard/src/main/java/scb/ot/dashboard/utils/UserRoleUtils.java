package scb.ot.dashboard.utils;

import scb.ot.dashboard.entity.User;

public class UserRoleUtils {
	
	public static boolean hasReadAllPermission(User user) {
		return user.getRole().getPermission().equalsIgnoreCase("READ_ALL");
	}
	
	public static boolean hasEditPermission(User user) {
		return user.getRole().getPermission().equalsIgnoreCase("TEAM_EDIT");
	}

}
