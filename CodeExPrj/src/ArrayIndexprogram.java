
public class ArrayIndexprogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,2,7,4,6,1,3};
		
		int index = -1; //배열내부에서 찾아낸 인덱스번호
		
		for(int i = 0;i<7 ;i++) {
			System.out.printf("%d", nums[i]);
		}
		
		System.out.println();
		for(int i = 0;i<7;i++)
			if(nums[i] == 1) {
				index = i;
				break; //찾았으면 더이상 for 문 실행하지않음
			}
		
		System.out.printf("값이 1인 인덱스 번호는 : %d 입니다", index);
		System.out.println();
		
		System.out.println();
			
		for(int i = 0; i<7;i++)
			if(nums[i] == 1) {
				int temp = nums[i]; //바꾸려고하는 배열위치의 값을 임시변수에 저장한다
				nums[i] = nums[0];  //임시변수에 저장한 값을 가진 배열의 위치에 바꾸려는 값을 참조시킨다
				nums[0] = temp;  	//저장한 값을 바꾸려는 두번쨰 변수에 참조시킨다
					for(int j = 0; j<7;j++)
						System.out.printf("%d", nums[j]);
		}
		
		System.out.println();
		for(int i = 0;i<7;i++)
			if(nums[i] == 1) {
				index = i;
				break; //찾았으면 더이상 for 문 실행하지않음
			}
		System.out.printf("값이 1인 인덱스 번호는 : %d 입니다", index);
		
	}	

}
