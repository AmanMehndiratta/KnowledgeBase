package utilities;

public class DatabaseQueries {

	public static final String getPendingDiscussionsCount = "Select count(*) from topic where TopicType = 0 and pending = 1;";
}
