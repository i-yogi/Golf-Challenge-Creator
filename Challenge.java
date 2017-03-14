import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yogi on 3/14/17.
 */
public class Challenge implements ChallengeManager {

    //For each challenge (instance) following Collections are maintained

    private HashMap<Long, String> userList = new HashMap<>();
    private HashMap<Long, Round> userRounds = new HashMap<>();
    private HashMap<Long, Long> userRank = new HashMap<>();


    @Override
    public void addUser(long userId, String username) {
        userList.put(userId, username);
    }

    @Override
    public HashMap<Long, String> getUsers() {
        return this.userList;
    }

    //Created custom round object

    @Override
    public void addUserRound(long userId, long roundId, double primaryStat, double secondaryStat) {
        Round round = new Round(userId, roundId, primaryStat, secondaryStat);

        //Whenever a new round is being recorded for a user, the user's rank is updated.
        updateRank(round);
        userRounds.put(roundId, round);
    }


    //Naive Ranking mechanism. Can be improved id necessary.
    private void updateRank(Round round) {

        long primaryStat = 0;
        long secondaryState = 0;

        List<Round> userRound = new ArrayList<>();

        for( long key : this.userRounds.keySet()){
            Round rnd = this.userRounds.get(key);
            if(rnd.getUserId() == round.getUserId())
                userRound.add(rnd);
        }

        for( Round uRound : userRound){
            primaryStat += uRound.getPrimaryStat();
            secondaryState += uRound.getSecondaryStat();

            if(primaryStat < secondaryState)
                this.userRank.put(round.getUserId(), primaryStat % userList.size());
            else
                this.userRank.put(round.getUserId(), secondaryState % userList.size());
        }
    }

    @Override
    public void removeUserRound(long userId, long roundId) {
        this.userRounds.remove(roundId);
    }

    @Override
    public List<Round> getUserRounds(long userId) {

        //List of all records is traversed to find the user's rounds
        //A list containing all the rounds of the user is returned.

        List<Round> userRounds = new ArrayList<>();

        for( long key : this.userRounds.keySet()){

            Round rnd = this.userRounds.get(key);
            if(rnd.getUserId() == userId)
                userRounds.add(rnd);
        }
        return userRounds;
    }

    //Efficient look up by using HashMap<Key: UserId, Value: Rank>. Constant time complexity.
    @Override
    public long getUserRank(long userId) {
        return this.userRank.get(userId);
    }
}
