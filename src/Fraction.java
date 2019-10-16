import java.util.*;
public class Fraction {
	Random random=new Random();
	int numOfFraction = random.nextInt(3)+2; //������ɵķ����ĸ���
	int defaultRange = 10;
	int[] numerator = new int[numOfFraction];//����
	int[] denominator = new int[numOfFraction];//��ĸ

	
	//������ֵ�ķ�Χ
	public void setRange(int a){
		this.defaultRange = a;
	}
	
	public int getRange(){
		return this.defaultRange;
	}
	
	
	public Fraction(){
		for(int i=0;i<numOfFraction;i++){
			int a,b;
			a = random.nextInt(defaultRange);
			b = random.nextInt(defaultRange-1)+1;
			int c = maxcomdivisor(a,b);
			numerator[i] = a/c;
			denominator[i] = b/c;
		}
	}
	
	/*
	 * 
	 * ����������Ȼ������������������ĸ��ֵ��Χ��
	 * ���а����������Լ��������������޸�֮ǰ����ֵ�ĳ�Ա����numerator��denominator����
	 */
	public void reset(int numRange){
		for(int i=0;i<numOfFraction;i++){
			int a,b;
			a = random.nextInt(numRange);
			b = random.nextInt(numRange-1)+1;
			int c = maxcomdivisor(a,b);
			numerator[i] = a/c;
			denominator[i] = b/c;
		}
	}
	//numerator1������1�ķ��ӣ�denomintor1������1�ķ�ĸ��numerator2������2�ķ��ӣ�denomintor2������2�ķ�ĸ��
	//��
	public String add(int numerator1,int denominator1,int numerator2,int denominator2 ){
		int numerator = numerator1*denominator2+denominator1*numerator2;
	    int denominator = denominator1*denominator2;
	    return toString(numerator,denominator);
	}
	//��
	public String sub(int numerator1,int denominator1,int numerator2,int denominator2 ){
		int numerator = numerator1*denominator2-denominator1*numerator2;
	    int denominator = denominator1*denominator2;
	   return toString(numerator,denominator);
	}
	//��
	public String mul(int numerator1,int denominator1,int numerator2,int denominator2 ){
		int numerator = numerator1*numerator2;
	    int denominator = denominator1*denominator2;
	   return toString(numerator,denominator);
	}
	//��
	//�������ķ���Ϊ��ʱ������ķ�ĸ��Ϊ�㣬������ں���toString����Ӧ�Ĵ���
	public String dev(int numerator1,int denominator1,int numerator2,int denominator2 ){
		int numerator = numerator1*denominator2;
	    int denominator = denominator1*numerator2;
	   return toString(numerator,denominator);
	}
	

	//��m��n�����Լ��
	 public static int maxcomdivisor(int m, int n) {
		 if(n==0) return -1;
		 else{
		  while (true) {
		   if ((m = m % n) == 0)	   
		    return n;	  
		   
		   if ((n = n % m) == 0) 
		    return m;		   
		  }
		 }
	 }
	 
	 //��������һ�����Ӻͷ�ĸת����һ���ַ�����ʾ�ķ���
	 //���з�ĸ����Ϊ�㣬���ӻ��ĸ����Ϊ��
	 /*
	  * ���ǵ�����������������Ϊ���������Ҿ���ֵ���ڷ�ĸ����ô����������㷨���Ͳ���ת������õ��Ĵ�������ʽ��
	  * ��������denominatorΪ0�������������㷨���ͻ���ֳ���Ϊ0�������
	  * �����ڷ������һ��ʼ�ͶԷ��ӷ�ĸ�����жϣ���֤�������ȷ�ԣ�
	  * ͬʱ��������ʽ����Ĺ����е��ô˷���ʱ���ܸ��ݷ��ص�N�жϵ������˸����ͳ���Ϊ0�����������������һ�����ʽ����
	  */
	 
	 public String toString(int numerator,int denominator) {
		 
		 if(denominator==0 || numerator<0 || denominator<0)
			 return "N";
		 
		 int c = maxcomdivisor(numerator,denominator);
		 numerator = numerator/c;
		 denominator = denominator/c;
		 /*
		  * �����ĸΪ1���ͽ�����ת�����ַ������أ������жϷ��Ӻͷ�ĸ֮��Ĵ�С��
		  * �����Ӵ��ڷ�ĸʱ�����ٷ���ת����������ַ������أ�������С�ڷ�ĸʱ��ֱ�������������ʽ����
		  */
		 
		 if(denominator==1) {
	         return String.valueOf(numerator);
	     }else
	         if(numerator>denominator) {
	             return String.format("%d'%d/%d", numerator/denominator,numerator%denominator,denominator);
	         }else {
	             return String.format("%d/%d", numerator,denominator);
	         }
	    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Fraction f = new Fraction();/*
	  for(int i=0;i<f.numerator.length;i++){
		  System.out.println(f.numerator[i]);
		  System.out.println(f.denominator[i]);
		  }*/
	  //System.out.println(f.dev( 4,2,0 ,3));
	  f.setRange(20);
	  System.out.println(f.defaultRange);
	  
	}
}
