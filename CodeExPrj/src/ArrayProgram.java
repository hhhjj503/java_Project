
public class ArrayProgram {

	public static void main(String[] args) {
		
		//int[] nums = new int[]{1,2,3,4,5,6,7}; 과거버전
		//int[] nums = {1,2,3,4,5,6,7}; 버전이 업그레이드 되면서 추가된 방법
		//참조주소를 갖는 변수들읊 선언
		
		int[] nums= {1,2,3,4,5,6,7}; 
		
		for(int i =0;i<7;i++)
		System.out.printf("%d", nums[i]);
		System.out.println();
		int[] temp = new int[10];
		
		for(int i = 0; i<7;i++)
			temp[i] = nums[i];
		//nums[7] =8;
		
		nums = temp;
		nums[7] = 8;
		for(int i =0;i<8;i++)
			System.out.printf("%d", nums[i]);
		System.out.println();
		int[] nums1 = {1,2,3};
		int[] nums2 = {4,5,6};
		
		int[] nums3 = new int[6];
		
		for(int i = 0; i<6; i++)
			if(i < 3)
				nums3[i] = nums1[i];
			else
				nums3[i] = nums2[i-3];
		
		for(int i = 0; i<6;i++)
			System.out.printf("%d", nums3[i]);
		System.out.println();
		
		
		
		
	}

}
