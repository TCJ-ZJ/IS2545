import java.util.Random;

import com.tshana.myTool.*;

public class CitySim9002 {

	public static void main(String[] args) {
		if(args.length>1||args.length<=0){
			message();
		}else if(!CheckArgument.isNumber(args[0])){
			message();
		}
		System.out.println("Welcome to CitySim!  Your seed is "+args[0]+".");
		int seed = Integer.parseInt(args[0]);
		Visitor[] visitors = new Visitor[5];
		Random ran = new Random(seed);
		for(int i=0;i<5;i++){
			int k = ran.nextInt(4);
			visitors[i] = new Visitor();
			visitors[i].setParam(i,k);
			visitors[i].visitorStart();
			System.out.println("***");
		}
	}
	
	public static void message(){
		System.out.println("Please enter one integer argument, seed");
		System.exit(0);
		
	}

}
