package dsa;

public class BinarySearch {
	public static void main(String[] args) 
	{
			// TODO Auto-generated method stub
			int [] arr= {23,45,65,74,87,98};
			int mid;
			int data = 65;
			int i=0;
			int left =0;
			int right= arr.length-1;
			while(left<right) 
			{
				mid=(left+right)/2;
				if(data==arr[mid])
				{
					System.out.println("found number at index:"+mid);
				}
				else if(data<arr[mid]) 
				{
					right= mid- 1;
				}
				else 
				{
					left=mid+1;
				}
				break;
			}
	}

}
