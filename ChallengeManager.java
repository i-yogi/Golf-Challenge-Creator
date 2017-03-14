import java.util.HashMap;
import java.util.List;

/**
 * Created by yogi on 3/14/17.
 */
public interface ChallengeManager {

    void addUser(long userId, String username);
    HashMap<Long, String> getUsers();

    void addUserRound(long userId, long roundId, double primaryStat, double secondaryStat);
    void removeUserRound(long userId, long roundId);
    List<Round> getUserRounds(long userId);

    long getUserRank(long userId);
}
