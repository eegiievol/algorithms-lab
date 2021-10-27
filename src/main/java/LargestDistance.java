import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.TimeUnit;

public class LargestDistance {
    List<Integer> list;

    public LargestDistance() {
        this.list = new ArrayList<Integer>();
    }

    public void GenerateNumbers(int size){
        Random rand = new Random();
        for(int i=0; i<size; i++){
            list.add(rand.nextInt(99999/*random number range*/));
        }
    }

    public int AlgoOne(){
        int maxDist = Integer.MIN_VALUE;
        List<Integer> tmpList = new ArrayList<Integer>();

        //extra array of even only numbers
        for (int i=0; i<this.list.size(); i++){
            if(this.list.get(i)%2==0){
                tmpList.add(this.list.get(i));
            }
        }

        for (int i=0; i<tmpList.size()-1; i++){
            for (int j=i+1; j<tmpList.size(); j++){
                if(Math.abs(tmpList.get(i)-tmpList.get(j)) > maxDist){
                    maxDist = Math.abs(tmpList.get(i)-tmpList.get(j));
                }
            }
        }
        return  maxDist;
    }

    public int AlgoTwo(){
        int maxDist = Integer.MIN_VALUE;

        for (int i=0; i<this.list.size()-1; i++){
            if(this.list.get(i)%2==0) {
                for (int j = i + 1; j < this.list.size(); j++) {
                    if (this.list.get(j)%2==0 && Math.abs(this.list.get(i)-this.list.get(j)) > maxDist) {
                        maxDist = Math.abs(this.list.get(i) - this.list.get(j));
                    }
                }
            }
        }
        return  maxDist;
    }

    public int AlgoThree(){
        int maxDist = Integer.MIN_VALUE;
        int minDist = Integer.MAX_VALUE;

        for (int i=0; i<this.list.size()-1; i++){
            if(this.list.get(i)%2==0) {
                if(this.list.get(i)>maxDist){
                    maxDist = this.list.get(i);
                }
                else if(this.list.get(i)<minDist){
                    minDist = this.list.get(i);
                }
            }
        }
        return  maxDist-minDist;
    }

    public int AlgoFour(){
        int max = this.list.stream()
                .filter(l->l%2==0)
                .reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b))
                .intValue();
        int min = this.list.stream()
                .filter(l->l%2==0)
                .reduce(Integer.MAX_VALUE, (a, b) -> Integer.min(a, b))
                .intValue();
        this.list.clear();
        return max-min;
    }

    public static void main(String[] args) {
        long start;
        long finish;
        LargestDistance largestDistance = new LargestDistance();

        for(int i=1000; i<=10000; i+=1000) {
            largestDistance.GenerateNumbers(i);
            System.out.println("\n===sequence length===: "+i);

            //algo1
            start=System.nanoTime();
            System.out.println("First Algorithm: " + largestDistance.AlgoOne());
            finish=System.nanoTime();
            System.out.println("_execution time ns: "+ (finish-start));
            //algo2
            start=System.nanoTime();
            System.out.println("Second Algorithm: " + largestDistance.AlgoTwo());
            finish=System.nanoTime();
            System.out.println("_execution time ns: "+ (finish-start));
            //algo3
            start=System.nanoTime();
            System.out.println("Third Algorithm: " + largestDistance.AlgoThree());
            finish=System.nanoTime();
            System.out.println("_execution time ns: "+ (finish-start));
            //algo4
            start=System.nanoTime();
            System.out.println("Fourth Algorithm: " + largestDistance.AlgoFour());
            finish=System.nanoTime();
            System.out.println("_execution time ns: "+ (finish-start));
        }
    }

}
