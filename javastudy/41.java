
public class ShopServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopService obj1=ShopService.getInstance();
		ShopService obj2=ShopService.getInstance();

		if(obj1==obj2) {
			System.out.println("ShopService 같은 객체입니다.");
		}else {
			System.out.println("ShopService 객체가 다르다 ");
		}
	}

}
