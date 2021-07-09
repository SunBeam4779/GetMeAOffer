package yuhang.test.com;

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] data = {3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1};
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        System.out.println(predictTheWinner.predictTheWinner(data));

    }

    public boolean predictTheWinner(int[] nums){
        return predict(nums, 1, nums.length - 1, 0, nums[0], 0) ||
                predict(nums, 0, nums.length - 2, 0, nums[nums.length - 1], 0);
    }

    public boolean predict(int[] nums, int first, int last, int turn, long score1, long score2){
        if(first == last){
            if (turn == 1) return score1 + nums[first] >= score2;
            else return score1 >= score2 + nums[first];
        }

        int index;
        if(Math.max(nums[first + 1], nums[last]) < Math.max(nums[first], nums[last - 1])) index = first;
        else index = last;

        if(turn == 1){
            if(index == first) return predict(nums, first + 1, last, 0, score1 + nums[first], score2);
            else
                return predict(nums, first, last - 1, 0, score1 + nums[last], score2);
        }else{
            if(index == first) return predict(nums, first + 1, last, 1, score1, score2 + nums[first]);
            else return predict(nums, first, last - 1, 1, score1, score2 + nums[last]);
        }
    }
}
