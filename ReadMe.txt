Given interface:

class ChallengeManager {
	void addUser(uint64_t userId, std::string username);
	void addUserRound(uint64_t userId, uint64_t roundId, double primaryStat, double secondaryStat);
	void removeUserRound(uint64_t userId, uint64_t roundId);
	uint32_t getUserRank(uint64_t userId);
	std::vector<uint64_t> getUsers();
	std::vector<uint64_t> getUserRounds(uint64_t userId);
}

converted to Java Interface:

public interface ChallengeManager {

	void addUser(long userId, String username);
	HashMap<Long, String> getUsers();

	void addUserRound(long userId, long roundId, double primaryStat, double secondaryStat);
	void removeUserRound(long userId, long roundId);
	List<Round> getUserRounds(long userId);

	long getUserRank(long userId);
}


Assumptions: 
	1. User ID's and Round ID's are unique.
	2. Using 'long' for 'unsigned int of 64 bit'. 
	   Reference: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	3. Instead of vectors used HashMap for constant time 'get()' and 'put()' operations.
	4. Created custom object 'Round' to store information related to a round together.
	   Round: RoundID, UserID, PrimaryStat, SecondaryState
	4. Ranking mechanism: Naive ranking code. Can be improved is necessary.